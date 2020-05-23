package com.jinhang.Service;

import com.jinhang.dao.MapInfoDao;
import com.jinhang.dao.MapInstanceDao;
import com.jinhang.dao.ModelMetaAndTableFiledDao;
import com.jinhang.dao.SourceDao;
import com.jinhang.process.DTO.RelMetaAndTableFiledDTO;
import com.jinhang.process.model.MapInfo;
import com.jinhang.process.model.MapInstance;
import com.jinhang.utils.StringHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class MapInstanceService {
    @Autowired
    private MapInstanceDao mapInstanceDao;
    @Autowired
    private SourceDao sourceDao;
    @Autowired
    private MapInfoDao mapInfoDao;
    @Autowired
    private ModelMetaAndTableFiledDao modelMetaAndTableFiledDao;

    public void addMapInstances( List<MapInstance> mapInstances )
    {
        mapInstanceDao.addMapInstances( mapInstances);
    }

    public void EntityBatchInsert( String fields, List<String> datas,String tableName )
    {
        mapInstanceDao.EntityBatchInsert( fields,datas,tableName);
    }

    public void MapInstanceRun( List<String> mapIds )
    {
        // 暂时不考虑 MapIds.size()，先凑合着用
        try
        {
            int threadNum = mapIds.size();
            //Todo:应该直接用构造方法创建线程池，明确创建线程池的目的
            ExecutorService exec = Executors.newFixedThreadPool(threadNum);  //threadNum线程数

            List<Callable<Integer>> tasks = new ArrayList<>();
            Callable<Integer> task = null;
            for ( String mapId : mapIds ) {
                final String map_id = mapId ;
                task = new Callable<Integer>() {
                    @Override
                    public Integer call() throws Exception {
                        List<RelMetaAndTableFiledDTO> rels = modelMetaAndTableFiledDao.findDtoByMapId(map_id);
                        MapInfo mapInfo = mapInfoDao.findById(map_id);
                        // 读取原表数据
                        List<String> fkeys = RelMetaAndTableFiledDTO.GetSourceTableFields(rels);
                        String fields = "";
                        if( fkeys != null && fkeys.size() > 1 )
                            fields = StringUtils.join(fkeys, ",");
                        else
                            fields = "*";
                        List<Map> srcdatas = sourceDao.getDatasByFields( fields , mapInfo.getSource_table_name() );
                        if( srcdatas == null )
                            return 0 ;
                        // 拼接插入语句的字段
                        String colums = StringHelper.GetInsertColumns( RelMetaAndTableFiledDTO.GetDataModelFkeys( rels ) );
                        // 拼接插入语句的值
                        List<String> datas = StringHelper.GetInsertValues( srcdatas , RelMetaAndTableFiledDTO.GetSourceTableFields(rels) );
                        // 批量插入
                        EntityBatchInsert( colums ,datas ,mapInfo.getEntity_table_name() );
                        return 1;
                    }
                };
                tasks.add(task);
            }
            exec.invokeAll(tasks);
            exec.shutdown();
        }catch ( Exception e )
        {

        }

    }
}

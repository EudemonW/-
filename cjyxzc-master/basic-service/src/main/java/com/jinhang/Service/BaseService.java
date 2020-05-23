package com.jinhang.Service;

import com.jinhang.FastDFS.FastDFSClient;
import com.jinhang.dao.*;
import com.jinhang.model.*;
import com.jinhang.utils.StringHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class BaseService {
    @Autowired
    private DataModelDao dataModelDao;
    @Autowired
    private DeptDao deptDao;
    @Autowired
    private MetaDao metaDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private ProjDao projDao;
    @Autowired
    private FastDFSClient fastDFSClient;
    @Autowired
    private RelDataModelAndMetaDao relDataModelAndMetaDao;
    @Autowired
    private RelProjAndUserDao relProjAndUserDao;
    @Autowired
    private SourceDao sourceDao;

    public List<User> findUsers( )
    {
        return userDao.findAll();
    }

    public List<User> findUsersByDeptId( String id )
    {
        return userDao.findAllByDeptId( id );
    }

    public List<User> findAllByProjId( String id )
    {
        return userDao.findAllByProjId( id );
    }

    public List<Dept> findAllDept( )
    {
        return deptDao.findAll();
    }
    //
    public String uploadFile( MultipartFile srcFile ){
        try {
            return fastDFSClient.uploadFile(srcFile);
        }
        catch (IOException e )
        {
            return "";
        }
    }
    // RelDataModelAndMeta
    public void addRelDataModelAndMeta(String dataModelId, List<String> metaIds )
    {
        List<RelDataModelAndMeta> rels = new ArrayList<>();
        for ( String metaId:metaIds) {
            rels.add( new RelDataModelAndMeta(UUID.randomUUID().toString(),dataModelId,metaId,"valid" ) );
        }
        relDataModelAndMetaDao.add( rels );
    }
    public void deleteRelDataModelAndMeta(String dataModelId, String metaId )
    {
        relDataModelAndMetaDao.delete( dataModelId,metaId );
    }

    // RelProjAndUser
    public void addRelProjAndUser(String projId, List<String> userIds )
    {
        List<RelProjAndUser> rels = new ArrayList<>();
        for ( String userId : userIds) {
            rels.add( new RelProjAndUser(UUID.randomUUID().toString(),projId ,userId,"valid" ) );
        }
        relProjAndUserDao.add( rels );
    }
    public void deleteRelProjAndUser(String ProjId, String userId )
    {
        relProjAndUserDao.delete( ProjId,userId );
    }

    // meta
    public List<Meta> findAllMetasByDataModelId(String id )
    {
        return metaDao.findAllByDataModelId(id);
    }

    public List<Meta> findAllMetas( )
    {
        return metaDao.findAll();
    }

    public void addMeta( Meta dataModel )
    {
        metaDao.add( dataModel );
    }

    public void updateMeta( Meta dataModel )
    {
        metaDao.update( dataModel);
    }

    public Meta findMetaById(String id )
    {
        return metaDao.findById( id );
    }

    public void deleteMetaById(String id)
    {
        metaDao.deleteById( id );
    }

    // datamodel
    public List<DataModel> findAllDataModelByProjId(String projid )
    {
        return dataModelDao.findAllByProjId(projid);
    }

    public List<DataModel> findAllByProjIdAndModelType(String projid ,String type )
    {
        return dataModelDao.findAllByProjIdAndModelType( projid,type );
    }

    public List<DataModel> findAllDataModels( )
    {
        return dataModelDao.findAll();
    }

    public void addDataModel( DataModel dataModel )
    {
        dataModelDao.add( dataModel );
    }

    public void updateDataModel( DataModel dataModel )
    {
        dataModelDao.update( dataModel);
    }

    public DataModel findDataModelById(String id )
    {
        return dataModelDao.findById( id );
    }

    public void deleteDataModelById(String id)
    {
        dataModelDao.deleteById( id );
    }

    public void createTable(  String srcTableName , String dstTableName ,Map<String,String> map )
    {
        // 源数据库中建表语句
        List<String> srcList = showCreateTableSQLLines(srcTableName);

        // 目标表建表语句
        String createSql = StringHelper.GetCreateTableSQL(srcList,srcTableName ,dstTableName ,map );

        dataModelDao.createTable( createSql );
    }

    // proj
    public List<Project> findAllProjsByDeptId(String id )
    {
        return projDao.findAllByDeptId(id);
    }

    public List<Project> findAllProjs( )
    {
        return projDao.findAll();
    }

    public void addProject( Project project )
    {
        projDao.add( project );
    }

    public void updateProject( Project project )
    {
        projDao.update( project);
    }

    public Project findProjectById(String id )
    {
        return projDao.findById( id );
    }

    public void deleteProjectById(String id)
    {
        projDao.deleteById( id );
    }

    //
    public List<Map> listTable(){
        return sourceDao.listTable();
    }

    public List<Map> listTableColumn( String tableName){
        return sourceDao.listTableColumn(tableName);
    }

    public List<String> showCreateTableSQLLines( String tableName )
    {
        Map map = sourceDao.showCreateTableSQL(tableName);
        String srcSql = map.get("Create Table").toString();
        List<String> srcList = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream( srcSql.getBytes(Charset.forName("utf8"))), Charset.forName("utf8")));
            String line;
            while ( (line = br.readLine()) != null ) {
                srcList.add(line.trim());
            }
        }catch (IOException e )
        {

        }
        return srcList;
    }
    public List<Map> getDatasByFields( List<String> fkeys , String tableName )
    {
        String fields = "";
        if( fkeys != null && fkeys.size() > 1 )
            fields = StringUtils.join(fkeys, ",");
        else
            fields = "*";
        return sourceDao.getDatasByFields(fields,tableName);
    }
}

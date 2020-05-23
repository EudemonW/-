package com.jinhang;

import com.jinhang.Service.BaseService;
import com.jinhang.Service.MapInstanceService;
import com.jinhang.Service.MapService;
import com.jinhang.Service.ProcessService;
import com.jinhang.VO.*;
import com.jinhang.model.DataModel;
import com.jinhang.process.DTO.RelMetaAndTableFiledDTO;
import com.jinhang.process.VO.MapInfoBasic;
import com.jinhang.process.VO.MapInfos;
import com.jinhang.process.VO.ModelMetaAndTableFiledBasic;
import com.jinhang.process.model.MapInfo;
import com.jinhang.utils.ShortUUIDGenerator;
import com.jinhang.utils.StringHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class ProcessTest {
    @Autowired
    private BaseService baseService;
    @Autowired
    private ProcessService processService;
    @Autowired
    private MapService mapService;
    @Autowired
    private MapInstanceService mapInstanceService;

    @Test
    void PreProcessConfigTest()
    {
        PreprocessProcessConfig preprocessProcessConfig = new PreprocessProcessConfig();
        preprocessProcessConfig.setMain_process_id("preprocess_test_process_id");
        ProcessNodeBasic startNode = new ProcessDataNode();
        startNode.setProcess_id("");
        startNode.setProcess_type_id("");

        List<ProcessEdgeBasic> process_edges_basics = new ArrayList<>();
        List<ProcessDataNode> process_data_nodes = new ArrayList<>();
        ProcessMapNode processMapNode = new ProcessMapNode();
        List<ProcessPreprocessNode> process_preprocess_nodes = new ArrayList<>();




        preprocessProcessConfig.setProcessMapNode( processMapNode );
        preprocessProcessConfig.setProcess_preprocess_nodes( process_preprocess_nodes );
        preprocessProcessConfig.setProcess_data_nodes( process_data_nodes );
        preprocessProcessConfig.setProcess_edges_basics( process_edges_basics );
    }
}

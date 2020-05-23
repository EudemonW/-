package com.jinhang.process.model;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class MainProcess {
    private String id;

    private String begin_node_id;
    private String preprocess_node_id;
    private String data_fusion_node_id;
    private String calc_node_id;
    private String end_node_id;

    public void Init( String main_process_id  )
    {
        this.id = main_process_id;

        this.begin_node_id = UUID.randomUUID().toString();
        this.preprocess_node_id = UUID.randomUUID().toString();
        this.data_fusion_node_id = UUID.randomUUID().toString();
        this.calc_node_id = UUID.randomUUID().toString();
        this.end_node_id = UUID.randomUUID().toString();

    }
}

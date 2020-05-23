package com.jinhang.VO;

import lombok.Data;

import java.util.List;

@Data
public class ProcessConfigBasic {
    private String main_process_id;
    private List<ProcessEdgeBasic > process_edges_basics;
    private List<ProcessDataNode > process_data_nodes;
}

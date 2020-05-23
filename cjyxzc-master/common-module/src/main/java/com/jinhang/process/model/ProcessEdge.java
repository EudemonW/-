package com.jinhang.process.model;

import lombok.Data;

@Data
public class ProcessEdge {
    private String id;
    private String process_id;
    private String edge_desc;
    private String process_node_from;
    private String process_node_to;
}

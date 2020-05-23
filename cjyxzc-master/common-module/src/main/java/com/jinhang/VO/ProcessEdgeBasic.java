package com.jinhang.VO;

import lombok.Data;

@Data
public class ProcessEdgeBasic {
    private String process_id;
    private String process_node_from;
    private String process_node_to;
    private String edge_desc;
}

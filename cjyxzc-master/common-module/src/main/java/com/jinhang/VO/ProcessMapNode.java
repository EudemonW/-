package com.jinhang.VO;

import com.jinhang.process.model.ProcessNode;
import lombok.Data;

@Data
public class ProcessMapNode extends ProcessNode {
    private MapNodeRefTable mapNodeRefTable;
}

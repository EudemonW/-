package com.jinhang.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PreprocessProcessConfig extends ProcessConfigBasic {
    private ProcessMapNode processMapNode;
    private List<ProcessPreprocessNode > process_preprocess_nodes;
}

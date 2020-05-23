package com.jinhang.VO;

import lombok.Data;

import java.util.List;

@Data
public class ProcessPreprocessNode extends ProcessNodeBasic{
    private List<RefWorkBasic> refWorkBasics;
}

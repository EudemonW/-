package com.jinhang.commons;

public interface ProcessEnum {
    enum PROCESS_TYPE implements ProcessEnum{
        MAPPING,PROCESS
    }

    enum TIMER implements ProcessEnum{
        DAILY
    }

}

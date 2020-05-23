package com.jinhang.commons;

public interface DataModelEnum {
//    enum DATAMODEL_TYPE implements DataModelEnum
//    {
//        DATA_SOURCE("数据源模型"),
//        DATA_ETL("数据清洗过程模型"),
//        DATA_ENTITTY("数据实体模型"),
//        DATA_CALC("数据计算过程模型"),
//        DATA_RESULT("数据结果模型");
//        private String name;
//        private DATAMODEL_TYPE(String name )
//        {
//            this.name = name;
//        }
//        public String getName()
//        {
//            return this.name;
//        }
//    }
    enum DATAMODEL_TYPE implements DataModelEnum
    {
        数据源模型,数据清洗过程模型,数据实体模型,数据计算过程模型,数据结果模型
    }
}

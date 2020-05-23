package com.jinhang.result;

import lombok.Data;

@Data
public class HttpResult<T> {
    private String Message;
    private boolean Success;
    private ResultCode Code;
    private T Data;
}

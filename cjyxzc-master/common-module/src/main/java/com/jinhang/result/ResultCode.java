package com.jinhang.result;


public enum ResultCode {
    SUCCESS( 200, "success" ), // 正确请求
    SYSTEM_ERROR( 500, "failure" ),// 请求错误
    INVALID_PARAM( 1300,"invalid params"),
    MISTYPE_PARAM( 1301,"mistype params"),
    MISSING_PARAM( 1302,"missing params"),
    UNSUPPORTED_METHOD( 1303,"unsupported method");

    /** 主键 */
    private final Integer code;

    /** 描述 */
    private final String Message;

    ResultCode(final Integer code, final String msg) {
        this.code = code;
        this.Message = msg;
    }

    public ResultCode getCode() {
        return this;
    }

    public String getMessage() {
        return this.Message;
    }
}

package com.example.flowable.common.core.vo;

public enum CodeEnums {
    /* Base */
    SERVICE_SUCESS(1000, "操作成功"),
    SERVICE_ERROR(1001, "操作失败"),

    /* Permission */
    UNAUTHENTICATED( 2001, "您还未登录"),
    UNAUTHORISE( 2002, "权限不足"),

    /* Service Custom */
    START_SUCCESS(3001,"启动成功"),
    START_ERROR(3002,"启动失败"),
    PROCESS_INST_NOT_RUN(3010, "流程未启动");


    //操作代码    
    int code;
    // 提示信息    
    String message;

    CodeEnums(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int code() {
        return code;
    }

    public String message() {
        return message;
    }

}

package com.example.flowable.common.core.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResultVo {
    private int code;
    private String msg;
    private Object data;// 返回数据


    /**
     * 构造(不返回数据)
     *
     * @param code
     */
    public ResultVo(CodeEnums code) {
        this.code = code.code;
        this.msg = code.message;
    }

    /**
     * 构造(需返回数据)
     *
     * @param code
     */
    public ResultVo CUSTOM(CodeEnums code,Object data) {
        ResultVo resultVo =  new ResultVo(code);
        resultVo.setData(data);
        return resultVo;
    }

}

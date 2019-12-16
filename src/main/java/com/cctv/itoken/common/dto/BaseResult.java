package com.cctv.itoken.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author zb
 * @create 2019-12-16 14:57
 */
@Data
public class BaseResult implements Serializable {
    public static final String RESULT_OK="ok";
    public static final String RESULT_NOT_OK="not_ok";
    public static final String SUCCESS="操作成功";
    private String result;
    private Object data;
    private String success;
    private Curson curson;
    private List<Error> errors;

    public static BaseResult ok(Object data){
        return createResult(RESULT_OK,data,SUCCESS,null,null);
    }

    public static BaseResult ok(){
        return createResult(RESULT_OK,null,SUCCESS,null,null);
    }

    public static BaseResult notOk(List<Error> errors){
        return createResult(RESULT_NOT_OK,null,"",null,errors);
    }

    /**
     *
     * @param result
     * @param data
     * @param success
     * @param curson
     * @param errors
     * @return
     */
    private static BaseResult createResult(String result,Object data,String success,Curson curson,
                                           List<Error> errors){
        BaseResult baseResult=new BaseResult();
        baseResult.setCurson(curson);
        baseResult.setData(data);
        baseResult.setErrors(errors);
        baseResult.setResult(result);
        baseResult.setSuccess(success);
        return baseResult;
    }

    @Data
    public static class Curson{
        private int total;
        private int offset;
        private int limit;
    }

    @Data
    @AllArgsConstructor
    public static class Error{
        private String field;
        private String message;
    }
}

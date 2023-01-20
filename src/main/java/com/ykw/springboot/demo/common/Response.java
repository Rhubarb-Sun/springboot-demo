package com.ykw.springboot.demo.common;

import lombok.Data;

/**
 * @author: sunxun
 * @date: 12/26/22 5:58 PM
 * @description:
 */

@Data
public class Response {

    private boolean isOk;
    private int code;
    private Object data;
    private String msg;

    public static Response success() {
        Response response = new Response();
        response.setCode(200);
        response.setOk(true);
        response.setMsg("Response succeeded!");
        return response;
    }

    public static Response success(Object obj) {
        Response response = new Response();
        response.setCode(200);
        response.setOk(true);
        response.setMsg("Response succeeded!");
        response.setData(obj);
        return response;
    }
}

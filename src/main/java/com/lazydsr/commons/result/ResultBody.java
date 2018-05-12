package com.lazydsr.commons.result;

import com.lazydsr.util.time.UtilDateTime;

import java.io.Serializable;
import java.util.Date;

/**
 * Coding......
 * Created by D.SR on 2017/3/5.
 */
public class ResultBody implements Serializable {
    public static final String JSON = "json";
    public static final String HTML = "html";
    public static final String TEXT = "text";
    /**
     * 返回码
     *
     * @see HttpStatus
     * 或者自定义错误码
     */
    private int code;
    /**
     * 返回错误信息
     *
     * @see HttpStatus
     * 或者自定义错误信息
     */
    private String msg;
    /**
     * url
     */
    private String url;
    /**
     * 数据类型
     * JSON HTML TEXT
     */
    private String dataType;
    /**
     * 返回数据data
     * 该data可为map或者其他
     */
    private Object data;
    /**
     * 返回数据data
     * 该data可为map或者其他
     */
    private Object data0;
    /**
     * 时间
     * 默认异常的捕获时间
     */
    private String datetime=new Date().getTime()+"";


    public static ResultBody success() {
        return new ResultBody(HttpStatus.OK);
    }

    public static ResultBody success(Object data) {
        return new ResultBody(HttpStatus.OK, data);
    }

    public static ResultBody success(HttpStatus status, Object data) {
        return new ResultBody(status, data);
    }

    public static ResultBody success(int code, String msg, Object data) {
        return new ResultBody(code, msg, data);
    }


    public static ResultBody error() {
        return new ResultBody(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static ResultBody error(Object data) {
        return new ResultBody(HttpStatus.INTERNAL_SERVER_ERROR, data);
    }

    public static ResultBody error(HttpStatus status, Object data) {
        return new ResultBody(status, data);
    }

    public static ResultBody error(int code, String msg, Object data) {
        return new ResultBody(code, msg, data);
    }


    public ResultBody() {
        this.datetime = UtilDateTime.getCurrDateTime();
    }

    public ResultBody(int code) {
        this();
        this.code = code;
    }

    public ResultBody(int code, String msg) {
        this(code);
        this.msg = msg;
    }

    public ResultBody(HttpStatus status) {
        this(status.value(), status.getReasonPhrase());
    }

    public ResultBody(HttpStatus status, Object data) {
        this(status.value(), status.getReasonPhrase());
        this.data = data;
    }

    public ResultBody(int code, String msg, String url) {
        this(code, msg);
        this.url = url;
    }

    public ResultBody(int code, String msg, String url, String dataType) {
        this(code, msg, url);
        this.dataType = dataType;
    }

    public ResultBody(int code, String msg, String url, String dataType, Object data) {
        this(code, msg, url, dataType);
        this.data = data;
    }

    public ResultBody(int code, String msg, String url, String dataType, Object data, Object data0) {
        this(code, msg, url, dataType, data);
        this.data0 = data0;
    }

    public ResultBody(int code, String msg, String url, String dataType, Object data, Object data0, String datetime) {
        this(code, msg, url, dataType, data, data0);
        this.datetime = datetime;
    }

    public ResultBody(int code, String msg, Object data) {
        this(code, msg);
        this.data = data;
    }

    public ResultBody(int code, String msg, String url, Object data) {
        this(code, msg, url);
        this.data = data;
    }


    //get  set
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getData0() {
        return data0;
    }

    public void setData0(Object data0) {
        this.data0 = data0;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return "ResultBody{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", url='" + url + '\'' +
                ", dataType='" + dataType + '\'' +
                ", data=" + data +
                ", data0=" + data0 +
                ", datetime='" + datetime + '\'' +
                '}';
    }
}

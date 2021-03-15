package com.zhiyou100.video.model;

/**
 *
 * 充当的作用是 同一服务器短发送给客户端的数据格式
 * 后端发送过来的值一般都是json值
 *
 *
 * code 状态码     200代表请求成功  404 请求资源路径找不到 201 302 304 400 401 403
 * msg  信息       对返回值的说明
 * data 数据
 */
public class ResultObject {

    private  int code;//状态码
    private String msg;//对返回值的信息说明
    private Object data;//需要返回的数据

    public ResultObject() {
    }

    public ResultObject(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultObject{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}

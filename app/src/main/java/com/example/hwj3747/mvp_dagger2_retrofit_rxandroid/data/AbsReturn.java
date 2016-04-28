package com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.data;

/**
 * Created by Administrator on 2015/12/29.
 */
public class AbsReturn<V,T> {
    String message;
    V data;
    T obj;
    int  code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public V getData() {
        return data;
    }

    public void setData(V data) {
        this.data = data;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}

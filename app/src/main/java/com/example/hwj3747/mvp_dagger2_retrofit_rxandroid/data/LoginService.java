package com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.data;


import java.util.concurrent.TimeUnit;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import rx.Observable;

/**
 * Created by Administrator on 2016/1/28.
 *
 */
public class LoginService {

    private static final String FORUM_SERVER_URL = "http://192.168.1.151:8888";/*Tip:这里写域名，目前在本地测试可以用服务器的电脑的ip地址+端口号*/
    private AbsApi mAbsApi;

    public LoginService() {

        RequestInterceptor requestInterceptor = request -> {
            request.addHeader("Accept", "text/html");
            //request.addHeader("token",ConfigUtil.getToken());
            request.addHeader("os","Android");
            request.addHeader("ver","1");
        };


        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(FORUM_SERVER_URL)
                .setRequestInterceptor(requestInterceptor)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        mAbsApi = restAdapter.create(AbsApi.class);
    }
    public AbsApi getApi() {

        return mAbsApi;
    }

    public interface AbsApi {
        @FormUrlEncoded
        @POST("/app/admin/test")/*Tip：这连个注解记得不能丢，如果是请求的方法中不带参数就用@GET 带参数用@POST*/
        Observable<String> validateLogin (@Field("userName") String name,@Field("userPwd") String pwd);//登录验证
        /*Tip:每个参数都要加上@Field*   返回值Observable<String> 类型所包含的字段要跟服务端返回json格式中的字段命名要一样，这个等我服务端做好会告诉你们*/
    }

}

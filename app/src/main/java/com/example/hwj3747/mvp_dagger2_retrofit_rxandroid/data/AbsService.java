package com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.data;


import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.http.GET;
import rx.Observable;

/**
 * Created by Administrator on 2016/1/28.
 */
public class AbsService {

    private static final String FORUM_SERVER_URL = "http://115.159.102.128:9000";
    private AbsApi mAbsApi;

    public AbsService() {

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
                        // .setClient(new OkClient(new OkHttpClient()))
                .build();

        mAbsApi = restAdapter.create(AbsApi.class);
    }
    public AbsApi getApi() {

        return mAbsApi;
    }

    public interface AbsApi {

        @GET("/sys/sms")
        Observable<AbsReturn<DefaultData,DefaultObj>>
        test();//发送验证码
    }
}

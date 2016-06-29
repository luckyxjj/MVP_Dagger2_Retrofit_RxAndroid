package com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.common;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.data.AbsReturn;

import java.net.ConnectException;

import rx.Observer;

public abstract class EndObserver<T> implements Observer<T> {
    public abstract void onEnd();
    public abstract void onMyNext(T entity);

    static Context mContext;
    public static void init(Context context){
        mContext=context;
    }

    @Override
    public void onCompleted() {
        onEnd();
    }

    @Override
    public void onError(Throwable e) {

        Throwable e1=new Throwable(new ConnectException());
        Log.i("error", e1.toString());

        onEnd();
        if((ConnectException)e instanceof ConnectException)
            Log.i("error", e.toString());
       // onEnd();
        if(e.toString().indexOf("failed to connect to")!=-1)
            Toast.makeText(mContext,"网络异常,请检查网络设置",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNext(T entity) {
        /*if(((AbsReturn) entity).getCode()==101){
            Toast.makeText(mContext,"登录失效，请重新登录",Toast.LENGTH_SHORT).show();
        }*/
        if(entity instanceof AbsReturn) {
            if (((AbsReturn) entity).getCode() == 101) {
                Toast.makeText(mContext, "登录失效，请重新登录", Toast.LENGTH_SHORT).show();
            }
        }

        onMyNext(entity);
    }
}

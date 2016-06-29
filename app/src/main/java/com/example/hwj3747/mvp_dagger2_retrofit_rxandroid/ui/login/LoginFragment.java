package com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.ui.login;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.R;
import com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.base.BaseFragment;
import com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.present.LoginPresenter;
import com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.view.LoginView;
import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import icepick.Icepick;
import icepick.State;

import static com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.common.App.getAppComponent;

/**
 * A placeholder fragment containing a simple view.
 */
public class LoginFragment extends BaseFragment<LoginView,LoginComponent,LoginPresenter> implements LoginView {
    /*Tip：这里继承View接口、Component、Presenter,实现View接口*/
    @Inject
    LoginPresenter presenter;/*Tip:把presenter引进来*/

   /* @State
    String mCodeData;*/
    @InjectView(R.id.et_name)
    TextView et_name;/*Tip:初始化界面中的控件只要这样写就好了，不用findViewById*/

    @InjectView(R.id.et_pwd)
    TextView et_pwd;

    @InjectView(R.id.btn_login)
    TextView btn_login;


    public LoginFragment() {
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getComponent().inject(this);
        Icepick.restoreInstanceState(this, savedInstanceState);
    }

    @Override
    protected int getLayoutID() {/*Tip:拿到Frigment*/
        return R.layout.fragment_logint;
    }

    @Override
    protected View getLoadingTargetView() {/*Tip:这里要注意是写Fragment中最外层的layout的ID*/
        return findById(R.id.login_fragment);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {/*Tip:可以在这个方法里做获取界面值，添加监听事件等操作*/
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.inject(this, view);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = et_name.getText().toString();
                String pwd = et_pwd.getText().toString();
                presenter.getValue(name,pwd);/*Tip：调用presenter中的方法*/
            }
        });

    }



    @Override
    protected void onViewInit() {

    }

    @Override
    protected LoginComponent onCreateNonConfigurationComponent() {
        return DaggerLoginComponent.builder()
                .appComponent(getAppComponent(mActivity))
                .build();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        // Save state of all @State annotated members
        Icepick.saveInstanceState(this, outState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.inject(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @Override
    public void show(String value) {/*Tip：这里接受从presenter中传过来的值，可以在这里做给界面传值等操作，如下面的例子*/
        //tv_show.setText(value);
        Toast.makeText(getApplicationContext(),value, Toast.LENGTH_SHORT).show();
    }
}

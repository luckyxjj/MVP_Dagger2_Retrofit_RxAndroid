package com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.ui.test;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.R;
import com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.base.BaseFragment;
import com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.present.TestPresenter;
import com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.view.TestView;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import icepick.Icepick;
import icepick.State;

import static com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.common.App.getAppComponent;

/**
 * A placeholder fragment containing a simple view.
 */
public class TestActivityFragment extends BaseFragment<TestView,TestComponent,TestPresenter> implements TestView {

    @Inject
    TestPresenter presenter;


    @State
    String mCodeData;
    @InjectView(R.id.text)
    TextView t;


    public TestActivityFragment() {
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getComponent().inject(this);
        Icepick.restoreInstanceState(this, savedInstanceState);
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_test;
    }

    @Override
    protected View getLoadingTargetView() {
        return findById(R.id.text);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.inject(this, view);
        t.setText("test");
    }


    @Override
    protected void onViewInit() {

    }

    @Override
    protected TestComponent onCreateNonConfigurationComponent() {
        return DaggerTestComponent.builder()
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
}

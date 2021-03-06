package com.yzs.yzsbaseactivity.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.yzs.yzsbaseactivity.R;
import com.yzs.yzsbaseactivitylib.entity.EventCenter;
import com.yzs.yzsbaseactivitylib.fragment.YzsBaseFragment;
import com.yzs.yzsbaseactivitylib.util.LoadingDialogUtils;


/**
 * Author: 姚智胜
 * Version: V1.0版本
 * Description:
 * Date: 2016/12/28.
 */
public class MyFragment extends YzsBaseFragment {
    private static final String TAG = "MyFragment";
    TextView textView;
    Handler handler = new Handler();
    ProgressBar progressBar;
    private int num;

    private int aa;

    public static MyFragment newInstance(Bundle args) {
        MyFragment fragment = new MyFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected View initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e("第" + num + "MyFragment", num + "initContentView");
        View view = inflater.inflate(R.layout.my_fragment, container, false);
//        view.findViewById(R.id.textview);
        initView(view);
        return view;
    }

    //    @Override
    protected void initView(View view) {
        textView = (TextView) view.findViewById(R.id.textview);
        textView.setText("第" + num + "MyFragment");
//        progressBar = (ProgressBar) view.findViewById(R.id.progress_bar);
//        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    protected void initLogic() {

    }
//
////    @Override
////    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
////        super.onLazyInitView(savedInstanceState);
//
////
////    }


    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        LoadingDialogUtils.showLoadingDialog();
        Log.e("第" + num + "MyFragment", num + "initLogic");
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
//                textView.setText("第" + num + "MyFragment");
//                progressBar.setVisibility(View.GONE);
                LoadingDialogUtils.cancelLoadingDialog();
            }
        }, 2000);
    }

//    @Override
//    protected void initLogic() {
//
//    }


    @Override
    protected void getBundleExtras(Bundle bundle) {
        num = bundle.getInt("num", -1);
        Log.e("第" + num + "MyFragment", num + "getBundleExtras");
    }

    @Override
    protected void onEventComing(EventCenter center) {

    }

}

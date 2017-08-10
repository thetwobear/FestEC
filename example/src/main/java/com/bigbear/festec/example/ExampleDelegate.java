package com.bigbear.festec.example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.bigbear.bigbear_core.app.BigBear;
import com.bigbear.bigbear_core.delegates.BigBearDeleate;
import com.bigbear.bigbear_core.net.RestClient;
import com.bigbear.bigbear_core.net.callback.IError;
import com.bigbear.bigbear_core.net.callback.IFailure;
import com.bigbear.bigbear_core.net.callback.IRequest;
import com.bigbear.bigbear_core.net.callback.ISuccess;

/**
 * Created by 熊猿猿 on 2017/8/9/009.
 */

public class ExampleDelegate extends BigBearDeleate {

    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        test();
    }

    private void test() {
        RestClient.builder()
                .url("http://www.baidu.com/")
                .onRequest(new IRequest() {
                    @Override
                    public void onRequestStart() {
                        System.out.println("开始请求");
                    }

                    @Override
                    public void onRequestEnd() {
                        System.out.println("请求结束");
                    }
                })
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        Toast.makeText(BigBear.getApplication(), response, Toast.LENGTH_SHORT).show();
                    }
                })
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {
                        System.out.println("请求失败");
                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(int code, String msg) {
                        System.out.println(msg);
                    }
                })
                .build()
                .rxGet();
    }
}
package com.x.fastec.example;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.x.x_core.app.XCore;
import com.x.x_core.net.interceptors.DebugInterceptor;
import com.x.x_ec.database.DatabaseManger;
import com.x.x_ec.icon.FontEcModule;

/**
 * Created by bear on 2017/8/7/007.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        XCore.init(this)
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())
                .withApiHost("http://127.0.0.1/index/")
                .withLoaderDelayed(1000)
                .withWeChatAppId("")//微信AppId
                .withWeChatAppSecret("")//微信AppSecret
                .withInterceptor(new DebugInterceptor("index", R.raw.test))
                .configure();
        DatabaseManger.getInstance().init(this);
        initStetho();
    }

    //FaceBook Chrome 调试初始化
    private void initStetho() {
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                        .build()
        );
    }


}

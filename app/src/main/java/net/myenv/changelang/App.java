package net.myenv.changelang;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

public class App extends Application {


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleManager.setNewLocale(base,LocaleManager.LANGUAGE_POLISH));
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        LocaleManager.setLocale(this);
    }
}

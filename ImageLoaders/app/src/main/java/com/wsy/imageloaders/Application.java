package com.wsy.imageloaders;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by songyewang on 16/9/21.
 */
public class Application extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}

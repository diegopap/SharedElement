package com.fdvsolutions.android.sharedelement;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by diego on 06/02/17.
 */

public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}

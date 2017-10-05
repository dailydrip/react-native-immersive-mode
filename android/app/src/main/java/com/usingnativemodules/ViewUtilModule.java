package com.usingnativemodules;

import android.view.WindowManager;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

/**
 * Created by franzejr on 10/5/17.
 */

public class ViewUtilModule extends ReactContextBaseJavaModule {
    private final ReactApplicationContext reactContext;

    public ViewUtilModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "ViewUtil";
    }

    @ReactMethod
    public void keepScreenAwake(){
        getCurrentActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                getCurrentActivity().getWindow()
                        .addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
            }
        });

    }

    @ReactMethod
    public void removeScreenAwake(){
        getCurrentActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                getCurrentActivity().getWindow()
                        .clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
            }
        });
    }
}

package com.android_api_keyevent_bridge;

import com.facebook.react.ReactActivity;
import com.android_api_keyevent_bridge.ReactKeyEvent;

import android.view.KeyEvent;

public class MainActivity extends ReactActivity {

    @Override
    protected String getMainComponentName() {
        return "android_api_keyevent_bridge";
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        // ReactKeyEvent reactKeyEvent = ReactKeyEvent.instance();
        // if (reactKeyEvent != null)
        //     return reactKeyEvent.onKeyDown(keyCode, event);
        // else return true;
        return true;
    }
}

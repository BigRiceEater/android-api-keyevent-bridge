package com.android_api_keyevent_bridge;

import android.widget.Toast;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.modules.core.DeviceEventManagerModule;

import android.view.KeyEvent;

public class ReactKeyEvent extends ReactContextBaseJavaModule {

    private ReactContext _reactContext;
    private DeviceEventManagerModule.RCTDeviceEventEmitter _emitter = null;
    static String KEY_DOWN_EVENT = "onKeyDown";

    private static ReactKeyEvent _this = null;

    public ReactKeyEvent(ReactApplicationContext reactContext) {
        super(reactContext);
        _reactContext = reactContext;
        if (_reactContext.hasActiveCatalystInstance()){
            // getJSModule causes problems when the rn instance is not fully initialized yet
            // how to receive event rn is now available ? 
            _emitter = _reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
        }
        _this = this;
    }



    public static ReactKeyEvent instance(){
        return _this;
    }
    
    @Override
    public String getName() {
        return "ReactKeyEvent";
    }
    
    @ReactMethod
    public void alert(String message) {
        Toast.makeText(getReactApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    public boolean onKeyDown(int keyCode, KeyEvent event){
        if (_emitter != null)
            _emitter.emit(KEY_DOWN_EVENT, "params here");
        return true;
    } 
}
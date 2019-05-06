package com.android_api_keyevent_bridge;

import android.widget.Toast;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.bridge.WritableMap;


import android.view.KeyEvent;

public class ReactKeyEvent extends ReactContextBaseJavaModule {

    private ReactContext _reactContext;
    private DeviceEventManagerModule.RCTDeviceEventEmitter _emitter = null;
    static String KEY_DOWN_EVENT = "onKeyDown";

    private static ReactKeyEvent _this = null;

    public ReactKeyEvent(ReactApplicationContext reactContext) {
        super(reactContext);
        _reactContext = reactContext;
        _this = this;
    }

    private DeviceEventManagerModule.RCTDeviceEventEmitter getEmitter(){
        if (_emitter != null){
            return _emitter;
        }

        if (_reactContext.hasActiveCatalystInstance()){
            // getJSModule causes problems when the rn instance is not fully initialized yet
            // how to receive event rn is now available ? 
            _emitter = _reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
            return _emitter;
        }
        else 
            return null;
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
        // try {
            WritableMap params = new WritableNativeMap();
            char pressedKey = (char) event.getUnicodeChar();
            params.putString("pressedKey", String.valueOf(pressedKey));

            getEmitter().emit(KEY_DOWN_EVENT, params);
        // } catch(Exception e){

        // } finally {
         return true;
        // }
    } 
}
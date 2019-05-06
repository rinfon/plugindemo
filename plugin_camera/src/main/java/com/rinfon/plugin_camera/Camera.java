package com.rinfon.plugin_camera;

import android.util.Log;

import com.rinfon.apis.ICamera;

public class Camera implements ICamera {
    @Override
    public void echo() {
        Log.i("Camera","echo hello");
    }
}

package com.rinfon.bridge;

import com.rinfon.apis.ICamera;
//import com.rinfon.plugin_camera.Camera;

import java.util.HashMap;

public class Bridge {

    private static final Bridge ourInstance = new Bridge();

    public static Bridge getInstance() {
        return ourInstance;
    }

    HashMap<Class, Class> build;

    private Bridge() {
        build = new HashMap<Class, Class>();
//        this is bettter
//        register(ICamera.class, Camera.class);
        register(ICamera.class, "com.rinfon.plugin_camera.Camera");
    }

    public Bridge register(Class interfaceClass, Class apiClass) {
        build.put(interfaceClass, apiClass);
        return this;
    }

    public Bridge register(Class interfaceClass, String apiClassName) {
        try {
            Class t = Class.forName(apiClassName);
            build.put(interfaceClass, t);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return this;
    }


    public <T> T plugin(Class<T> type) {
        try {
            return (T) build.get(type).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}

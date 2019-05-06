package com.rinfon.plugin_camera;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rinfon.apis.ICamera;

public class CarmeraMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ICamera iCamera = new Camera();
        iCamera.echo();
    }
}

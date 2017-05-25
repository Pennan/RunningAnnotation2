package com.np.ioc_example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.np.ioc.MyAnnotation;

@MyAnnotation(value = "我注解在了 MainActivity 上.")
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

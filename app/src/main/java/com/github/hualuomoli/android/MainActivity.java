package com.github.hualuomoli.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.github.hualuomoli.logger.Logger;
import com.github.hualuomoli.logger.android.AndroidLogger;


public class MainActivity extends AppCompatActivity {

    private Button testLoggerButton;
    private Button testSecurityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 设置日志输出
        Logger.setLogger(new AndroidLogger());

        Intent intent = new Intent(MainActivity.this, com.github.hualuomoli.sample.MainActivity.class);
        startActivity(intent);

        // end
    }
}

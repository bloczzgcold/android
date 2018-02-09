package com.github.hualuomoli.android;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.github.hualuomoli.logger.Level;
import com.github.hualuomoli.logger.Logger;

public class MainActivity extends AppCompatActivity {

    private static final String TAG1 = "MainActivity1";
    private static final String TAG2= "MainActivity2";
    private static final String TAG3 = "MainActivity3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 未设置级别，默认关闭
        Logger.verbose(TAG1, "this is verbose message.");
        Logger.debug(TAG1, "this is debug message.");
        Logger.info(TAG1, "this is info message.");
        Logger.warn(TAG1, "this is warn message.");
        Logger.error(TAG1, "this is errro message.");

        // 设置级别为warn
        Logger.setLevel(Level.WARN);
        Logger.verbose(TAG2, "this is verbose message.");
        Logger.debug(TAG2, "this is debug message.");
        Logger.info(TAG2, "this is info message.");
        Logger.warn(TAG2, "this is warn message.");
        Logger.error(TAG2, "this is errro message.");

        // 设置级别为ALL
        Logger.setLevel(Level.ALL);
        Logger.verbose(TAG3, "this is verbose message.");
        Logger.debug(TAG3, "this is debug message.");
        Logger.info(TAG3, "this is info message.");
        Logger.warn(TAG3, "this is warn message.");
        Logger.error(TAG3, "this is errro message.");

    }
}

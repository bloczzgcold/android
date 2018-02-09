package com.github.hualuomoli.android.logger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;
import com.github.hualuomoli.android.R;
import com.github.hualuomoli.logger.Level;
import com.github.hualuomoli.logger.Logger;

public class LoggerActivity extends AppCompatActivity {

    private static final String TAG = "LoggerActivity";

    private RadioGroup group;
    private Button showLogButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logger);

        // 默认输出所有日志
        Logger.setLevel(Level.ALL);

        group = findViewById(R.id.logger_level);

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.logger_level_all:
                        Logger.setLevel(Level.ALL);
                        break;
                    case R.id.logger_level_verbose:
                        Logger.setLevel(Level.VERBOSE);
                        break;
                    case R.id.logger_level_debug:
                        Logger.setLevel(Level.DEBUG);
                        break;
                    case R.id.logger_level_info:
                        Logger.setLevel(Level.INFO);
                        break;
                    case R.id.logger_level_warn:
                        Logger.setLevel(Level.WARN);
                        break;
                    case R.id.logger_level_error:
                        Logger.setLevel(Level.ERROR);
                        break;
                    case R.id.logger_level_off:
                        Logger.setLevel(Level.OFF);
                        break;
                }
                // end
            }
        });

        showLogButton = findViewById(R.id.showLog);
        showLogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLog();
                Toast.makeText(LoggerActivity.this, "日志已输出，请查看", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void showLog() {
        Logger.verbose(TAG, "this is verbose message.");
        Logger.debug(TAG, "this is debug message.");
        Logger.info(TAG, "this is info message.");
        Logger.warn(TAG, "this is warn message.");
        Logger.error(TAG, "this is errro message.");
    }

}

package com.github.hualuomoli.android;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.github.hualuomoli.android.logger.LoggerActivity;
import com.github.hualuomoli.logger.Level;
import com.github.hualuomoli.logger.Logger;

public class MainActivity extends AppCompatActivity {

    private Button testLoggerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testLoggerButton = findViewById(R.id.testLogger);
        testLoggerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoggerActivity.class);
                startActivity(intent);
            }
        });

        // end
    }
}

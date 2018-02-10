package com.github.hualuomoli.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.github.hualuomoli.sample.logger.LoggerActivity;
import com.github.hualuomoli.sample.security.SecurityActivity;


public class MainActivity extends AppCompatActivity {

    private Button testLoggerButton;
    private Button testSecurityButton;

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

        testSecurityButton = findViewById(R.id.testSecurity);
        testSecurityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecurityActivity.class);
                startActivity(intent);
            }
        });

        // end
    }
}

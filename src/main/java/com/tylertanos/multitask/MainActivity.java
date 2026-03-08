package com.Tylertanos.MultiTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Simple layout for main configuration
        setContentView(R.layout.activity_main);

        // Check overlay permission
        if (!Settings.canDrawOverlays(this)) {
            Toast.makeText(this, "Please allow overlay permission!", Toast.LENGTH_LONG).show();
            startActivity(new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION));
        }

        // Start Mini-Assist bubble service
        startService(new Intent(this, OverlayService.class));

        // Example: button to open configuration
        Button openConfigBtn = findViewById(R.id.openConfigBtn);
        openConfigBtn.setOnClickListener(v -> {
            Toast.makeText(this, "You can configure the panel here!", Toast.LENGTH_SHORT).show();
            // TODO: open configuration UI
        });
    }
}

package com.example.splashscreen;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Splash extends AppCompatActivity {
    private static final int SPLASH_DISPLAY_LENGTH = 5000; // Durée du splash screen (3 secondes)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // Démarrage de l'activité principale après un délai
        new Handler().postDelayed(() -> {
            Intent mainIntent = new Intent(Splash.this, MainActivity.class);
            startActivity(mainIntent);
            finish(); // Fermer l'activité Splash pour ne pas revenir en arrière
        }, SPLASH_DISPLAY_LENGTH);
    }
}
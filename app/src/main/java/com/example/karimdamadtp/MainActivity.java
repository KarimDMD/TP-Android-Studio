package com.example.karimdamadtp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // LOGO TOAST MESSAGE
        ImageView logoGoogle = findViewById(R.id.logoGoogle);
        ImageView logoFacebook = findViewById(R.id.logoFacebook);
        ImageView logoApple = findViewById(R.id.logoApple);

        logoGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Connected with Google id");
            }
        });

        logoFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Connected with Facebook id");
            }
        });

        logoApple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Connected with Apple id");
            }
        });

        // LOGIN CHANGE ACTIVITY
        MaterialButton loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startCharacterActivity();
            }
        });
    }
    private void showToast(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    private void startCharacterActivity() {
        Intent intent = new Intent(MainActivity.this, CharacterActivity.class);
        startActivity(intent);
    }
}
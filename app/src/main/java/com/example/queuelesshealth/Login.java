package com.example.queuelesshealth;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    EditText etEmail, etPassword;
    Button btnLogin;
    TextView tvForgotPassword, tvRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // 1. INITIALIZATION
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvForgotPassword = findViewById(R.id.tvForgotPassword);
        tvRegister = findViewById(R.id.tvRegister);

        // Pre-fill email if passed from Register
        String registeredEmail = getIntent().getStringExtra("REGISTERED_EMAIL");
        if (registeredEmail != null && !registeredEmail.isEmpty()) {
            etEmail.setText(registeredEmail);
        }

        // 2. EVENT LISTENER: LOGIN BUTTON & DATA CAPTURE
        btnLogin.setOnClickListener(v -> {
            String email = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString();

            // 3. BASIC VALIDATION & DATA CAPTURE
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter email and password!", Toast.LENGTH_SHORT).show();
            } else {
                // Save session in SharedPreferences so MainActivity recognizes the logged-in user
                getSharedPreferences("qlh_session", MODE_PRIVATE)
                        .edit()
                        .putString("user_name", email)
                        .apply();

                Toast.makeText(this, "Welcome, " + email + "!", Toast.LENGTH_SHORT).show();
                
                // 4. INTENT NAVIGATION TO MAIN ACTIVITY
                Intent intent = new Intent(Login.this, MainMenu.class);
                intent.putExtra("USER_EMAIL", email);
                startActivity(intent);
                finish();
            }
        });

        // 5. EVENT LISTENER: FORGOT PASSWORD
        tvForgotPassword.setOnClickListener(v -> {
            Toast.makeText(this, "Redirecting to password recovery...", Toast.LENGTH_SHORT).show();
        });

        // 6. EVENT LISTENER: REGISTER LINK
        tvRegister.setOnClickListener(v -> {
            Intent intent = new Intent(Login.this, Register.class);
            startActivity(intent);
        });
    }
}

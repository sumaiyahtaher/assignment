package com.example.assignment3;

import static java.util.EnumSet.of;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etRegisterName, etRegisterEmail,etRegisterPassword,etConfirmPassword,etRegisterPhone;
    private Button btnSignupLogin,btnSignupRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etRegisterName = findViewById(R.id.et_register_name);
        etRegisterEmail = findViewById(R.id.et_register_email);
        etRegisterPassword = findViewById(R.id.et_register_password);
        etConfirmPassword = findViewById(R.id.et_confirm_password);
        etRegisterPhone = findViewById(R.id.et_register_phone);

        btnSignupLogin = findViewById(R.id.btn_sign_up_login);
        btnSignupRegister = findViewById(R.id.btn_sign_up_register);

        btnSignupRegister.setOnClickListener(v -> {
            if (validateInputs()) {

                Toast.makeText(MainActivity.this, "Registration Succesful!", Toast.LENGTH_SHORT).show();
            }
        });

        btnSignupLogin.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Redirecting to login", Toast.LENGTH_SHORT).show();
        });

    }

    private boolean validateInputs() {
        String name = etRegisterName.getText().toString();
        String email = etRegisterEmail.getText().toString();
        String password = etRegisterPassword.getText().toString();
        String confirmPassword = etConfirmPassword.getText().toString();
        String phone = etRegisterPhone.getText().toString();

        if (TextUtils.isEmpty(name) || !isValidName(name)) {
            etRegisterName.setError("Invalid Name");
            return false;
        }

        if (TextUtils.isEmpty(email) || !isValidEmail(email)) {
            etRegisterEmail.setError("Invalid Email");
            return false;
        }

        if (TextUtils.isEmpty(password) || !isValidPassword(password)) {
            etRegisterPassword.setError("Invalid Password");
            return false;
        }

        if (!password.equals(confirmPassword)) {
            etConfirmPassword.setError("Passwords do not match");
            return false;
        }

        if (TextUtils.isEmpty(phone) || !isValidPhone(phone)) {
            etRegisterPhone.setError("Invalid Phone Number");
            return false;
        }

        return true;

    }

    private boolean isValidName(String name) {
        return name.matches("^([A-Z][a-z]+)(\\s[A-Z][a-z]+)*$");
    }

    private boolean isValidEmail(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean isValidPassword(String password) {
        return password.matches("^(?=.[A-Z])(?=.[a-z])(?=.\\d)(?=.[\\W_]).{6,}$");
    }

    //^(?=.[a-z])(?=.[A-Z])(?=.\d)(?=.[@$!%?&])[A-Za-z\d@$!%?&]{6,}$
    //^(?=.[A-Z])(?=.[a-z])(?=./d)(?=.[\W_]).{6,}$

    private boolean isValidPhone(String phone) {
        return phone.matches("^(\\+8801[3-9]|01[3-9])[\\d]{8}$");
    }
}
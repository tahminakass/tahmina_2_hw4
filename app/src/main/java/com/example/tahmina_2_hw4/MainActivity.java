package com.example.tahmina_2_hw4;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText etEmail;
    private EditText etPassword;
    private TextView welcome;
    private Button btn_orange;
    private View layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btn_orange = findViewById(R.id.btn_get_in);
        button = findViewById(R.id.btn_get_in_gray);
        etEmail = findViewById(R.id.et_mail);
        etPassword = findViewById(R.id.et_password);
        welcome = findViewById(R.id.tv_welcome2);
        layout = findViewById(R.id.constraint);


        button.setOnClickListener(view -> {
            String email = etEmail.getText().toString();
            String password = etPassword.getText().toString();

            if (email.equals("admin") || password.equals("admin")) {
                btn_orange.setVisibility(View.VISIBLE);
            } else if (email.isEmpty() && password.isEmpty()) {
                button.setVisibility(View.VISIBLE);
            } else {
                Toast.makeText(this, "Неправильный логин или пароль", Toast.LENGTH_SHORT).show();
            }
        });

        btn_orange.setOnClickListener(view -> {
            Toast.makeText(this, "Вы успешно зарегистрировались", Toast.LENGTH_SHORT).show();
            layout.setVisibility(View.GONE);
            welcome.setVisibility(View.VISIBLE);
        });

    }
}
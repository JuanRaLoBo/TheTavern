package com.blackmensa.ddtool.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.blackmensa.ddtool.Core.DataBaseManager;
import com.blackmensa.ddtool.Core.Session;
import com.blackmensa.ddtool.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final DataBaseManager conexionBD = new DataBaseManager(this);
        SQLiteDatabase BD = conexionBD.getReadableDatabase();

        final Session session = new Session(this);

        binding.loginButton.setOnClickListener(view -> {
            String logEmail = binding.editTextEmailAddress.getText().toString();
            String logPass = binding.editTextPassword.getText().toString();

            //if (conexionBD.getUser(logEmail, logPass)) {
                session.setLoggedState(true);
            //    session.setCurrentUser(logEmail);

                startActivity(new Intent(this, MainMenuActivity.class));
            //}
        });

        binding.exitButton.setOnClickListener(view -> {
            finish();
        });
    }
}
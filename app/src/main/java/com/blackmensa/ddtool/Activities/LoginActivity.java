package com.blackmensa.ddtool.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.blackmensa.ddtool.core.Session;
import com.blackmensa.ddtool.data.local.database.AppDatabase;
import com.blackmensa.ddtool.data.repository.UserRepository;
import com.blackmensa.ddtool.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Configurar el binding de la actividad
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        // Establecer la vista de la actividad
        setContentView(binding.getRoot());

        // Inicializar la base de datos
        AppDatabase database =
                AppDatabase.Companion.getDatabase(this);

        // Inicializar el repositorio de usuarios
        UserRepository userRepository =
                new UserRepository(
                        database.userDao()
                );

        // Agregar un usuario de prueba
        userRepository.addUser("test@test.com", "Test", "1234");

        final Session session = new Session(this);

        // Configurar el botón de inicio de sesión
        binding.loginButton.setOnClickListener(view -> {
            String logEmail = binding.editTextEmailAddress.getText().toString();
            String logPass = binding.editTextPassword.getText().toString();

//            if (userRepository.login(
//                        logEmail,
//                        logPass
//            )){
//                session.setLoggedState(true);
//                session.setCurrentUser(logEmail);

                startActivity(new Intent(this, MainMenuActivity.class));
//            }
        });

        //
        binding.exitButton.setOnClickListener(view -> {
            finish();
        });
    }
}
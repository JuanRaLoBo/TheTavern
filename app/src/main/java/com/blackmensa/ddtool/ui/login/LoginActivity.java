package com.blackmensa.ddtool.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import com.blackmensa.ddtool.Activities.MainMenuActivity;
import com.blackmensa.ddtool.core.Session;
import com.blackmensa.ddtool.data.local.database.AppDatabase;
import com.blackmensa.ddtool.data.repository.UserRepository;
import com.blackmensa.ddtool.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private LoginViewModel viewModel;
    private ActivityLoginBinding binding;
    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Configurar el binding de la actividad
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        // Establecer la vista de la actividad
        setContentView(binding.getRoot());

        session = new Session(this);

        // Inicializar la base de datos
        AppDatabase database = AppDatabase.Companion.getDatabase(this);

        // Inicializar el repositorio de usuarios
        UserRepository userRepository = new UserRepository(database.userDao());

        // Inicializar el ViewModel con la fábrica correspondiente
        LoginViewModelFactory factory = new LoginViewModelFactory(userRepository);

        viewModel = new ViewModelProvider(this, factory).get(LoginViewModel.class);

        viewModel.createTestUser();

        // Agregar un usuario de prueba
        userRepository.addUser("test@test.com", "Test", "1234");


        // Configurar el botón de inicio de sesión
        binding.loginButton.setOnClickListener(view -> {
            String logEmail = binding.editTextEmailAddress.getText().toString();
            String logPass = binding.editTextPassword.getText().toString();

//            if (viewModel.login(logEmail, logPass)){
//                session.setLoggedState(true);
//                session.setCurrentUser(logEmail);
                startActivity(new Intent(this, MainMenuActivity.class));
//            }else {
//            Toast.makeText(this, "Email o contraseña incorrectos", Toast.LENGTH_SHORT).show();
//        }
        });

        //
        binding.exitButton.setOnClickListener(view -> {
            finish();
        });
    }
}
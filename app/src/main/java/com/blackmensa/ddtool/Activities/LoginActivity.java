package com.blackmensa.ddtool.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.blackmensa.ddtool.Core.DataBaseManager;
import com.blackmensa.ddtool.Core.Session;
import com.blackmensa.ddtool.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final DataBaseManager conexionBD = new DataBaseManager(this);
        SQLiteDatabase BD = conexionBD.getReadableDatabase();
        final Session session = new Session(this);

        final TextView textEmail = (TextView) this.findViewById(R.id.textViewEmail);
        final TextView textPass = (TextView) this.findViewById(R.id.textViewPassword);
        final EditText email = (EditText) this.findViewById(R.id.editTextTextEmailAddress);
        final EditText password = (EditText) this.findViewById(R.id.editTextTextPassword);

        final Button loginButton = (Button) this.findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String logEmail = email.getText().toString();
                String logPass = password.getText().toString();
                if (conexionBD.getUser(logEmail, logPass)){
                    session.SetLoggedState(true);
                    session.setCurrentUser(logEmail);
                    view.getContext().startActivity(new Intent(view.getContext(), MainMenuActivity.class));
                }
            }
        });
        final Button exitButton = (Button) this.findViewById(R.id.exitButton);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });
    }
}
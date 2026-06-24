package com.blackmensa.ddtool.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.blackmensa.ddtool.databinding.MenuMainBinding;

public class MainMenuActivity extends Activity {

    private MenuMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = MenuMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //final DataBaseManager dataBase = new DataBaseManager(this);

        binding.playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.getContext().startActivity(new Intent(view.getContext(), DiceActivity.class));
            }
        });

        //TODO: Faltan opciones intermedias del menú

        binding.selectCharacter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.getContext().startActivity(new Intent(view.getContext(), ProfileListActivity.class));
            }
        });

        binding.exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}

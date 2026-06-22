package com.blackmensa.ddtool.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.blackmensa.ddtool.R;
import com.blackmensa.ddtool.databinding.TirarDadosBinding;

public class TirarDadosActivity extends AppCompatActivity {

    private TirarDadosBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tirar_dados);

        binding = TirarDadosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.result4.setText("El resultado es " + generateRandom(4));
            }
        });

        binding.button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.result6.setText("El resultado es " + generateRandom(6));
            }
        });

        binding.button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.result8.setText("El resultado es " + generateRandom(8));
            }
        });

        binding.button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.result10.setText("El resultado es " + generateRandom(10));
            }
        });

        binding.button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.result12.setText("El resultado es " + generateRandom(12));
            }
        });

        binding.button20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.result20.setText("El resultado es " + generateRandom(20));
            }
        });
    }

    protected String generateRandom(int dado){
        int resultado = 0;
        do{
            resultado = (int) Math.floor(Math.random()*(dado+1));
        }while (resultado == 0);
        return String.valueOf(resultado);
    }

    protected int modifier(int stat){
        switch(stat) {
            case 1:
                return -5;
            case 2:
            case 3:
                return -4;
            case 4:
            case 5:
                return -3;
            case 6:
            case 7:
                return -2;
            case 8:
            case 9:
                return -1;
            case 10:
            case 11:
                return 0;
            case 12:
            case 13:
                return 1;
            case 14:
            case 15:
                return 2;
            case 16:
            case 17:
               return 3;
            case 18:
            case 19:
                return 4;
            case 20:
                return 5;
        }
        return 0;
    }
}
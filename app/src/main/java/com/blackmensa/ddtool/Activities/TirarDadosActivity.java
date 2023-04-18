package com.blackmensa.ddtool.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.blackmensa.ddtool.R;

public class TirarDadosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tirar_dados);

        final TextView resultado4 = (TextView) this.findViewById(R.id.result4);
        final TextView resultado6 = (TextView) this.findViewById(R.id.result6);
        final TextView resultado8 = (TextView) this.findViewById(R.id.result8);
        final TextView resultado10 = (TextView) this.findViewById(R.id.result10);
        final TextView resultado12 = (TextView) this.findViewById(R.id.result12);
        final TextView resultado20 = (TextView) this.findViewById(R.id.result20);

        final Button dado4 = (Button) this.findViewById(R.id.button4);
        dado4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultado4.setText("El resultado es " + generateRandom(4));
            }
        });

        final Button dado6 = (Button) this.findViewById(R.id.button6);
        dado6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultado6.setText("El resultado es " + generateRandom(6));
            }
        });

        final Button dado8 = (Button) this.findViewById(R.id.button8);
        dado8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultado8.setText("El resultado es " + generateRandom(8));
            }
        });

        final Button dado10 = (Button) this.findViewById(R.id.button10);
        dado10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultado10.setText("El resultado es " + generateRandom(10));
            }
        });

        final Button dado12 = (Button) this.findViewById(R.id.button12);
        dado12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultado12.setText("El resultado es " + generateRandom(12));
            }
        });

        final Button dado20 = (Button) this.findViewById(R.id.button20);
        dado20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultado20.setText("El resultado es " + generateRandom(20));
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
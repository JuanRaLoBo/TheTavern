package com.blackmensa.ddtool.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.blackmensa.ddtool.Core.DataBaseManager;
import com.blackmensa.ddtool.R;

public class MainMenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_main);

        //final DataBaseManager dataBase = new DataBaseManager(this);

        final Button playButton = (Button) this.findViewById(R.id.playButton);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.getContext().startActivity(new Intent(view.getContext(), TirarDadosActivity.class));
            }
        });

        final Button selectCharacter = (Button) this.findViewById(R.id.selectCharacter);
        selectCharacter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.getContext().startActivity(new Intent(view.getContext(), ProfileListActivity.class));
            }
        });

        final Button exitButton = (Button) this.findViewById(R.id.exit);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });
    }
}

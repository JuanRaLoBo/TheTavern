package com.blackmensa.ddtool.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.blackmensa.ddtool.Core.CharacterProfile;
import com.blackmensa.ddtool.Core.DataBaseManager;
import com.blackmensa.ddtool.R;

import java.util.ArrayList;

public class ProfileListActivity extends AppCompatActivity {
    private ArrayList<CharacterProfile> items;
    private ArrayAdapter<CharacterProfile> itemsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_list);

        final DataBaseManager dataBase = new DataBaseManager(this);

        final TextView textList = (TextView) this.findViewById(R.id.currentCharacter);
        ListView Character_list = (ListView) this.findViewById(R.id.character_list);
        this.items = new ArrayList<CharacterProfile>();
        this.itemsAdapter = new ArrayAdapter<CharacterProfile>(this, android.R.layout.simple_selectable_list_item, this.items);
        Character_list.setAdapter(this.itemsAdapter);
        //HACER CONSULTA A LA BASE DE DATOS, SACAR LOS PERFILES Y AÑADIRLOS A LA LISTA CON ADD()

        final Button addCharButton = (Button) this.findViewById(R.id.add_character);
        addCharButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.getContext().startActivity(new Intent(view.getContext(), CreateProfileActivity.class));
            }
        });
    }
}
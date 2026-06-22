package com.blackmensa.ddtool.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.blackmensa.ddtool.Core.CharacterProfile;
import com.blackmensa.ddtool.Core.DataBaseManager;
import com.blackmensa.ddtool.R;
import com.blackmensa.ddtool.databinding.ProfileListBinding;

import java.util.ArrayList;

public class ProfileListActivity extends AppCompatActivity {
    private ProfileListBinding binding;
    private ArrayList<CharacterProfile> items;
    private ArrayAdapter<CharacterProfile> itemsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_list);

        binding = ProfileListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final DataBaseManager dataBase = new DataBaseManager(this);

        this.items = new ArrayList();
        this.itemsAdapter = new ArrayAdapter(
                this,
                android.R.layout.simple_selectable_list_item,
                this.items
        );

        binding.characterList.setAdapter(this.itemsAdapter);

        binding.addCharacter.setOnClickListener(view -> {
            startActivity(new Intent(this, CreateProfileActivity.class));
        });
    }
}
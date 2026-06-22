package com.blackmensa.ddtool.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.blackmensa.ddtool.data.repository.CharacterRepository;
import com.blackmensa.ddtool.domain.model.CharacterProfile;
import com.blackmensa.ddtool.core.DataBaseManager;
import com.blackmensa.ddtool.R;
import com.blackmensa.ddtool.databinding.ProfileListBinding;
import com.blackmensa.ddtool.ui.profilelist.ProfileListViewModel;
import com.blackmensa.ddtool.ui.profilelist.ProfileListViewModelFactory;

import java.util.ArrayList;

public class ProfileListActivity extends AppCompatActivity {
    private ProfileListBinding binding;
    private ArrayList<CharacterProfile> items;
    private ArrayAdapter<CharacterProfile> itemsAdapter;
    private ProfileListViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_list);

        binding = ProfileListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final DataBaseManager dataBase = new DataBaseManager(this);

        CharacterRepository repository = new CharacterRepository(dataBase);
        ProfileListViewModelFactory factory = new ProfileListViewModelFactory(repository);

        viewModel = new ViewModelProvider(this, factory).get(ProfileListViewModel.class);
        viewModel.loadProfiles(null);

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
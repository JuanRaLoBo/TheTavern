package com.blackmensa.ddtool.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.blackmensa.ddtool.core.Session;
import com.blackmensa.ddtool.data.local.database.AppDatabase;
import com.blackmensa.ddtool.data.repository.CharacterRepository;
import com.blackmensa.ddtool.domain.model.CharacterProfile;
import com.blackmensa.ddtool.databinding.ProfileListBinding;
import com.blackmensa.ddtool.ui.profilelist.ProfileListViewModel;
import com.blackmensa.ddtool.ui.profilelist.ProfileListViewModelFactory;

import java.util.ArrayList;
import java.util.List;

public class ProfileListActivity extends AppCompatActivity {
    private ProfileListBinding binding;
    private ArrayAdapter<String> itemsAdapter;
    private ProfileListViewModel viewModel;
    private List<CharacterProfile> profiles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ProfileListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Session session = new Session(this);

        // Inicializar la base de datos
        AppDatabase database =
                AppDatabase.Companion.getDatabase(this);

        // Inicializar el repositorio de personajes
        CharacterRepository repository =
                new CharacterRepository(database.characterDao());

        // Inicializar el adaptador de la lista de personajes
        this.itemsAdapter = new ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                new ArrayList<>()
        );

        binding.characterList.setAdapter(itemsAdapter);
        ProfileListViewModelFactory factory = new ProfileListViewModelFactory(repository);

        viewModel = new ViewModelProvider(this, factory).get(ProfileListViewModel.class);
        this.loadProfiles();

        binding.characterList.setOnItemClickListener(
                (parent, view, position, id) -> {

                    CharacterProfile selected =
                            profiles.get(position);

                    session.setCurrentCharacter(selected);

                    startActivity(
                            new Intent(
                                    ProfileListActivity.this,
                                    DiceActivity.class
                            )
                    );
                }
        );

        binding.addCharacter.setOnClickListener(view -> {
            startActivity(new Intent(this, CreateProfileActivity.class));
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (viewModel != null && itemsAdapter != null) {
            loadProfiles();
        }
    }

    private void loadProfiles() {
        Session session = new Session(this);
        profiles = viewModel.loadProfiles(session.getCurrentUser());

        /*
        Primer personaje de prueba para la base de datos, se puede eliminar si se desea

        boolean[] saves = new boolean[]{true, false, false, false, false, true};
        boolean[] skills = new boolean[18];
        CharacterProfile testCharacter = new CharacterProfile(
                "Grom",
                "Barbarian",
                18,
                12,
                16,
                8,
                10,
                14,
                3,
                saves,
                skills,
                25,
                32
        );
        dataBase.addCharacterProfile(
                testCharacter,
                session.getCurrentUser()
        );
        */

        ArrayList<String> characterNames = new ArrayList<>();

        for (CharacterProfile profile : profiles) {
            characterNames.add(profile.getName());
        }

        itemsAdapter.clear();
        itemsAdapter.addAll(characterNames);
        itemsAdapter.notifyDataSetChanged();
    }
}
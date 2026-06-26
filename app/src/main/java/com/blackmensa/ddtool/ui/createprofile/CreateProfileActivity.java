package com.blackmensa.ddtool.ui.createprofile;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProvider;

import com.blackmensa.ddtool.core.ServiceLocator;
import com.blackmensa.ddtool.core.Session;
import com.blackmensa.ddtool.data.local.database.AppDatabase;
import com.blackmensa.ddtool.data.repository.CharacterRepository;
import com.blackmensa.ddtool.domain.model.CharacterProfile;
import com.blackmensa.ddtool.databinding.NewProfileBinding;

public class CreateProfileActivity extends AppCompatActivity {

    private CreateProfileViewModel viewModel;
    private NewProfileBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = NewProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        AppDatabase database =
                AppDatabase.Companion.getDatabase(this);

        CharacterRepository repository =
                ServiceLocator.INSTANCE.provideCharacterRepository(this);

        Session session = new Session(this);

        CreateProfileViewModelFactory factory =
                new CreateProfileViewModelFactory(repository);

        viewModel = new ViewModelProvider(
                this,
                factory
        ).get(CreateProfileViewModel.class);

        binding.stats.setVisibility(ConstraintLayout.VISIBLE);
        binding.skills.setVisibility(ConstraintLayout.GONE);

        binding.nextSkills.setOnClickListener(view -> {
            binding.stats.setVisibility(ConstraintLayout.GONE);
            binding.skills.setVisibility(ConstraintLayout.VISIBLE);
        });

        binding.finishProfileCreation.setOnClickListener(view -> {
            if (hasEmptyRequiredFields()) {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show();
                return;
            }
            CharacterProfile character = buildCharacterFromForm();

            boolean saved;
            if (!viewModel.canSave(character, session.getCurrentUser())) {
                Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_SHORT).show();
                return;
            }else{
                viewModel.saveCharacter(character, session.getCurrentUser());
                saved = true;
            }

            if (saved) {
                Toast.makeText(this, "Personaje guardado", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "No se pudo guardar el personaje", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private CharacterProfile buildCharacterFromForm() {
        boolean[] saves = new boolean[]{
                binding.checkBoxStr.isChecked(),
                binding.checkBoxDex.isChecked(),
                binding.checkBoxCon.isChecked(),
                binding.checkBoxInt.isChecked(),
                binding.checkBoxWis.isChecked(),
                binding.checkBoxChar.isChecked()
        };

        boolean[] skills = new boolean[]{
                binding.checkBox1.isChecked(),
                binding.checkBox2.isChecked(),
                binding.checkBox3.isChecked(),
                binding.checkBox4.isChecked(),
                binding.checkBox5.isChecked(),
                binding.checkBox6.isChecked(),
                binding.checkBox7.isChecked(),
                binding.checkBox8.isChecked(),
                binding.checkBox9.isChecked(),
                binding.checkBox10.isChecked(),
                binding.checkBox11.isChecked(),
                binding.checkBox12.isChecked(),
                binding.checkBox13.isChecked(),
                binding.checkBox14.isChecked(),
                binding.checkBox15.isChecked(),
                binding.checkBox16.isChecked(),
                binding.checkBox17.isChecked(),
                binding.checkBox18.isChecked()
        };

        return new CharacterProfile(
                0,
                binding.charName.getText().toString(),
                binding.charClass.getText().toString(),
                Integer.parseInt(binding.setStr.getText().toString()),
                Integer.parseInt(binding.setDex.getText().toString()),
                Integer.parseInt(binding.setCon.getText().toString()),
                Integer.parseInt(binding.setInt.getText().toString()),
                Integer.parseInt(binding.setWis.getText().toString()),
                Integer.parseInt(binding.setChar.getText().toString()),
                Integer.parseInt(binding.charLevel.getText().toString()),
                saves,
                skills,
                Integer.parseInt(binding.gold.getText().toString()),
                Integer.parseInt(binding.hp.getText().toString())
        );
    }

    private boolean hasEmptyRequiredFields() {
        return binding.charName.getText().toString().trim().isEmpty()
                || binding.charClass.getText().toString().trim().isEmpty()
                || binding.charLevel.getText().toString().trim().isEmpty()
                || binding.setStr.getText().toString().trim().isEmpty()
                || binding.setDex.getText().toString().trim().isEmpty()
                || binding.setCon.getText().toString().trim().isEmpty()
                || binding.setInt.getText().toString().trim().isEmpty()
                || binding.setWis.getText().toString().trim().isEmpty()
                || binding.setChar.getText().toString().trim().isEmpty()
                || binding.gold.getText().toString().trim().isEmpty()
                || binding.hp.getText().toString().trim().isEmpty();
    }
}
package com.blackmensa.ddtool.ui.dice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.blackmensa.ddtool.core.ServiceLocator;
import com.blackmensa.ddtool.core.Session;
import com.blackmensa.ddtool.data.repository.CharacterRepository;
import com.blackmensa.ddtool.databinding.TirarDadosBinding;
import com.blackmensa.ddtool.domain.model.CharacterProfile;
import com.blackmensa.ddtool.domain.service.CharacterService;

public class DiceActivity extends AppCompatActivity {

    private TirarDadosBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = TirarDadosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Session session = ServiceLocator.INSTANCE.provideSession(this);
        CharacterRepository repository = ServiceLocator.INSTANCE.provideCharacterRepository(this);

        int characterID = session.getSelectedCharacterId();
        CharacterProfile character = repository.getCharacterById(characterID);
        CharacterService characterService = new CharacterService();

        if (character != null) {
            binding.characterName.setText("Personaje actual: " + character.getName());
            binding.charlvl.setText("Nivel: " + character.getLevel());

            binding.strMod.setText("STR: " +
                    characterService.formatModifier(character.getStrength())
            );
            binding.dexMod.setText("DEX: " +
                    characterService.formatModifier(character.getDexterity())
            );
            binding.conMod.setText("CON: " +
                    characterService.formatModifier(character.getConst())
            );
            binding.intMod.setText("INT: " +
                    characterService.formatModifier(character.getIntelligence())
            );
            binding.wisMod.setText("WIS: " +
                    characterService.formatModifier(character.getWisdom())
            );
            binding.charMod.setText("CHA: " +
                    characterService.formatModifier(character.getCharisma())
            );
        }

        setupDiceButtons();
    }

    private void setupDiceButtons() {
        binding.button4.setOnClickListener(view -> rollDice(4, binding.result4));
        binding.button6.setOnClickListener(view -> rollDice(6, binding.result6));
        binding.button8.setOnClickListener(view -> rollDice(8, binding.result8));
        binding.button10.setOnClickListener(view -> rollDice(10, binding.result10));
        binding.button12.setOnClickListener(view -> rollDice(12, binding.result12));
        binding.button20.setOnClickListener(view -> rollDice(20, binding.result20));
    }

    private void rollDice(int sides, TextView resultView) {
        resultView.setText("El resultado es " + generateRandom(sides));
    }

    protected String generateRandom(int dado){
        int resultado = 0;
        do{
            resultado = (int) Math.floor(Math.random()*(dado+1));
        }while (resultado == 0);
        return String.valueOf(resultado);
    }
}
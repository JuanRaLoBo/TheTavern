package com.blackmensa.ddtool.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.blackmensa.ddtool.Core.CharacterProfile;
import com.blackmensa.ddtool.Core.DataBaseManager;
import com.blackmensa.ddtool.Core.Session;
import com.blackmensa.ddtool.R;

public class CreateProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_profile);

        final ConstraintLayout layout1, layout2;
        layout1 = (ConstraintLayout) findViewById(R.id.stats);
        layout2 = (ConstraintLayout) findViewById(R.id.skills);

        layout1.setVisibility(ConstraintLayout.VISIBLE);
        layout2.setVisibility(ConstraintLayout.GONE);
        final DataBaseManager dataBase = new DataBaseManager(this);
        //final Session ses = new Session(this);

        final TextView setName = (TextView) this.findViewById(R.id.set_char_name);
        final TextView setLevel = (TextView) this.findViewById(R.id.set_char_level);
        final TextView setClass = (TextView) this.findViewById(R.id.set_char_class);
        final TextView setStats = (TextView) this.findViewById(R.id.enter_stats);
        final TextView setSavings = (TextView) this.findViewById(R.id.enter_savings);
        final TextView setStatStr = (TextView) this.findViewById(R.id.set_stat_str);
        final TextView setStatDex = (TextView) this.findViewById(R.id.set_stat_dex);
        final TextView setStatCon = (TextView) this.findViewById(R.id.set_stat_con);
        final TextView setStatInt = (TextView) this.findViewById(R.id.set_stat_int);
        final TextView setStatWis = (TextView) this.findViewById(R.id.set_stat_wis);
        final TextView setStatChar = (TextView) this.findViewById(R.id.set_stat_char);
        final TextView selectSkills = (TextView) this.findViewById(R.id.selectSkills);
        final TextView setGold = (TextView) this.findViewById(R.id.setGold);
        final TextView setHP = (TextView) this.findViewById(R.id.setHP);
        final TextView skill1 = (TextView) this.findViewById(R.id.textView1);
        final TextView skill2 = (TextView) this.findViewById(R.id.textView2);
        final TextView skill3 = (TextView) this.findViewById(R.id.textView3);
        final TextView skill4 = (TextView) this.findViewById(R.id.textView4);
        final TextView skill5 = (TextView) this.findViewById(R.id.textView5);
        final TextView skill6 = (TextView) this.findViewById(R.id.textView6);
        final TextView skill7 = (TextView) this.findViewById(R.id.textView7);
        final TextView skill8 = (TextView) this.findViewById(R.id.textView8);
        final TextView skill9 = (TextView) this.findViewById(R.id.textView9);
        final TextView skill10 = (TextView) this.findViewById(R.id.textView10);
        final TextView skill11 = (TextView) this.findViewById(R.id.textView11);
        final TextView skill12 = (TextView) this.findViewById(R.id.textView12);
        final TextView skill13 = (TextView) this.findViewById(R.id.textView13);
        final TextView skill14 = (TextView) this.findViewById(R.id.textView14);
        final TextView skill15 = (TextView) this.findViewById(R.id.textView15);
        final TextView skill16 = (TextView) this.findViewById(R.id.textView16);
        final TextView skill17 = (TextView) this.findViewById(R.id.textView17);
        final TextView skill18 = (TextView) this.findViewById(R.id.textView18);

        //HAY QUE CONTROLAR QUE SE INTRODUZCAN DATOS EN TODOS LOS CAMPOS
        final EditText name = (EditText) this.findViewById(R.id.char_name);
        final EditText level = (EditText) this.findViewById(R.id.char_level);
        final EditText char_class = (EditText) this.findViewById(R.id.char_class);
        final EditText str = (EditText) this.findViewById(R.id.setStr);
        final EditText dex = (EditText) this.findViewById(R.id.setDex);
        final EditText con = (EditText) this.findViewById(R.id.setCon);
        final EditText intel = (EditText) this.findViewById(R.id.setInt);
        final EditText wis = (EditText) this.findViewById(R.id.setWis);
        final EditText charisma = (EditText) this.findViewById(R.id.setChar);
        final EditText gold = (EditText) this.findViewById(R.id.gold);
        final EditText hp = (EditText) this.findViewById(R.id.hp);

        final CheckBox strSave = (CheckBox) this.findViewById(R.id.checkBoxStr);
        final CheckBox dexSave = (CheckBox) this.findViewById(R.id.checkBoxDex);
        final CheckBox conSave = (CheckBox) this.findViewById(R.id.checkBoxCon);
        final CheckBox intSave = (CheckBox) this.findViewById(R.id.checkBoxInt);
        final CheckBox wisSave = (CheckBox) this.findViewById(R.id.checkBoxWis);
        final CheckBox charSave = (CheckBox) this.findViewById(R.id.checkBoxChar);
        final CheckBox skillCheck1 = (CheckBox) this.findViewById(R.id.checkBox1);
        final CheckBox skillCheck2 = (CheckBox) this.findViewById(R.id.checkBox2);
        final CheckBox skillCheck3 = (CheckBox) this.findViewById(R.id.checkBox3);
        final CheckBox skillCheck4 = (CheckBox) this.findViewById(R.id.checkBox4);
        final CheckBox skillCheck5 = (CheckBox) this.findViewById(R.id.checkBox5);
        final CheckBox skillCheck6 = (CheckBox) this.findViewById(R.id.checkBox6);
        final CheckBox skillCheck7 = (CheckBox) this.findViewById(R.id.checkBox7);
        final CheckBox skillCheck8 = (CheckBox) this.findViewById(R.id.checkBox8);
        final CheckBox skillCheck9 = (CheckBox) this.findViewById(R.id.checkBox9);
        final CheckBox skillCheck10 = (CheckBox) this.findViewById(R.id.checkBox10);
        final CheckBox skillCheck11 = (CheckBox) this.findViewById(R.id.checkBox11);
        final CheckBox skillCheck12 = (CheckBox) this.findViewById(R.id.checkBox12);
        final CheckBox skillCheck13 = (CheckBox) this.findViewById(R.id.checkBox13);
        final CheckBox skillCheck14 = (CheckBox) this.findViewById(R.id.checkBox14);
        final CheckBox skillCheck15 = (CheckBox) this.findViewById(R.id.checkBox15);
        final CheckBox skillCheck16 = (CheckBox) this.findViewById(R.id.checkBox16);
        final CheckBox skillCheck17 = (CheckBox) this.findViewById(R.id.checkBox17);
        final CheckBox skillCheck18 = (CheckBox) this.findViewById(R.id.checkBox18);


        final Button next = (Button) this.findViewById(R.id.next_skills);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout1.setVisibility(ConstraintLayout.GONE);
                layout2.setVisibility(ConstraintLayout.VISIBLE);
            }
        });

        final Button finishProfile = (Button) this.findViewById(R.id.finishProfileCreation);
        finishProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean[] saves = new boolean[6];
                saves[0] = strSave.isChecked();
                saves[1] = dexSave.isChecked();
                saves[2] = conSave.isChecked();
                saves[3] = intSave.isChecked();
                saves[4] = wisSave.isChecked();
                saves[5] = charSave.isChecked();

                boolean[] skill = new boolean[18];
                skill[0] = skillCheck1.isChecked();
                skill[1] = skillCheck2.isChecked();
                skill[2] = skillCheck3.isChecked();
                skill[3] = skillCheck4.isChecked();
                skill[4] = skillCheck5.isChecked();
                skill[5] = skillCheck6.isChecked();
                skill[6] = skillCheck7.isChecked();
                skill[7] = skillCheck8.isChecked();
                skill[8] = skillCheck9.isChecked();
                skill[9] = skillCheck10.isChecked();
                skill[10] = skillCheck11.isChecked();
                skill[11] = skillCheck12.isChecked();
                skill[12] = skillCheck13.isChecked();
                skill[13] = skillCheck14.isChecked();
                skill[14] = skillCheck15.isChecked();
                skill[15] = skillCheck16.isChecked();
                skill[16] = skillCheck17.isChecked();
                skill[17] = skillCheck18.isChecked();

                for(int i = 0; i < 6; i++){
                    saves[i] = strSave.isChecked();
                }
                CharacterProfile character = new CharacterProfile(name.getText().toString(), char_class.getText().toString(),
                                                                    Integer.parseInt(str.getText().toString()), Integer.parseInt(dex.getText().toString()),
                                                                    Integer.parseInt(con.getText().toString()), Integer.parseInt(intel.getText().toString()),
                                                                    Integer.parseInt(wis.getText().toString()), Integer.parseInt(charisma.getText().toString()),
                                                                    Integer.parseInt(level.getText().toString()), saves, skill,
                                                                    Integer.parseInt(gold.getText().toString()), Integer.parseInt(hp.getText().toString()));
                //METER PERFIL EN LA BASE DE DATOS
                boolean funca = dataBase.addCharacterProfile(character, "RANDOM"/*ses.getCurrentUser()*/);

            }
        });
    }
}
package com.blackmensa.ddtool.Core;

import android.widget.Switch;

public class CharacterProfile {
    private String Name;
    private String Class;
    private int Strength;
    private int Dexterity;
    private int Const;
    private int Intelligence;
    private int Wisdom;
    private int Charisma;
    private int Level;
    private boolean[] SavingThrows;
    private boolean[] Skills;
    private int currentGold;
    private int hitPoints;

    public  CharacterProfile(String n, String c, int str, int dex, int con, int intel, int wis, int cha, int level, boolean[] saving, boolean[] sk, int gold, int hp){
        Name = n;
        Class = c;
        Strength = str;
        Dexterity = dex;
        Const = con;
        Intelligence = intel;
        Wisdom = wis;
        Charisma = cha;
        Level = level;
        SavingThrows = saving;
        Skills = sk;
        currentGold = gold;
        hitPoints = hp;
    }

    public String getName(){
        return Name;
    }

    public String getCharClass(){
        return Class;
    }

    public int getStrength() {
        return Strength;
    }

    public int getDexterity() {
        return Dexterity;
    }

    public int getConst() {
        return Const;
    }

    public int getIntelligence() {
        return Intelligence;
    }

    public int getWisdom() {
        return Wisdom;
    }

    public int getCharisma() {
        return Charisma;
    }

    public int getLevel() {
        return Level;
    }

    //ESTA FUNCION VA HABER QUE TOCARLA
    public String[] getSavingThrows() {
        String[] savings = new String[6];
        for (int x = 0; x < 6; x++) {
            boolean y = SavingThrows[x];
            if (y){
                savings[x] = "True";
            }else {
                savings[x] = "False";
            }
        }
        return savings;
    }

    public String[] getSkills() {
        String[] skills = new String[18];
        for (int x = 0; x < 18; x++){
            boolean y = Skills[x];
            if (y){
                skills[x] = "True";
            }else {
                skills[x] = "False";
            }
                /*switch (x){
                    case 0:
                        skills = skills + "Acrobatics";
                        break;
                    case 1:
                        skills = skills + "Animal Handling";
                        break;
                    case 2:
                        skills = skills + "Arcana";
                        break;
                    case 3:
                        skills = skills + "Athletics";
                        break;
                    case 4:
                        skills = skills + "Deception";
                        break;
                    case 5:
                        skills = skills + "History";
                        break;
                    case 6:
                        skills = skills + "Insight";
                        break;
                    case 7:
                        skills = skills + "Intimidation";
                        break;
                    case 8:
                        skills = skills + "Investigation";
                        break;
                    case 9:
                        skills = skills + "Medicine";
                        break;
                    case 10:
                        skills = skills + "Nature";
                        break;
                    case 11:
                        skills = skills + "Perception";
                        break;
                    case 12:
                        skills = skills + "Performance";
                        break;
                    case 13:
                        skills = skills + "Persuasion";
                        break;
                    case 14:
                        skills = skills + "Religion";
                        break;
                    case 15:
                        skills = skills + "Sleight of hand";
                        break;
                    case 16:
                        skills = skills + "Stealth";
                        break;
                    case 17:
                        skills = skills + "Survival";
                        break;
                }
            }*/
        }
        return skills;
    }

    public int getCurrentGold() {
        return currentGold;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setName(String newName){
        Name = newName;
    }

    public void setClass(String newClass){
        Class = newClass;
    }

    public void setStrength(int strength) {
        Strength = strength;
    }

    public void setDexterity(int dexterity) {
        Dexterity = dexterity;
    }

    public void setConst(int aConst) {
        Const = aConst;
    }

    public void setIntelligence(int intelligence) {
        Intelligence = intelligence;
    }

    public void setWisdom(int wisdom) {
        Wisdom = wisdom;
    }

    public void setCharisma(int charisma) {
        Charisma = charisma;
    }

    public void setLevel(int lvl) {
        Level = lvl;
    }

    public void setSavingThrows(boolean[] savingThrows) {
        SavingThrows = savingThrows;
    }

    public void setSkills(boolean[] skills) {
        Skills = skills;
    }

    public void setCurrentGold(int currentGold) {
        this.currentGold = currentGold;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    private int getProficiency(){
        switch (Level){
            case 1:
            case 2:
            case 3:
            case 4:
                return 2;
            case 5:
            case 6:
            case 7:
            case 8:
                return 3;
            case 9:
            case 10:
            case 11:
            case 12:
                return 4;
            case 13:
            case 14:
            case 15:
            case 16:
                return 5;
            case 17:
            case 18:
            case 19:
            case 20:
                return 6;
        }
        return 0;
    }
}

package com.blackmensa.ddtool.domain.model

class CharacterProfile(
    var name: String,
    var charClass: String,
    var strength: Int,
    var dexterity: Int,
    var const: Int,
    var intelligence: Int,
    var wisdom: Int,
    var charisma: Int,
    var level: Int,
    var savingThrows: BooleanArray,
    var skills: BooleanArray,
    var currentGold: Int,
    var hitPoints: Int
) {
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

    fun proficiency(): Int {
        return when (level) {
            in 1..4 ->  2
            in 5..8 ->  3
            in 9..12 ->  4
            in 13..16 ->  5
            in 17..20 ->  6
            else -> 0
        }
    }
}
package com.blackmensa.ddtool.core;

import static java.lang.Boolean.getBoolean;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.blackmensa.ddtool.domain.model.CharacterProfile;

import java.util.ArrayList;

public class DataBaseManager extends SQLiteOpenHelper {
    public static final String DB_Name = "The Tavern";
    public static final int DB_Version = 2;
    private static final String USERS_TABLE = "Users";
    private static final String PROFILE_TABLE = "Profiles";
    private static final String PROFILECHARACTER_TABLE = "ProfileCharacters";
    private static final String ROOMS_TABLE = "Rooms";
    private static final String ANNOUNCES_TABLE = "Announces";
    private static final String REQUEST_TABLE = "Requests";
    private static final String MEMBERS_TABLE = "Members";

    public static String USER_EMAIL = "Email";
    public static String USER_NAME = "Name";
    public static String USER_PASSWORD = "Password";

    public static String PROFILE_ID = "Profile_ID";
    public static String USER = "email";
    public static String CHARACTER_NAME = "Name";
    public static String CHARACTER_LEVEL = "Level";
    public static String HITPOINTS = "HP";
    public static String GOLD = "Gold";
    public static String STRENGTH = "Strength";
    public static String DEXTERITY = "Dexterity";
    public static String CONSTITUTION = "Constitution";
    public static String INTELLIGENCE = "Intelligence";
    public static String WISDOM = "Wisdom";
    public static String CHARISMA = "Charisma";
    public static String STRENGTH_SAVE = "Strength_Save";
    public static String DEXTERITY_SAVE = "Dexterity_Save";
    public static String CONSTITUTION_SAVE = "Constitution_Save";
    public static String INTELLIGENCE_SAVE = "Intelligence_Save";
    public static String WISDOM_SAVE = "Wisdom_Save";
    public static String CHARISMA_SAVE = "Charisma_Save";
    public static String ACROBATICS = "Acrobatics";
    public static String ANIMAL_HANDLING = "Animal_Handling";
    public static String ARCANA = "Arcana";
    public static String ATHLETICS = "Athletics";
    public static String DECEPTION = "Deception";
    public static String HISTORY = "History";
    public static String INSIGHT = "Insight";
    public static String INTIMIDATION = "Intimidation";
    public static String INVESTIGATION = "Investigation";
    public static String MEDICINE = "Medicine";
    public static String NATURE = "Nature";
    public static String PERCEPTION = "Perception";
    public static String PERFORMANCE = "Performance";
    public static String PERSUASION = "Persuasion";
    public static String RELIGION = "Religion";
    public static String SLEIGHT_OF_HAND = "Sleight_Of_Hand";
    public static String STEALTH = "Stealth";
    public static String SURVIVAL = "Survival";

    public static String CODE = "Room_Code";
    public static String ROOM_NAME = "Name";

    public static String MT_CODE = "MT_Code";
    public static String MEMBER_EMAIL = "Member";
    public static String ROOM_CODE = "Room_Code";

    public static String ANNOUNCE_CODE = "Announce_Code";
    public static String OWNER_EMAIL = "Email";
    public static String DESCRIPTION = "Description";
    public static String ANNOUNCE_ROOM = "Announce_Room";

    public static String REQUEST_CODE = "Request_Code";
    public static String USER_REQUEST = "User_Request";

    public DataBaseManager(Context context) {
        super( context, DB_Name, null, DB_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
            db.beginTransaction();
            db.execSQL("CREATE TABLE IF NOT EXISTS " + USERS_TABLE + "("
                    + USER_EMAIL + " string PRIMARY KEY,"
                    + USER_NAME + " string(255) NOT NULL,"
                    + USER_PASSWORD + " string(255) NOT NULL"
                    +")");
            db.execSQL("CREATE TABLE IF NOT EXISTS " + PROFILE_TABLE + "("
                    + PROFILE_ID + " int PRIMARY KEY,"
                    + USER + " string,"
                    + CHARACTER_NAME + " string(255),"
                    + CHARACTER_LEVEL + " int,"
                    + HITPOINTS + " int,"
                    + GOLD + " int,"
                    + STRENGTH + " int,"
                    + DEXTERITY + " int,"
                    + CONSTITUTION + " int,"
                    + INTELLIGENCE + " int,"
                    + WISDOM + " int,"
                    + CHARISMA + " int,"
                    + STRENGTH_SAVE + " boolean,"
                    + DEXTERITY_SAVE + " boolean,"
                    + CONSTITUTION_SAVE + " boolean,"
                    + INTELLIGENCE_SAVE + " boolean,"
                    + WISDOM_SAVE + " boolean,"
                    + CHARISMA_SAVE + " boolean,"
                    + ACROBATICS + " boolean,"
                    + ANIMAL_HANDLING + " boolean,"
                    + ARCANA + " boolean,"
                    + ATHLETICS + " boolean,"
                    + DECEPTION + " boolean,"
                    + HISTORY + " boolean,"
                    + INSIGHT + " boolean,"
                    + INTIMIDATION + " boolean,"
                    + INVESTIGATION + " boolean,"
                    + MEDICINE + " boolean,"
                    + NATURE + " boolean,"
                    + PERCEPTION + " boolean,"
                    + PERFORMANCE + " boolean,"
                    + PERSUASION + " boolean,"
                    + RELIGION + " boolean,"
                    + SLEIGHT_OF_HAND + " boolean,"
                    + STEALTH + " boolean,"
                    + SURVIVAL + " boolean"
                    +")");

            db.execSQL("CREATE TABLE IF NOT EXISTS " + ROOMS_TABLE + "("
                    + CODE + " int PRIMARY KEY,"
                    + ROOM_NAME + " string(255) NOT NULL"
                    +")");

            db.execSQL("CREATE TABLE IF NOT EXISTS " + ANNOUNCES_TABLE + "("
                    + ANNOUNCE_CODE + " int PRIMARY KEY,"
                    + OWNER_EMAIL + " string(255) NOT NULL,"
                    + DESCRIPTION + " string(255),"
                    + ANNOUNCE_ROOM + " int"
                    +")");

            db.execSQL("CREATE TABLE IF NOT EXISTS " + REQUEST_TABLE + "("
                    + REQUEST_CODE + " int PRIMARY KEY,"
                    + USER_REQUEST + " string(255)"
                    +")");

            db.execSQL("CREATE TABLE IF NOT EXISTS " + MEMBERS_TABLE + "("
                    + MT_CODE + " int PRIMARY KEY,"
                    + MEMBER_EMAIL + " string(255) NOT NULL,"
                    + ROOM_CODE + " int NOT NULL"
                    +")");

            db.setTransactionSuccessful();
        }catch (SQLException exc){
            Log.e("DataBase.onCreate", "Se encontró el siguiente error: " + exc.getMessage());
        }finally {
            db.endTransaction();
        }
    }

    //COMPLETAR
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + MEMBERS_TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + REQUEST_TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ANNOUNCES_TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ROOMS_TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + PROFILE_TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + USERS_TABLE);

        onCreate(sqLiteDatabase);
    }

    public boolean addUser(String email, String name, String password){
        SQLiteDatabase helper = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(USER_EMAIL, email);
        values.put(USER_NAME, name);
        values.put(USER_PASSWORD, password);

        try {
            helper.beginTransaction();
            long result = helper.insertWithOnConflict(
                    USERS_TABLE,
                    null,
                    values,
                    SQLiteDatabase.CONFLICT_IGNORE
            );            helper.setTransactionSuccessful();

            return result != -1;
        }catch (SQLException exc){
            Log.e("DataBase.addUser", "Error al añadir usuario: " + exc.getMessage());
            return false;
        }finally {
            helper.endTransaction();
            helper.close();
        }
    }

    public boolean getUser(String email, String password){
        SQLiteDatabase helper = getReadableDatabase();
        Cursor cursor = helper.query(
                USERS_TABLE,
                null,
                USER_EMAIL + " = ? and " + USER_PASSWORD + " = ?",
                new String[]{email, password},
                null,
                null,
                null);
        cursor.moveToFirst();
        if(cursor.getCount() > 0){
            cursor.close();
            helper.close();
            return true;
        }else{
            cursor.close();
            helper.close();
            return false;
        }
    }

    public boolean addCharacterProfile(CharacterProfile p, String u){
        SQLiteDatabase helper = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(USER, u);
        values.put(CHARACTER_NAME, p.getName());
        values.put(CHARACTER_LEVEL, p.getLevel());
        values.put(HITPOINTS, p.getHitPoints());
        values.put(GOLD, p.getCurrentGold());
        values.put(STRENGTH, p.getStrength());
        values.put(DEXTERITY, p.getDexterity());
        values.put(CONSTITUTION, p.getConst());
        values.put(INTELLIGENCE, p.getIntelligence());
        values.put(WISDOM, p.getWisdom());
        values.put(CHARISMA, p.getCharisma());
        values.put(STRENGTH_SAVE, p.getSavingThrows()[0]);
        values.put(DEXTERITY_SAVE, p.getSavingThrows()[1]);
        values.put(CONSTITUTION_SAVE, p.getSavingThrows()[2]);
        values.put(INTELLIGENCE_SAVE, p.getSavingThrows()[3]);
        values.put(WISDOM_SAVE, p.getSavingThrows()[4]);
        values.put(CHARISMA_SAVE, p.getSavingThrows()[5]);
        values.put(ACROBATICS, p.getSkills()[0]);
        values.put(ANIMAL_HANDLING, p.getSkills()[1]);
        values.put(ARCANA, p.getSkills()[2]);
        values.put(ATHLETICS, p.getSkills()[3]);
        values.put(DECEPTION, p.getSkills()[4]);
        values.put(HISTORY, p.getSkills()[5]);
        values.put(INSIGHT, p.getSkills()[6]);
        values.put(INTIMIDATION, p.getSkills()[7]);
        values.put(INVESTIGATION, p.getSkills()[8]);
        values.put(MEDICINE, p.getSkills()[9]);
        values.put(NATURE, p.getSkills()[10]);
        values.put(PERCEPTION, p.getSkills()[11]);
        values.put(PERFORMANCE, p.getSkills()[12]);
        values.put(PERSUASION, p.getSkills()[13]);
        values.put(RELIGION, p.getSkills()[14]);
        values.put(SLEIGHT_OF_HAND, p.getSkills()[15]);
        values.put(STEALTH, p.getSkills()[16]);
        values.put(SURVIVAL, p.getSkills()[17]);

        try {
            helper.beginTransaction();
            long result = helper.insert( PROFILE_TABLE, null, values);
            helper.setTransactionSuccessful();

            return result != -1;
        }catch (SQLException exc){
            Log.e("DataBase.addProfile", "Error al añadir perfil: " + exc.getMessage());
            return false;
        }finally {
            helper.endTransaction();
            helper.close();
        }
    }

    public ArrayList<CharacterProfile> getCharacterProfiles(String email){
        ArrayList<CharacterProfile> profiles =
                new ArrayList<>();

        SQLiteDatabase helper =
                getReadableDatabase();

        Cursor cursor = helper.query(
                PROFILE_TABLE,
                null,
                USER + " = ?",
                new String[]{email},
                null,
                null,
                CHARACTER_NAME
        );

        if (cursor.moveToFirst()) {

            do {
                profiles.add(buildCharacterProfile(cursor));
            } while (cursor.moveToNext());
        }
        cursor.close();
        helper.close();

        return profiles;
    }

    private CharacterProfile buildCharacterProfile(
            Cursor cursor
    ) {
        return new CharacterProfile(
                cursor.getString(cursor.getColumnIndexOrThrow(CHARACTER_NAME)),
                "",
                cursor.getInt(cursor.getColumnIndexOrThrow(STRENGTH)),
                cursor.getInt(cursor.getColumnIndexOrThrow(DEXTERITY)),
                cursor.getInt(cursor.getColumnIndexOrThrow(CONSTITUTION)),
                cursor.getInt(cursor.getColumnIndexOrThrow(INTELLIGENCE)),
                cursor.getInt(cursor.getColumnIndexOrThrow(WISDOM)),
                cursor.getInt(cursor.getColumnIndexOrThrow(CHARISMA)),
                cursor.getInt(cursor.getColumnIndexOrThrow(CHARACTER_LEVEL)),
                getSavingThrows(cursor),
                getSkills(cursor),
                cursor.getInt(cursor.getColumnIndexOrThrow(GOLD)),
                cursor.getInt(cursor.getColumnIndexOrThrow(HITPOINTS))
        );
    }


    private boolean getBoolean(
            Cursor cursor,
            String column
    ) {
        return cursor.getInt(
                cursor.getColumnIndexOrThrow(column)
        ) == 1;
    }

    private boolean[] getSavingThrows(
            Cursor cursor
    ) {
        return new boolean[]{
                getBoolean(cursor, STRENGTH_SAVE),
                getBoolean(cursor, DEXTERITY_SAVE),
                getBoolean(cursor, CONSTITUTION_SAVE),
                getBoolean(cursor, INTELLIGENCE_SAVE),
                getBoolean(cursor, WISDOM_SAVE),
                getBoolean(cursor, CHARISMA_SAVE)
        };
    }

    private boolean[] getSkills(
            Cursor cursor
    ) {

        String[] skillColumns = {
                ACROBATICS,
                ANIMAL_HANDLING,
                ARCANA,
                ATHLETICS,
                DECEPTION,
                HISTORY,
                INSIGHT,
                INTIMIDATION,
                INVESTIGATION,
                MEDICINE,
                NATURE,
                PERCEPTION,
                PERFORMANCE,
                PERSUASION,
                RELIGION,
                SLEIGHT_OF_HAND,
                STEALTH,
                SURVIVAL
        };

        boolean[] skills =
                new boolean[skillColumns.length];

        for (int i = 0; i < skillColumns.length; i++) {
            skills[i] =
                    getBoolean(cursor, skillColumns[i]);
        }

        return skills;
    }


}

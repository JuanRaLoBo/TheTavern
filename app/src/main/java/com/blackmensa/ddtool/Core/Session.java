package com.blackmensa.ddtool.Core;

import android.content.Context;
import android.content.SharedPreferences;

public class Session {
    private String currentUser;
    private SharedPreferences preferencesSession;
    private SharedPreferences.Editor prefEditor = preferencesSession.edit();
    private CharacterProfile SelectedCharacter;

    public Session(Context context) {
        preferencesSession = context.getSharedPreferences("The Tavern", Context.MODE_PRIVATE);
    }

    public void setCurrentUser(String s){
        currentUser = s;
    }

    public String getCurrentUser(){
        return currentUser;
    }

    public void SetLoggedState(boolean logged){
        prefEditor.putBoolean("loggedIn", logged);
        prefEditor.apply();
    }

    public boolean loggedIn(){
        return preferencesSession.getBoolean("loggedIn", false);
    }

    public void setCurrentCharacter(CharacterProfile profile){
        //ESTO SE HACE EN LA LISTA DE PERFILES
        this.SelectedCharacter = profile;
    }

    public CharacterProfile getCurrentCharacter(){
        return SelectedCharacter;
    }
}

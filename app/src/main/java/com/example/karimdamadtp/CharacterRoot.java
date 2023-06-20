package com.example.karimdamadtp;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CharacterRoot {
    @SerializedName("data")
    private List<Character> characterList;

    public CharacterRoot(List<Character> characterList) {
        this.characterList = characterList;
    }

    public List<Character> getCharacterList() {
        return characterList;
    }

    public void setCharacterList(List<Character> characterList) {
        this.characterList = characterList;
    }
}

//Character.java

package com.advancedjava.DnDCharacterCreator;

import jakarta.persistence.*;

@Entity
@Table(name = "Character")

public class Character {

    @Id
    @GeneratedValue


    private Long id;

    @Column
    private String characterName;

    @Column
    private String characterRace;

    @Column
    private String characterClass;

    @Column
    private Integer characterCharisma;

    @Column
    private Integer characterConstitution;

    @Column
    private Integer characterDexterity;

    @Column
    private Integer characterIntelligence;

    @Column
    private Integer characterStrength;

    @Column
    private Integer characterWisdom;


    // Getters and setters for each field
    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getCharacterRace() {
        return characterRace;
    }

    public void setCharacterRace(String characterRace) {
        this.characterRace = characterRace;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    public Integer getCharacterCharisma() {
        return characterCharisma;
    }

    public void setCharacterCharisma(Integer charisma) {
        this.characterCharisma = charisma;
    }

    public Integer getCharacterConstitution() {
        return characterConstitution;
    }

    public void setCharacterConstitution(Integer constitution) {
        this.characterConstitution = constitution;
    }

    public Integer getCharacterDexterity() {
        return characterDexterity;
    }

    public void setCharacterDexterity(Integer dexterity) {
        this.characterDexterity = dexterity;
    }

    public Integer getCharacterIntelligence() {
        return characterIntelligence;
    }

    public void setCharacterIntelligence(Integer intelligence) {
        this.characterIntelligence = intelligence;
    }

    public Integer getCharacterStrength() {
        return characterStrength;
    }

    public void setCharacterStrength(Integer strength) {
        this.characterStrength = strength;
    }

    public Integer getCharacterWisdom() {
        return characterWisdom;
    }

    public void setCharacterWisdom(Integer wisdom) {
        this.characterWisdom = wisdom;
    }



    @Override
    public String toString() {
        return "Character [characterName=" + characterName + ", characterRace=" + characterRace + ", characterClass=" + characterClass + ",charisma=" + characterCharisma + ", constitution=" + characterConstitution + ", dexterity=" + characterDexterity + ", intelligence=" + characterIntelligence + ", strength=" + characterStrength + ", wisdom=" + characterWisdom + "]";
    }
}

package com.advancedjava.DnDCharacterCreator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CharacterTest {

    @Test
    public void testCharacterConstitution() {
        Character character = new Character();
        Integer expectedConstitution = 10;
        character.setCharacterConstitution(expectedConstitution);
        Integer actualConstitution = character.getCharacterConstitution();
        Assertions.assertEquals(expectedConstitution, actualConstitution);
    }
}
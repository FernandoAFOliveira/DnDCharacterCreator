package com.advancedjava.DnDCharacterCreator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CharacterRepositoryTest {

    @Mock
    private CharacterRepository repository;

    @Test
    public void testFindById() {
        Long id = 1L;
        Character character = new Character();
        when(repository.findById(id)).thenReturn(Optional.of(character));

        Optional<Character> result = repository.findById(id);

        assertEquals(Optional.of(character), result);
        verify(repository).findById(id);
    }

    // Add more test methods for other methods in CharacterRepository if needed

}
package com.advancedjava.DnDCharacterCreator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class WebControllerTest {

    @Mock
    private CharacterRepository repository;

    private WebController webController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        webController = new WebController(repository);
    }

    @Test
    public void testIndexPage() {
        Model model = mock(Model.class);

        String result = webController.indexPage(model);

        assertEquals("index", result);
        verify(model).addAttribute(eq("characterForm"), any(Character.class));
    }

    @Test
    public void testSuccessPage() {
        Character character = new Character();
        when(repository.save(character)).thenReturn(character);

        String result = webController.successPage(character);

        assertEquals("redirect:/success", result);
        verify(repository).save(character);
    }

    @Test
    public void testShowCharacters() {
        Model model = mock(Model.class);
        List<Character> characters = new ArrayList<>();
        when(repository.findAll()).thenReturn(characters);

        String result = webController.showCharacters(model);

        assertEquals("success", result);
        verify(model).addAttribute("characters", characters);
    }
}
//WebControler.java
package com.advancedjava.DnDCharacterCreator;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class WebController {

    @Autowired
    private CharacterRepository repository;

    private static final Logger logger = LoggerFactory.getLogger(WebController.class);

    @GetMapping("/")
    public String indexPage(Model model) {
        logger.info("Handling index page request");
        model.addAttribute("characterForm", new Character());
        return "index";
    }

    @PostMapping("/success")
    public String successPage(@ModelAttribute Character character) {
        logger.info("Handling form submission for character: {}", character);
        logger.info("Character stats: Charisma - {}, Constitution - {} Dexterity - {}, Intelligence - {}, Strength - {}, Wisdom - {}", character.getCharacterCharisma(), character.getCharacterConstitution(), character.getCharacterDexterity(), character.getCharacterIntelligence(), character.getCharacterStrength(), character.getCharacterWisdom());
        repository.save(character);
        return "redirect:/success";
    }

    @GetMapping("/success")
    public String showCharacters(Model model) {
        logger.info("Displaying the success page");
        List<Character> characters = (List<Character>) repository.findAll();
        model.addAttribute("characters", characters);
        return "success";
    }
}

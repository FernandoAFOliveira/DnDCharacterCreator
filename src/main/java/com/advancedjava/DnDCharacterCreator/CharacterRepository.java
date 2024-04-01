//CharacterRepository.java

package com.advancedjava.DnDCharacterCreator;

import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface CharacterRepository extends CrudRepository<Character, Long> {

    @Override
    Optional<Character> findById(Long id);

}

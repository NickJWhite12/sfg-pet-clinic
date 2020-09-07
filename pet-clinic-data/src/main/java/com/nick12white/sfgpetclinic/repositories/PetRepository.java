package com.nick12white.sfgpetclinic.repositories;

import com.nick12white.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}

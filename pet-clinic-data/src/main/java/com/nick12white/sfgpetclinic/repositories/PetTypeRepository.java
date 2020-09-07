package com.nick12white.sfgpetclinic.repositories;

import com.nick12white.sfgpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}

package com.nick12white.sfgpetclinic.repositories;

import com.nick12white.sfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
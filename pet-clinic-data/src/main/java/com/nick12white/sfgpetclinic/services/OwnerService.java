package com.nick12white.sfgpetclinic.services;

import com.nick12white.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);

}

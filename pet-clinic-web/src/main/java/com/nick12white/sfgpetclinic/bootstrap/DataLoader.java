package com.nick12white.sfgpetclinic.bootstrap;

import com.nick12white.sfgpetclinic.model.Owner;
import com.nick12white.sfgpetclinic.model.PetType;
import com.nick12white.sfgpetclinic.model.Vet;
import com.nick12white.sfgpetclinic.services.OwnerService;
import com.nick12white.sfgpetclinic.services.VetService;
import com.nick12white.sfgpetclinic.services.map.PetTypeMapService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeMapService petTypeMapService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeMapService petTypeMapService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeMapService = petTypeMapService;
    }


    @Override
    public void run(String... args) throws Exception {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeMapService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeMapService.save(cat);

        Owner owner1  = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        ownerService.save(owner1);

        Owner owner2= new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Poeter");

        vetService.save(vet2);

        System.out.println("Loaded vets...");
    }
}

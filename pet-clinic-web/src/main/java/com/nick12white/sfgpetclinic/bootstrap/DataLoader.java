package com.nick12white.sfgpetclinic.bootstrap;

import com.nick12white.sfgpetclinic.model.*;
import com.nick12white.sfgpetclinic.services.OwnerService;
import com.nick12white.sfgpetclinic.services.SpecialtyService;
import com.nick12white.sfgpetclinic.services.VetService;
import com.nick12white.sfgpetclinic.services.VisitService;
import com.nick12white.sfgpetclinic.services.map.PetTypeMapService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeMapService petTypeMapService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeMapService petTypeMapService,
                      SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeMapService = petTypeMapService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeMapService.findAll().size();

        if(count == 0) {
            LoadData();
        }
    }

    private void LoadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeMapService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeMapService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);

        Owner owner1  = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Place");
        owner1.setCity("Miami");
        owner1.setTelephone("123412341234");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2= new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setFirstName("Michael");
        owner2.setLastName("Weston");
        owner2.setAddress("123 Place");
        owner2.setCity("Miami");
        owner2.setTelephone("123412341234");

        Pet fionasCat = new Pet();
        fionasCat.setOwner(owner2);
        fionasCat.setName("Indie");
        fionasCat.setBirthDate(LocalDate.now());
        fionasCat.setPetType(savedCatPetType);
        owner2.getPets().add(fionasCat);

        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setDate(LocalDate.now());
        catVisit.setPet(fionasCat);
        catVisit.setDescription("Sneezing");

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialties().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Poeter");
        vet2.getSpecialties().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded vets...");
    }
}

package com.nfinity.demo.petsdemoa.domain.pets;

import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import javax.validation.constraints.Positive;
import com.nfinity.demo.petsdemoa.domain.model.PetsEntity;
import com.nfinity.demo.petsdemoa.domain.model.VisitsEntity;
import com.nfinity.demo.petsdemoa.domain.model.TypesEntity;
import com.nfinity.demo.petsdemoa.domain.model.OwnersEntity;

public interface IPetsManager {
    // CRUD Operations
    PetsEntity create(PetsEntity pets);

    void delete(PetsEntity pets);

    PetsEntity update(PetsEntity pets);

    PetsEntity findById(Integer id);
	
    Page<PetsEntity> findAll(Predicate predicate, Pageable pageable);
   
    //Types
    public TypesEntity getTypes(Integer petsId);
   
    //Owners
    public OwnersEntity getOwners(Integer petsId);
}

package com.nfinity.demo.petsdemoa.domain.types;

import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import javax.validation.constraints.Positive;
import com.nfinity.demo.petsdemoa.domain.model.TypesEntity;
import com.nfinity.demo.petsdemoa.domain.model.PetsEntity;

public interface ITypesManager {
    // CRUD Operations
    TypesEntity create(TypesEntity types);

    void delete(TypesEntity types);

    TypesEntity update(TypesEntity types);

    TypesEntity findById(Integer id);
	
    Page<TypesEntity> findAll(Predicate predicate, Pageable pageable);
}

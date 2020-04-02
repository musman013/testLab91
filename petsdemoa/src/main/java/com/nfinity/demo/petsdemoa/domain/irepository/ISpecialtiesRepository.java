package com.nfinity.demo.petsdemoa.domain.irepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.nfinity.demo.petsdemoa.domain.model.VetSpecialtiesEntity; 
import java.util.List;
import com.nfinity.demo.petsdemoa.domain.model.SpecialtiesEntity;
import org.javers.spring.annotation.JaversSpringDataAuditable;

@JaversSpringDataAuditable
@RepositoryRestResource(collectionResourceRel = "specialties", path = "specialties")
public interface ISpecialtiesRepository extends JpaRepository<SpecialtiesEntity, Integer>,QuerydslPredicateExecutor<SpecialtiesEntity> {

}

package com.nfinity.demo.petsdemoa.application.specialties;

import org.mapstruct.Mapper;
import com.nfinity.demo.petsdemoa.application.specialties.dto.*;
import com.nfinity.demo.petsdemoa.domain.model.SpecialtiesEntity;

@Mapper(componentModel = "spring")
public interface SpecialtiesMapper {

   SpecialtiesEntity createSpecialtiesInputToSpecialtiesEntity(CreateSpecialtiesInput specialtiesDto);
   
   CreateSpecialtiesOutput specialtiesEntityToCreateSpecialtiesOutput(SpecialtiesEntity entity);

   SpecialtiesEntity updateSpecialtiesInputToSpecialtiesEntity(UpdateSpecialtiesInput specialtiesDto);

   UpdateSpecialtiesOutput specialtiesEntityToUpdateSpecialtiesOutput(SpecialtiesEntity entity);

   FindSpecialtiesByIdOutput specialtiesEntityToFindSpecialtiesByIdOutput(SpecialtiesEntity entity);


}

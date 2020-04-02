package com.nfinity.demo.petsdemoa.application.authorization.role;

import com.nfinity.demo.petsdemoa.application.authorization.role.dto.*;
import com.nfinity.demo.petsdemoa.domain.model.PermissionEntity;
import com.nfinity.demo.petsdemoa.domain.model.RoleEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleEntity createRoleInputToRoleEntity(CreateRoleInput roleDto);

    CreateRoleOutput roleEntityToCreateRoleOutput(RoleEntity entity);

    RoleEntity updateRoleInputToRoleEntity(UpdateRoleInput roleDto);

    UpdateRoleOutput roleEntityToUpdateRoleOutput(RoleEntity entity);

    FindRoleByIdOutput roleEntityToFindRoleByIdOutput(RoleEntity entity);
    
    FindRoleByNameOutput roleEntityToFindRoleByNameOutput(RoleEntity entity);

}

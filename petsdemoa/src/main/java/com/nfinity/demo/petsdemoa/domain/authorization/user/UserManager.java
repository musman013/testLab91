package com.nfinity.demo.petsdemoa.domain.authorization.user;

import com.nfinity.demo.petsdemoa.domain.model.RoleEntity;
import com.nfinity.demo.petsdemoa.domain.model.UserEntity;
import com.nfinity.demo.petsdemoa.domain.irepository.IUserpermissionRepository;
import com.nfinity.demo.petsdemoa.domain.irepository.IRoleRepository;
import com.nfinity.demo.petsdemoa.domain.irepository.IUserRepository;
import com.nfinity.demo.petsdemoa.commons.logging.LoggingHelper;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import com.nfinity.demo.petsdemoa.commons.search.SearchFields;

import java.util.Optional;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Repository

public class UserManager implements IUserManager {

	@Autowired
    IUserRepository  _userRepository;
    
    @Autowired
	IUserpermissionRepository  _userpermissionRepository;
    
    @Autowired
	IRoleRepository  _roleRepository;
    
	public UserEntity create(UserEntity user) {

		return _userRepository.save(user);
	}

	public void delete(UserEntity user) {

		_userRepository.delete(user);	
	}

	public UserEntity update(UserEntity user) {

		return _userRepository.save(user);
	}

	public UserEntity findById(Long  userId) {
    Optional<UserEntity> dbUser= _userRepository.findById(userId);
		if(dbUser.isPresent()) {
			UserEntity existingUser = dbUser.get();
		    return existingUser;
		} else {
		    return null;
		}
	}

	public Page<UserEntity> findAll(Predicate predicate, Pageable pageable) {

		return _userRepository.findAll(predicate,pageable);
	}

	public UserEntity findByUserName(String userName) {
		return  _userRepository.findByUserName(userName);
	}
 
}


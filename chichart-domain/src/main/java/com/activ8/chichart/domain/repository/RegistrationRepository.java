package com.activ8.chichart.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.activ8.chichart.domain.entity.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    Registration findFirstByUserKey(String userKey);
    
    Optional<Registration> findByIdAndParentUserId(Long id, Long parentUserId);
    
    List<Registration> findAllByParentUserId(Long id);
}

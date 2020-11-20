package com.softserveinc.dokazovi.service;

import com.softserveinc.dokazovi.dto.user.ExpertPreviewDTO;
import com.softserveinc.dokazovi.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface UserService {

	Page<UserEntity> findAll(Pageable pageable);

	Page<ExpertPreviewDTO> getExpertsPreview(Pageable pageable);

	Optional<UserEntity> findById(Integer id);

	Optional<UserEntity> findByEmail(String email);

	Boolean existsByEmail(String email);

	UserEntity save(UserEntity userEntity);

}

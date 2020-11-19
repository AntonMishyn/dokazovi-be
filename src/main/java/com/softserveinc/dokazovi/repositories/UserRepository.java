package com.softserveinc.dokazovi.repositories;

import com.softserveinc.dokazovi.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

	Optional<UserEntity> findByEmail(String email);

	Boolean existsByEmail(String email);

	@Query(nativeQuery = true,
			value = "SELECT * FROM users u WHERE u.status='ACTIVE' ORDER BY random()")
	Page<UserEntity> findRandomActiveUsers(Pageable pageable);
}

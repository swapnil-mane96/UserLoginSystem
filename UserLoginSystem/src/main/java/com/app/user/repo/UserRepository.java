package com.app.user.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.user.entity.Users;

/**
 * @author swapnil.mane
 *
 */
@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
	Optional<Users> findByEmailAddress(String email);
	
	//List<Users> findByEmailAddress(String emailAddress);
}

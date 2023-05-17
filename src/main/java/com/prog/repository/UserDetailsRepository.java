package com.prog.repository;

import com.prog.entity.UserDetails;
import org.springframework.data.repository.CrudRepository;

public interface UserDetailsRepository extends CrudRepository<UserDetails, Integer> {
}

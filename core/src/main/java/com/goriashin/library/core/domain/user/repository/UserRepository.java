package com.goriashin.library.core.domain.user.repository;

import com.goriashin.library.core.domain.user.model.UserTM;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserTM, Long> {

    Optional<UserTM> findByUsername(String username);

}

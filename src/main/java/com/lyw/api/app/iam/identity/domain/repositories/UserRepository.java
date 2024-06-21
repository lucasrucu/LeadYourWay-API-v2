package com.lyw.api.app.iam.identity.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lyw.api.app.iam.identity.domain.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}

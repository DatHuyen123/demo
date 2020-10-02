package com.dangvandat.repository;

import com.dangvandat.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity , Long> {
    UserEntity findOneByUserNameAndStatus(String username, int status);
}

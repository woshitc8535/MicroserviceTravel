package com.xuanxuan.authserver.repository;

import com.xuanxuan.authserver.entity.User;
import com.xuanxuan.authserver.model.UserInfoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findUserByEmail(String email);
}

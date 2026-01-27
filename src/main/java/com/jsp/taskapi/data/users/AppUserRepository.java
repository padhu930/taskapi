package com.jsp.taskapi.data.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepository  extends JpaRepository<AppUser,Long> {
    boolean existsByEmailOrMobile(String email,String mobile);
    boolean existsByMobile(String mobile);
    AppUser findByName(String name);
    Optional<AppUser> findByEmail(String email);
    AppUser findByMobile(String mobile);
    boolean existsByEmailAndPassword(String email,String password);
    boolean existsByMobileAndPassword(String mobile,String password);
}

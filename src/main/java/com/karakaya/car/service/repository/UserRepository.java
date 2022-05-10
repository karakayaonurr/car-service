package com.karakaya.car.service.repository;

import com.karakaya.car.service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by TCOKARAKAYA on 9.05.2022.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
    List<User> findAllByName(String name);
}

package com.karakaya.car.service.repository;

import com.karakaya.car.service.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by TCOKARAKAYA on 11.05.2022.
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long>
{
}

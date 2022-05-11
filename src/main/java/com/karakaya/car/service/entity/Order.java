package com.karakaya.car.service.entity;

import com.karakaya.car.service.model.response.OrderResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by TCOKARAKAYA on 11.05.2022.
 */
@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
@ToString
public class Order extends BaseEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal price;

    @ManyToOne
    private User user;

    @ManyToMany
    private List<Car> carList;

    public static OrderResponse toOrderResponse (Order order){
        return OrderResponse.builder()
                .price(order.getPrice())
                .user(User.toUserResponse(order.getUser()))
                .carList(Car.toCarResponseList(order.getCarList()))
                .build();
    }

}

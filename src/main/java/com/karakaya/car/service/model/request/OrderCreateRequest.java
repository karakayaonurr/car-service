package com.karakaya.car.service.model.request;

import com.karakaya.car.service.entity.Car;
import com.karakaya.car.service.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by TCOKARAKAYA on 11.05.2022.
 */
@Getter
@Builder
@ToString
public class OrderCreateRequest
{
    private Long userId;
    private List<Long> carIdList;
}

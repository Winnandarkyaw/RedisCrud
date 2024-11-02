package com.jts.redis_crud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Order")
public class Order  implements Serializable {
    @Id
    private int id;

    private String details;
    private int qty;
    private long price;
}

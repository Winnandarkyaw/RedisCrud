package com.jts.redis_crud.dao;

import com.jts.redis_crud.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDao {

    private static final String HASH_KEY = "Order";

    @Autowired
    private RedisTemplate template;

    public Order save(Order order) {
        template.opsForHash().put(HASH_KEY, order.getId(), order);
        return order;
    }

    public List<Order> findAll() {
        return template.opsForHash().values(HASH_KEY);
    }

    public Order findOrderById(int id) {
        return (Order) template.opsForHash().get(HASH_KEY, id);
    }

    public String deleteOrder(int id) {
        template.opsForHash().delete(HASH_KEY, id);
        return "Order deleted successfully!";
    }

}

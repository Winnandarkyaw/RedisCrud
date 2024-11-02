package com.jts.redis_crud;

import com.jts.redis_crud.dao.OrderDao;
import com.jts.redis_crud.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RedisController {
    @Autowired
    private OrderDao orderDao;

    @PostMapping("/save")
    public Order save(@RequestBody Order order)
    {
        return orderDao.save(order);
    }

    @GetMapping("/findAll")
    public List<Order> findAll()
    {
        return orderDao.findAll();
    }

    @GetMapping("/findById/{id}")
    public Order findById(@PathVariable int id)
    {
        return orderDao.findOrderById(id);
    }

    @DeleteMapping("/remove/{id}")
    public String remove(@PathVariable int id)
    {
        return orderDao.deleteOrder(id);
    }
}

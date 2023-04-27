package com.example.finalapp.repositories;

import com.example.finalapp.models.Order;
import com.example.finalapp.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    //Получаем список заказов конкретного пользователя
    List<Order> findByPerson(Person person);
}

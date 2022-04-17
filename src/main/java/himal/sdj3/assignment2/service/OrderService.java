package himal.sdj3.assignment2.service;

import himal.sdj3.assignment2.model.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;


public interface OrderService {

    Order addOrder(Order  order);

    Order findOrder(Long id);

    void deleteOrder(Long id);
    
    Order updateOrder(Order order,Long id);


    List<Order> getAllOrder();
}

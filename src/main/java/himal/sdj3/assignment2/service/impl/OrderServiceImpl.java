package himal.sdj3.assignment2.service.impl;

import himal.sdj3.assignment2.Exception.ResourceNotFoundException;
import himal.sdj3.assignment2.model.Order;
import himal.sdj3.assignment2.repository.OrderRepository;
import himal.sdj3.assignment2.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl  implements OrderService {

    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order findOrder(Long id) {
        return orderRepository.findById(id).orElseThrow(() ->new ResourceNotFoundException("Order","Id",id));
    }

    @Override
    public void deleteOrder(Long id) {
       findOrder(id);
       orderRepository.deleteById(id);

    }

    @Override
    public Order updateOrder(Order order, Long id) {
        Order existingOrder = findOrder(id);

        existingOrder.setAmount(order.getAmount());
        existingOrder.setDelivered(order.isDelivered());
        existingOrder.setDescription(order.getDescription());

        orderRepository.save(existingOrder);

        return existingOrder;

    }

    @Override
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }


}

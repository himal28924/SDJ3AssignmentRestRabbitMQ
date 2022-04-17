package himal.sdj3.assignment2.controller;


import himal.sdj3.assignment2.model.Order;
import himal.sdj3.assignment2.service.OrderService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/Order")
public class OrderController  {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> addOrder(@RequestBody Order order){
        return new ResponseEntity<>(orderService.addOrder(order), HttpStatus.CREATED);
    }



    @DeleteMapping("{id}")
    public ResponseEntity<String> removeOrder( @PathVariable("id") Long id){
        orderService.deleteOrder(id);
        return new ResponseEntity<String>("Order deleted succesfully",HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable("id") Long id,@RequestBody Order order){
        return new ResponseEntity<>(orderService.updateOrder(order,id),HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Order> findOrder(@PathVariable("id") Long id){
        return new ResponseEntity<>(orderService.findOrder(id),HttpStatus.OK);
    }

    @GetMapping
    public List<Order> getAllOrder(){
        return orderService.getAllOrder();
    }

}

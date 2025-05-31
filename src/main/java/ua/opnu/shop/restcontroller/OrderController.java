package ua.opnu.shop.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.opnu.shop.model.Order;
import ua.opnu.shop.service.OrderService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Optional<Order> getOrderById(@PathVariable long id) {
        return orderService.getOrderById(id);
    }

    @PostMapping
    public void createOrder(@RequestBody String customerLogin, long daysCount) {
        orderService.createOrder(customerLogin, daysCount);
    }

    @PutMapping("/{id}/status")
    public void updateOrderStatus(@PathVariable long id) {
        orderService.updateOrderStatus(id);
    }
}

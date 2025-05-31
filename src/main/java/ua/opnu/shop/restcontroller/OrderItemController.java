package ua.opnu.shop.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.opnu.shop.model.Order;
import ua.opnu.shop.model.OrderItem;
import ua.opnu.shop.service.OrderItemService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order-items")
public class OrderItemController {

    private final OrderItemService orderItemService;

    @Autowired
    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @PostMapping
    public void createOrderItem(@RequestBody OrderItem orderItem) {
        orderItemService.createOrderItem(orderItem);
    }

    @GetMapping("/order/{orderId}")
    public Optional<List<OrderItem>> getOrderItemsByOrderId(@PathVariable long orderId) {
        List<OrderItem> orderItems = orderItemService.getOrderItemsByOrderId(orderId);
        return Optional.of(orderItems);
    }
}

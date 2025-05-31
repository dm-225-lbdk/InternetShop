package ua.opnu.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.opnu.shop.model.Order;
import ua.opnu.shop.model.OrderItem;
import ua.opnu.shop.service.OrderItemService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/order-items")
public class OrderItemController {

    private final OrderItemService orderItemService;

    @Autowired
    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @GetMapping("/order/{orderId}")
    public String getOrderItemsByOrderId(@PathVariable Long orderId, Model model) {
        List<OrderItem> orderItems = orderItemService.getOrderItemsByOrderId(orderId);
        model.addAttribute("orderItems", orderItems);
        model.addAttribute("isProduct", !orderItems.isEmpty());

        Optional<Order> order = orderItemService.getOrder(orderId);
        model.addAttribute("isOrder", order.isPresent());
        order.ifPresent(value -> model.addAttribute("order", value));

        return "order-items";
    }

    @PostMapping
    public void createOrderItem(@RequestBody OrderItem orderItem) {
        orderItemService.createOrderItem(orderItem);
    }
}

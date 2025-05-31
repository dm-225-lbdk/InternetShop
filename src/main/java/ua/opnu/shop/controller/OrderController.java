package ua.opnu.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.opnu.shop.model.Order;
import ua.opnu.shop.service.OrderService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public String getOrders(Model model) {
        List<Order> orders = orderService.getAllOrders();
        model.addAttribute("orders", orders);
        return "orders";
    }

    @GetMapping("/{id}")
    public String getOrderById(@PathVariable("id") Long id, Model model) {
        Optional<Order> order = orderService.getOrderById(id);
        model.addAttribute("isOrder", order.isPresent());
        order.ifPresent(value -> model.addAttribute("order", value));
        return "order";
    }

    @PostMapping
    public String createOrder(@RequestParam String customerLogin,
                              @RequestParam long daysCount) {
        orderService.createOrder(customerLogin, daysCount);
        return "redirect:/orders";
    }
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("order", new Order());
        return "order-create";
    }

    @PutMapping("/{id}/status")
    public String updateOrderStatus(@PathVariable Long id) {
        orderService.updateOrderStatus(id);
        return "redirect:/orders/{id}";
    }


}

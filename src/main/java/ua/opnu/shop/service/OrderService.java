package ua.opnu.shop.service;

import org.springframework.stereotype.Service;
import ua.opnu.shop.model.Order;
import ua.opnu.shop.repository.OrderItemRepository;
import ua.opnu.shop.repository.OrderRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {this.orderRepository = orderRepository;}

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public void createOrder(String customerLogin, long daysCount) {
        orderRepository.save(new Order(customerLogin, daysCount));
    }

    public void updateOrderStatus(Long id) {
        orderRepository.findById(id).ifPresent(order -> {
            order.setStatus(!order.getStatus());
            orderRepository.save(order);
        });
    }
}

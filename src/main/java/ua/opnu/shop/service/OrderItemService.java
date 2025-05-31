package ua.opnu.shop.service;

import org.springframework.stereotype.Service;
import ua.opnu.shop.model.Order;
import ua.opnu.shop.model.OrderItem;
import ua.opnu.shop.model.Product;
import ua.opnu.shop.repository.OrderItemRepository;
import ua.opnu.shop.repository.OrderRepository;
import ua.opnu.shop.repository.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderItemService {
    private final OrderItemRepository orderItemsRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderItemService(OrderItemRepository orderItemsRepository,
                            OrderRepository orderRepository,
                            ProductRepository productRepository) {
        this.orderItemsRepository = orderItemsRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public List<OrderItem> getOrderItemsByOrderId(Long orderId) {
        return orderItemsRepository.findByOrderId(orderId);
    }

    public void createOrderItem(OrderItem orderItem) {
        orderItemsRepository.save(orderItem);
    }

    public Optional<Order> getOrder(Long orderId) {
        return orderRepository.findById(orderId);
    }
}




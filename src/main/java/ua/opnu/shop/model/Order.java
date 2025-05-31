package ua.opnu.shop.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "orders")
@Setter
@Getter
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String customerLogin;
    private LocalDate date;
    private Boolean status;

    public Order(String customerLogin, Long daysCount) {
        this.customerLogin = customerLogin;
        this.date = LocalDate.now().plusDays(daysCount);
        this.status = false;
    }
}

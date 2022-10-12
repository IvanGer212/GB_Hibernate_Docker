package entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table (name = "product")
public class Product {
    @Id
    @GeneratedValue (strategy =  GenerationType.IDENTITY)
    Long id;

    @Column (name = "title")
    String title;

    @Column (name = "price")
    int price;


    @ManyToMany (fetch = FetchType.LAZY)
    @JoinTable (
            name = "product_customer",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id")
    )
    public List<Customer> customers;

        public Product(){}

    public Product(String title, int price) {
        this.title = title;
        this.price = price;
        customers = new ArrayList<>();
    }

    public Product(Long id, String title, int price) {
        this.id = id;
        this.title = title;
        this.price = price;
        //this.customers = customers;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}

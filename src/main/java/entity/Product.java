package entity;
import lombok.Data;

import javax.persistence.*;

@Data
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

    public Product(){}

    public Product(String title, int price) {
        this.title = title;
        this.price = price;
    }
}

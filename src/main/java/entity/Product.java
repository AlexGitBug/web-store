package entity;

import entity.enums.Brand;
import entity.enums.Color;
import entity.enums.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "product", schema = "public")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "catalog_id")
    private Integer catalogId;

    @Enumerated(EnumType.STRING)
    @Column(unique = true)
    private Brand brand;

    @Enumerated(EnumType.STRING)
    @Column(unique = true)
    private Model model;

    private LocalDate dateOfRelease;
    private Integer price;

    @Enumerated(EnumType.STRING)
    private Color color;

    @Column(name = "image")
    private String image;
}

package ua.lviv.iot.DB_Lab.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"author", "categories", "reviews", "infos"})
@Table(name = "app")
public class App {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;

    @Column
    private double size;

    @Column
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "category_app",
    joinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "app_id", referencedColumnName = "id"))
    private List<Category> categories;

    @OneToMany(mappedBy = "app")
    private List<Review> reviews;

    @OneToMany(mappedBy = "app")
    private List<Info> infos;

    @Column
    private float sale;

    @Column(name = "`install`")
    private int install;

    @Column(name = "`delete`")
    private int delete;

}

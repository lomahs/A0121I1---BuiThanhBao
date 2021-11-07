package vn.codegym.furamaresort.model.customer;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerTypeId;

    @Column(length = 45, nullable = false)
    private String customerTypeName;

    @OneToMany(mappedBy = "customerType")
    @JsonBackReference
    private Set<Customer> listCustomers = new HashSet<>();

}
package vn.codegym.furamaresort.model.service;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rentTypeId;

    @Column(length = 45)
    private String rentTypeName;

    private double rentTypeCost;

    @OneToMany(mappedBy = "rentType")
    @JsonBackReference
    private Set<Service> listServices;
}
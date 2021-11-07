package vn.codegym.furamaresort.model.employee;

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
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int divisionId;

    @Column(length = 45, nullable = false)
    private String divisionName;

    @OneToMany(mappedBy = "division")
    @JsonBackReference
    private Set<Employee> listEmployee;
}
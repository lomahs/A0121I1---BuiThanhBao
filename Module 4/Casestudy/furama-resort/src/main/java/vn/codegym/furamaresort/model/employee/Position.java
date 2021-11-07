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
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int positionId;

    @Column(nullable = false, length = 45)
    private String positionName;

    @OneToMany(mappedBy = "position")
    @JsonBackReference
    private Set<Employee> listEmployee;
}
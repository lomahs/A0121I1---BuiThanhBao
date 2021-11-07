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
public class EducationDegree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int educationDegreeId;

    @Column(nullable = false, length = 45)
    private String educationDegreeName;

    @OneToMany(mappedBy = "educationDegree")
    @JsonBackReference
    private Set<Employee> listEmployee;
}
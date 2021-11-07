package vn.codegym.furamaresort.model.service;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ServiceType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int serviceTypeId;

    @Column(length = 45)
    private String serviceTypeName;

    @OneToMany(mappedBy = "serviceType")
    @JsonBackReference
    private Set<Service> listServices;
}
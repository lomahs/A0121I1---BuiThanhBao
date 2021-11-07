package vn.codegym.furamaresort.model.service;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.codegym.furamaresort.model.contract.ContractDetail;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AttachService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int attachServiceId;

    @Column(length = 45)
    private String attachServiceName;

    private double attachServiceCost;

    private int attachServiceUnit;

    @Column(length = 45)
    private String attachServiceStatus;

    @OneToMany(mappedBy = "attachService")
    @JsonBackReference
    private Set<ContractDetail> listContractDetails;
}
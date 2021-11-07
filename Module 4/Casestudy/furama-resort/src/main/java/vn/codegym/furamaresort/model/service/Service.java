package vn.codegym.furamaresort.model.service;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import vn.codegym.furamaresort.model.contract.Contract;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Service {

    @Id
    @GeneratedValue(generator = "id_gen_service")
    @GenericGenerator(name = "id_gen_service", parameters = @Parameter(name = "prefix", value = "DV-"), strategy = "vn.codegym.furamaresort.utils.IdGenerator")
    private String serviceId;

    @Column(length = 45)
    @NotBlank(message = "Name id required")
    private String serviceName;

    @Min(value = 1, message = "Area must be bigger than 0")
    private int serviceArea;

    @Min(value = 1, message = "Cost must be bigger than 0")
    private double serviceCost;

    @Min(value = 1, message = "Number of max people must be bigger than 0")
    private int serviceMaxPeople;

    @ManyToOne
    @JoinColumn(name = "rentTypeId")
    @NotNull
    private RentType rentType;

    @ManyToOne
    @JoinColumn(name = "serviceTypeId")
    @NotNull
    private ServiceType serviceType;

    @Column(length = 45)
    private String standardRoom;

    @Column(length = 45)
    private String descriptionOtherConvenience;

    private double poolArea;

    @Min(value = 1, message = "Number of max people must be bigger than 0")
    private int numberOfFloors;

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<Contract> listContracts;
}
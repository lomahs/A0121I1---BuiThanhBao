package vn.codegym.furamaresort.model.contract;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import vn.codegym.furamaresort.model.customer.Customer;
import vn.codegym.furamaresort.model.employee.Employee;
import vn.codegym.furamaresort.model.service.Service;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contractId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate contractStartDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate contractEndDate;

    @NotNull
    @Min(value = 0, message = "Deposit must not be negative number")
    private double contractDeposit;

    private double contractTotalMoney;

    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "serviceId")
    private Service service;

    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<ContractDetail> listContractDetails;
}
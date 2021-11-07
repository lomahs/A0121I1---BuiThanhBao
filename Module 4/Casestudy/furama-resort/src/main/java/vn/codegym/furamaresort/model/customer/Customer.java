package vn.codegym.furamaresort.model.customer;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.format.annotation.DateTimeFormat;
import vn.codegym.furamaresort.model.contract.Contract;
import vn.codegym.furamaresort.validate.DateBeforeCurrent;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(generator = "id_gen_customer")
    @GenericGenerator(name = "id_gen_customer", parameters = @Parameter(name = "prefix", value = "KH-"), strategy = "vn.codegym.furamaresort.utils.IdGenerator")
    private String customerId;

    @JoinColumn(name = "customerTypeId")
    @ManyToOne
    private CustomerType customerType;

    @Column(nullable = false, length = 45)
    @NotBlank(message = "Name is required")
    private String customerName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @DateBeforeCurrent
    private LocalDate customerBirthday;

    private boolean customerGender;

    @Column(length = 45)
    @NotBlank(message = "ID Card id required")
    @Pattern(regexp = "(\\d{3} ){2,3}\\d{3}", message = "ID Card must match format xxx xxx xxx xxx or xxx xxx xxx")
    private String customerIdCard;

    @Column(length = 45)
    @NotBlank(message = "Phone is required")
    @Pattern(regexp = "^(090|091) \\d{3} \\d{4}$", message = "Phone must have format 090 xxx xxxx or 091 xxx xxxx")
    private String customerPhone;

    @Column(length = 45)
    @NotBlank(message = "Email is required")
    @Email
    private String customerEmail;

    @Column(length = 45)
    @NotBlank(message = "Address is required")
    private String customerAddress;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<Contract> listContracts;
}
package vn.codegym.furamaresort.model.employee;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.format.annotation.DateTimeFormat;
import vn.codegym.furamaresort.model.contract.Contract;
import vn.codegym.furamaresort.model.user.User;
import vn.codegym.furamaresort.validate.DateBeforeCurrent;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Column(nullable = false, length = 45)
    @Id
    @GeneratedValue(generator = "id_gen_employee")
    @GenericGenerator(name = "id_gen_employee", parameters = @Parameter(name = "prefix", value = "NV-"), strategy = "vn.codegym.furamaresort.utils.IdGenerator")
    private String employeeId;

    @Column(length = 45)
    @NotBlank(message = "Name id required")
    private String employeeName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @DateBeforeCurrent
    private LocalDate employeeBirthday;

    @Column(length = 45)
    @NotBlank(message = "ID Card id required")
    @Pattern(regexp = "(\\d{3} ){2,3}\\d{3}", message = "ID Card must match format xxx xxx xxx xxx or xxx xxx xxx")
    private String employeeIdCard;

    @Min(value = 1, message = "Salary must be bigger than 0")
    private double employeeSalary;

    @Column(length = 45)
    @NotBlank(message = "Phone id required")
    @Pattern(regexp = "^(090|091) \\d{3} \\d{4}$", message = "Phone must have format 090 xxx xxxx or 091 xxx xxxx")
    private String employeePhone;

    @Column(length = 45)
    @NotBlank(message = "Email id required")
    @Email(message = "Input not match an email format")
    private String employeeEmail;

    @Column(length = 45)
    @NotBlank(message = "Address id required")
    private String employeeAddress;

    @JoinColumn(name = "positionId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Position position;

    @JoinColumn(name = "educationDegreeId")
    @ManyToOne(fetch = FetchType.LAZY)
    private EducationDegree educationDegree;

    @JoinColumn(name = "divisionId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Division division;

    @JoinColumn(name = "username")
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @NotNull
    @Valid
    private User user;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<Contract> listContracts;
}
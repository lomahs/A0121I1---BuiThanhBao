package vn.codegym.furamaresort.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.furamaresort.model.employee.Division;
import vn.codegym.furamaresort.model.employee.EducationDegree;
import vn.codegym.furamaresort.model.employee.Employee;
import vn.codegym.furamaresort.model.employee.Position;
import vn.codegym.furamaresort.model.user.Role;
import vn.codegym.furamaresort.service.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IUserService userService;

    @Autowired
    private IDivisionService divisionService;

    @Autowired
    private IEducationDegreeService educationDegreeService;

    @Autowired
    private IPositionService positionService;

    @Autowired
    private IRoleService roleService;

    @ModelAttribute("listPositions")
    public List<Position> listPosition() {
        return positionService.listAllPositions();
    }

    @ModelAttribute("listEducationDegrees")
    public List<EducationDegree> listEducationDegree() {
        return educationDegreeService.listAllEducationDegrees();
    }

    @ModelAttribute("listDivisions")
    public List<Division> listDivision() {
        return divisionService.listAllDivisions();
    }

    @GetMapping
    public String showAllEmployee(Model model, @PageableDefault(size = 5) Pageable pageable) {
        model.addAttribute("listEmployees", employeeService.listAllEmployees(pageable));

        return "employee/employee-list";
    }

    @GetMapping("/search")
    private String showEmployeeByName(
            Model model,
            @PageableDefault(size = 5) Pageable pageable,
            @RequestParam(value = "searchValue") Optional<String> searchValue) {
        if (searchValue.isPresent()) {
            model.addAttribute("listEmployees", employeeService.listAllEmployeeByEmployeeName(searchValue.get(), pageable));
        } else {
            model.addAttribute("listEmployees", employeeService.listAllEmployees(pageable));
        }
        return "employee/employee-list-table";
    }

    @GetMapping("/add")
    private String showAddForm(Model model) {
        model.addAttribute("employee", new Employee());

        return "employee/employee-add";
    }

    @PostMapping("/add")
    public String addEmployee(@Valid @ModelAttribute Employee employee, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "employee/employee-add";
        }

        Set<Role> roles = new HashSet<>();
        if (employee.getPosition().getPositionName().equals("Manager")
                || employee.getPosition().getPositionName().equals("Director")) {
            roles.add(roleService.getRoleByRoleName("ROLE_ADMIN"));
        } else {
            roles.add(roleService.getRoleByRoleName("ROLE_USER"));
        }

        employee.getUser().setRole(roles);

        employeeService.saveEmployee(employee);

        redirectAttributes.addFlashAttribute("message", "Add successful");

        return "redirect:/employee";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Employee employee, Model model) {

        model.addAttribute("employee", employee);

        return "employee/employee-edit";
    }

    @PostMapping("/edit")
    public String editEmployee(@Valid @ModelAttribute Employee employee, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {

            return "employee/employee-edit";
        }


        Set<Role> roles = new HashSet<>();
        if (employee.getPosition().getPositionName().equals("Manager")
                || employee.getPosition().getPositionName().equals("Director")) {
            roles.add(new Role("ROLE_ADMIN"));
        } else {
            roles.add(new Role("ROLE_USER"));
        }

        employee.getUser().setRole(roles);

        employeeService.saveEmployee(employee);

        redirectAttributes.addFlashAttribute("message", "Edit successful");

        return "redirect:/employee";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") String id, RedirectAttributes redirectAttributes) {
        employeeService.deleteEmployeeById(id);

        redirectAttributes.addFlashAttribute("message", "Delete successful");

        return "redirect:/employee";
    }
}
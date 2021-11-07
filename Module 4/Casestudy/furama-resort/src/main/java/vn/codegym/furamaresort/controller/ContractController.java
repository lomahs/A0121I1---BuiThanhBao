package vn.codegym.furamaresort.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.furamaresort.model.contract.Contract;
import vn.codegym.furamaresort.model.contract.ContractDetail;
import vn.codegym.furamaresort.model.customer.Customer;
import vn.codegym.furamaresort.model.employee.Employee;
import vn.codegym.furamaresort.model.service.AttachService;
import vn.codegym.furamaresort.model.service.Service;
import vn.codegym.furamaresort.service.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService contractService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IServiceService serviceService;

    @Autowired
    private IAttachServiceService attachServiceService;

    @Autowired
    private IContractDetailService contractDetailService;

    @ModelAttribute("listCustomers")
    private List<Customer> listCustomers() {
        return customerService.listAllCustomers(Pageable.unpaged()).toList();
    }

    @ModelAttribute("listEmployees")
    private List<Employee> listEmployees() {
        return employeeService.listAllEmployees(Pageable.unpaged()).toList();
    }

    @ModelAttribute("listServices")
    private List<Service> listServices() {
        return serviceService.listAllServices(Pageable.unpaged()).toList();
    }

    @GetMapping("/add")
    private String showAddForm(Model model) {
        if (listCustomers().isEmpty() || listEmployees().isEmpty() || listServices().isEmpty()) {
            return "error";
        }

        model.addAttribute("contract", new Contract());

        return "contract/contract-add";
    }

    @PostMapping("/add")
    private String saveContract(@Valid @ModelAttribute Contract contract, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (contract.getContractStartDate().isAfter(contract.getContractEndDate())) {
            bindingResult.rejectValue("contractEndDate", "endDate.before.startDate");
        }

        if (bindingResult.hasErrors()) {

            return "contract/contract-add";
        }
        contractService.saveContract(contract);

        redirectAttributes.addFlashAttribute("message", "Add Successful");

        return "redirect:/contract/add";
    }

    @GetMapping("/contractdetail/add")
    private String showAddContractDetailForm(Model model) {
        List<Contract> listContracts = contractService.getAllContracts();

        List<AttachService> listAttachServices = attachServiceService.getAllAttachServices();

        model.addAttribute("listContracts", listContracts);
        model.addAttribute("listAttachServices", listAttachServices);
        model.addAttribute("contractDetail", new ContractDetail());

        return "contract/contractdetail-add";
    }

    @PostMapping("/contractdetail/add")
    private String saveContractDetail(@ModelAttribute ContractDetail contractDetail, RedirectAttributes redirectAttributes) {

        contractDetailService.saveContractDetail(contractDetail);
        Contract contract = contractService.getContractById(contractDetail.getContract().getContractId()).orElse(null);
        contract.setContractTotalMoney(contractDetail.getAttachService().getAttachServiceCost()
                * contractDetail.getAttachService().getAttachServiceUnit()
                + contract.getService().getServiceCost());
        contractService.saveContract(contract);

        redirectAttributes.addFlashAttribute("message", "Add Successful");

        return "redirect:/contract/contractdetail/add";
    }
}
package vn.codegym.furamaresort.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.furamaresort.model.service.RentType;
import vn.codegym.furamaresort.model.service.Service;
import vn.codegym.furamaresort.model.service.ServiceType;
import vn.codegym.furamaresort.service.IRentTypeService;
import vn.codegym.furamaresort.service.IServiceService;
import vn.codegym.furamaresort.service.IServiceTypeService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    private IServiceService serviceService;

    @Autowired
    private IServiceTypeService serviceTypeService;

    @Autowired
    private IRentTypeService rentTypeService;

    @ModelAttribute("listRentTypes")
    public List<RentType> listRentTypes() {
        return rentTypeService.listAllRentTypes();
    }

    @ModelAttribute("listServiceType")
    public List<ServiceType> listServiceTypes() {
        return serviceTypeService.listAllServiceTypes();
    }


    @GetMapping
    public String showAllService(Model model, @PageableDefault(size = 5) Pageable pageable) {
        model.addAttribute("listServices", serviceService.listAllServices(pageable));

        return "service/service-list";
    }

    @GetMapping("/add")
    private String showAddForm(Model model) {
        model.addAttribute("service", new Service());

        return "service/service-add";
    }

    @PostMapping("/add")
    public String addService(@Valid @ModelAttribute Service service, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {

            return "service/service-add";
        }

        serviceService.saveService(service);

        redirectAttributes.addFlashAttribute("message", "Add successful");

        return "redirect:/service";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Service service, Model model) {

        model.addAttribute("service", service);

        return "service/service-edit";
    }

    @PostMapping("/edit")
    public String editService(@Valid @ModelAttribute Service service, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {

            return "service/service-edit";
        }

        serviceService.saveService(service);

        redirectAttributes.addFlashAttribute("message", "Edit successful");

        return "redirect:/service";
    }

    @GetMapping("/delete/{id}")
    public String deleteService(@PathVariable("id") String id, RedirectAttributes redirectAttributes) {
        serviceService.deleteServiceById(id);

        redirectAttributes.addFlashAttribute("message", "Delete successful");

        return "redirect:/service";
    }
}
package vn.codegym.practical.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.codegym.practical.model.Question;
import vn.codegym.practical.model.QuestionType;
import vn.codegym.practical.service.IQuestionTypeService;

import java.util.List;

@Controller
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private IQuestionTypeService questionTypeService;

    @ModelAttribute("listQuestionTypes")
    private List<QuestionType> listQuestionTypes() {
        return questionTypeService.getAllQuestionTypes(Pageable.unpaged()).toList();
    }

    @GetMapping("/add")
    private String showAddForm(Model model) {
        if (listQuestionTypes().isEmpty()) {
            return "error";
        }

        model.addAttribute("question", new Question());

        return "question/question-add";
    }

//    @PostMapping("/add")
//    private String saveContract(@Valid @ModelAttribute Contract contract, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
//        if (contract.getContractStartDate().isAfter(contract.getContractEndDate())) {
//            bindingResult.rejectValue("contractEndDate", "endDate.before.startDate");
//        }
//
//        if (bindingResult.hasErrors()) {
//
//            return "contract/contract-add";
//        }
//        contractService.saveContract(contract);
//
//        redirectAttributes.addFlashAttribute("message", "Add Successful");
//
//        return "redirect:/contract/add";
//    }
//
//    @GetMapping("/contractdetail/add")
//    private String showAddContractDetailForm(Model model) {
//        List<Contract> listContracts = contractService.getAllContracts();
//
//        List<AttachService> listAttachServices = attachServiceService.getAllAttachServices();
//
//        model.addAttribute("listContracts", listContracts);
//        model.addAttribute("listAttachServices", listAttachServices);
//        model.addAttribute("contractDetail", new ContractDetail());
//
//        return "contract/contractdetail-add";
//    }
//
//    @PostMapping("/contractdetail/add")
//    private String saveContractDetail(@ModelAttribute ContractDetail contractDetail, RedirectAttributes redirectAttributes) {
//
//        contractDetailService.saveContractDetail(contractDetail);
//        Contract contract = contractService.getContractById(contractDetail.getContract().getContractId()).orElse(null);
//        contract.setContractTotalMoney(contractDetail.getAttachService().getAttachServiceCost()
//                * contractDetail.getAttachService().getAttachServiceUnit()
//                + contract.getService().getServiceCost());
//        contractService.saveContract(contract);
//
//        redirectAttributes.addFlashAttribute("message", "Add Successful");
//
//        return "redirect:/contract/contractdetail/add";
//    }

}
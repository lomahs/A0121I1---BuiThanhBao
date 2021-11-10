package vn.codegym.qamanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.qamanagement.model.Question;
import vn.codegym.qamanagement.model.QuestionType;
import vn.codegym.qamanagement.service.IQuestionService;
import vn.codegym.qamanagement.service.IQuestionTypeService;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private IQuestionTypeService questionTypeService;

    @Autowired
    private IQuestionService questionService;

    @ModelAttribute("listQuestionTypes")
    private List<QuestionType> listQuestionTypes() {
        return questionTypeService.getAllQuestionTypes(Pageable.unpaged()).toList();
    }

    @GetMapping
    private String showListQuestion(Model model, Pageable pageable) {

        model.addAttribute("listQuestions", questionService.getAllQuestions(pageable));

        return "question/question-list";
    }

    @GetMapping("/{id}")
    private String detailQuestion(@PathVariable("id") Question question, Model model) {
        model.addAttribute("question", question);

        return "question/question-detail";
    }

    @GetMapping("/search")
    private String search(@RequestParam("searchValue") String title, @RequestParam("searchTypeValue") int type, Model model) {

        if (title.isEmpty()) {

            if (type == 0) {
                model.addAttribute("listQuestions", questionService.getAllQuestions(Pageable.unpaged()));
            } else {
                model.addAttribute("listQuestions", questionService.getQuestionsByQuestionType(type));
            }
        } else {
            if (type == 0) {
                model.addAttribute("listQuestions", questionService.getQuestionsByTitle(title));
            } else {
                model.addAttribute("listQuestions", questionService.getQuestionByTitleAndType(title, type));
            }
        }


        return "question/question-search-table";
    }

    @GetMapping("/add")
    private String showAddForm(Model model) {
        if (listQuestionTypes().isEmpty()) {
            return "error";
        }

        model.addAttribute("question", new Question());

        return "question/question-add";
    }

    @PostMapping("/add")
    private String saveContract(@Valid @ModelAttribute Question question, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {

            return "question/question-add";
        }

        question.setDateCreated(LocalDate.now());
        question.setStatus(false);

        questionService.saveQuestion(question);

        redirectAttributes.addFlashAttribute("message", "Add Successful");

        return "redirect:/question";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Question question, Model model) {
        model.addAttribute("customer", question);

        return "question/question-edit";
    }

    @PostMapping("/edit")
    public String editCustomer(@Valid @ModelAttribute Question question, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "question/question-edit";
        }

        questionService.saveQuestion(question);

        redirectAttributes.addFlashAttribute("message", "Edit successful");

        return "redirect:/question";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        questionService.deleteQuestionById(id);

        redirectAttributes.addFlashAttribute("message", "Delete successful");

        return "redirect:/question";
    }


}
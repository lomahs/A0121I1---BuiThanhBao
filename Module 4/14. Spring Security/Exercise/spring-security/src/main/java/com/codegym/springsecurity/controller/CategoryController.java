package com.codegym.springsecurity.controller;


import com.codegym.springsecurity.model.Category;
import com.codegym.springsecurity.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("blogs/categories")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public String listCategory(Model model){
        List<Category> categories = categoryService.listCategory();

        model.addAttribute("categories", categories);

        return "category/list";
    }

    @GetMapping("/create")
    public String showCreateForm(@ModelAttribute Category category){

        return "category/create";
    }

    @PostMapping("/create")
    public String addCategory(@ModelAttribute Category category, RedirectAttributes redirectAttributes){

        categoryService.saveCategory(category);
        redirectAttributes.addFlashAttribute("message","Add successful");

        return "redirect:/blogs/categories/create";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Category category, Model model){
        model.addAttribute("category", category);

        return "category/edit";
    }

    @PostMapping("/edit")
    public String editCategory(Category category, Model model){
        categoryService.saveCategory(category);

        model.addAttribute("message", "Edit Successful");
        return "category/edit";
    }

    @GetMapping("/delete/{id}")
    public String showDeleteForm(@PathVariable("id") Category category, Model model){
        model.addAttribute("category", category);

        return "category/delete";
    }

    @PostMapping("/delete")
    public String deleteCategory(Category category, RedirectAttributes redirectAttributes){
        categoryService.removeCategory(category.getId());

        redirectAttributes.addFlashAttribute("message", "Delete Successful");

        return "redirect:/blogs/categories";
     }
}
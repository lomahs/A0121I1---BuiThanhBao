package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("blogs")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @ModelAttribute
    public List<Category> listCategories(){
        return categoryService.listCategory();
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("blog", new Blog());

        return "blog/create";
    }

    @PostMapping("/create")
    public String addBlog(Blog blog, RedirectAttributes redirectAttributes) {
        blogService.saveBlog(blog);

        redirectAttributes.addFlashAttribute("message", "Add successful");

        return "redirect:/blogs/create";
    }

    @GetMapping("")
    public String listBlog(Model model, @PageableDefault(size = 5) Pageable pageable, @RequestParam Optional<String> findValue) {
        Page<Blog> blogs;
        if (findValue.isPresent()) {
            blogs = blogService.findAllByTitleContaining(findValue.get(),pageable);
            model.addAttribute("findValue",findValue.get());
        } else {
            blogs = blogService.listBlog(pageable);
        }
        model.addAttribute("listBlog", blogs);

        return "blog/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(Model model, @PathVariable int id) {

        model.addAttribute("blog", blogService.findBlogById(id));

        return "blog/edit";
    }

    @PostMapping("/edit")
    public String editBlog(Model model, Blog blog) {

        blogService.saveBlog(blog);
        model.addAttribute("message", "Edit successful");

        return "blog/edit";
    }

    @GetMapping("/delete/{id}")
    public String showDeleteForm(Model model, @PathVariable int id) {

        model.addAttribute("blog", blogService.findBlogById(id));

        return "blog/delete";
    }

    @PostMapping("/delete")
    public String deleteBlog(RedirectAttributes redirectAttributes, Blog blog) {

        blogService.removeBlog(blog.getId());
        redirectAttributes.addFlashAttribute("message", "Delete successful");

        return "redirect:/blogs";
    }
}
package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("blogs")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("blog", new Blog());

        return "create";
    }

    @PostMapping("/create")
    public String addBlog(Blog blog, RedirectAttributes redirectAttributes) {
        blogService.saveBlog(blog);

        redirectAttributes.addFlashAttribute("message", "Add successful");

        return "redirect:/blogs/create";
    }

    @GetMapping("")
    public String listBlog(Model model){
        List<Blog> blogs = blogService.listBlog();

        model.addAttribute("listBlog", blogs);

        return "list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(Model model, @PathVariable int id){

        model.addAttribute("blog", blogService.findBlogById(id));

        return "edit";
    }

    @PostMapping ("/edit")
    public String editBlog(Model model, Blog blog){

        blogService.saveBlog(blog);
        model.addAttribute("message","Edit successful");

        return "edit";
    }

    @GetMapping("/delete/{id}")
    public String showDeleteForm(Model model, @PathVariable int id){

        model.addAttribute("blog", blogService.findBlogById(id));

        return "delete";
    }

    @PostMapping ("/delete")
    public String deleteBlog(RedirectAttributes redirectAttributes, Blog blog){

        blogService.removeBlog(blog.getId());
        redirectAttributes.addFlashAttribute("message","Delete successful");

        return "redirect:/blogs/";
    }
}
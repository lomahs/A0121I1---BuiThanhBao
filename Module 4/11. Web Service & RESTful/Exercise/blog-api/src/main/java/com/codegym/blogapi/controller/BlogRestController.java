package com.codegym.blogapi.controller;

import com.codegym.blogapi.model.Blog;
import com.codegym.blogapi.model.Category;
import com.codegym.blogapi.service.IBlogService;
import com.codegym.blogapi.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BlogRestController {

    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @DeleteMapping("category/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") int id){
        categoryService.removeCategory(id);

        return new ResponseEntity<>("Delete successful", HttpStatus.OK);
    }

    @GetMapping("category/{id}")
    public ResponseEntity<Category> showCategory(@PathVariable("id") int id){
        Category category =  categoryService.findCategoryById(id);

        if (category == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> listCategories(){
        List<Category> categoryList = categoryService.listCategory();

        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @GetMapping("/category/blog/{id}")
    public ResponseEntity<List<Blog>> getBlogByCategory(@PathVariable("id") int id){
        Category category = categoryService.findCategoryById(id);

        if (category == null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(category.getListBlog(),HttpStatus.OK);
    }

    @GetMapping("/category/blog")
    public ResponseEntity<HashMap<Category, List<Blog>>> getBlogOfCategory(){
        List<Category> category = categoryService.listCategory();

        HashMap<Category, List<Blog>> blogs = new HashMap<>();

        for (Category cat : category) {
            blogs.put(cat,cat.getListBlog());
        }

        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Void> addBlog(@RequestBody Blog blog) {
        blogService.saveBlog(blog);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<Blog>> listBlog() {

        List<Blog> blogs = blogService.listBlog();

        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }

    @GetMapping("/blogs/{id}")
    public ResponseEntity<Blog> findBlog(@PathVariable int id) {

        Blog blog = blogService.findBlogById(id);

        if (blog == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(blog,HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Blog> showEditForm(@PathVariable int id, @RequestBody Blog blog) {

       Blog b =  blogService.findBlogById(id);

       if (b == null){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }

       b.setTitle(blog.getTitle());
       b.setCategory(blog.getCategory());
       b.setDayCreated(blog.getDayCreated());
       b.setUploader(blog.getUploader());
       b.setContent(blog.getContent());

       blogService.saveBlog(b);

        return new ResponseEntity<>(blog,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> showDeleteForm(@PathVariable int id) {

        if (blogService.findBlogById(id) == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        };

        blogService.removeBlog(id);

        return new ResponseEntity<>("Delete successful", HttpStatus.OK);
    }
}
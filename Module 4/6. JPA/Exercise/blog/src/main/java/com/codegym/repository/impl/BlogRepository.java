package com.codegym.repository.impl;

import com.codegym.model.Blog;
import com.codegym.repository.IBlogRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class BlogRepository implements IBlogRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Blog findBlogById(int id) {
        TypedQuery<Blog> findBlog = em.createQuery("select c from Blog c where c.id = :id", Blog.class);
        try {
            return findBlog.setParameter("id", id).getSingleResult();
        } catch (NoResultException exception) {
            return null;
        }
    }

    @Override
    public List<Blog> listBlog() {
        TypedQuery<Blog> findBlog = em.createQuery("select c from Blog c", Blog.class);
        return findBlog.getResultList();
    }

    @Override
    public void removeBlog(int id) {
        Blog blog = findBlogById(id);
        if (blog != null) {
            em.remove(blog);
        }
    }

    @Override
    public void saveBlog(Blog blog) {
        if (findBlogById(blog.getId()) != null) {
            em.merge(blog);
        } else {
            em.persist(blog);
        }
    }
}
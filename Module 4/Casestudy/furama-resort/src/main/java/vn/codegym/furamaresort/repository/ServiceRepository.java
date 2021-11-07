package vn.codegym.furamaresort.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.furamaresort.model.service.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, String> {
}
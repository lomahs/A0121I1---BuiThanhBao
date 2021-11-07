package vn.codegym.furamaresort.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.furamaresort.model.employee.Division;

@Repository
public interface DivisionRepository extends JpaRepository<Division, Integer> {
}
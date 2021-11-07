package vn.codegym.furamaresort.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.furamaresort.model.service.RentType;

@Repository
public interface RentTypeRepository extends JpaRepository<RentType, Integer> {
}
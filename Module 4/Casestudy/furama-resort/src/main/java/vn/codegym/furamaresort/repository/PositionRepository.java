package vn.codegym.furamaresort.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.furamaresort.model.employee.Position;

@Repository
public interface PositionRepository extends JpaRepository<Position, Integer> {
}
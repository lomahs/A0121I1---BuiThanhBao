package vn.codegym.practical.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.practical.model.QuestionType;

@Repository
public interface QuestionTypeRepository extends JpaRepository<QuestionType, Integer> {
}
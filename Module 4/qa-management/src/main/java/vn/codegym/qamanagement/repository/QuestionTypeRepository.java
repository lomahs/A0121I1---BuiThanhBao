package vn.codegym.qamanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.qamanagement.model.QuestionType;


@Repository
public interface QuestionTypeRepository extends JpaRepository<QuestionType, Integer> {
}
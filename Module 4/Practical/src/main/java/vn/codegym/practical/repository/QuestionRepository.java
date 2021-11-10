package vn.codegym.practical.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.practical.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
}
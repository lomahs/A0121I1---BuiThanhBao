package vn.codegym.qamanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.codegym.qamanagement.model.Question;

import java.util.List;


@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

    @Query(value = "select q from Question as q where q.questionTitle like %:title% and q.questionType.questionTypeId = :type")
    List<Question> getQuestionByTitleAndType(String title, int type);

    @Query(value = "select q from Question as q where q.questionType.questionTypeId = :type")
    List<Question> getQuestionsByQuestionType(int type);

    @Query(value = "select q from Question as q where q.questionTitle like %:tile%")
    List<Question> getQuestionsByQuestionTitle(String tile);
}
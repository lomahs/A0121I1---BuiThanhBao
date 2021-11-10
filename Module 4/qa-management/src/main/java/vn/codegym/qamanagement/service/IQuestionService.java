package vn.codegym.qamanagement.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.qamanagement.model.Question;

import java.util.List;
import java.util.Optional;

@Service
public interface IQuestionService {

    Page<Question> getAllQuestions(Pageable pageable);

    Question saveQuestion(Question question);

    boolean deleteQuestionById(int id);

    Optional<Question> getQuestionById(int id);

    List<Question> getQuestionByTitleAndType(String title, int type);

    List<Question> getQuestionsByQuestionType(int type);

    List<Question> getQuestionsByTitle(String title);
}
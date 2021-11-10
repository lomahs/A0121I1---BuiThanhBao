package vn.codegym.practical.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.practical.model.Question;

import java.util.Optional;

@Service
public interface IQuestionService {

    Page<Question> getAllQuestions(Pageable pageable);

    Question saveQuestion(Question question);

    boolean deleteQuestionById(int id);

    Optional<Question> getQuestionById(int id);
}
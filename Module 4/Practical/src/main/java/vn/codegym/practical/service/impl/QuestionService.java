package vn.codegym.practical.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.practical.model.Question;
import vn.codegym.practical.repository.QuestionRepository;
import vn.codegym.practical.service.IQuestionService;

import java.util.Optional;

@Service
public class QuestionService implements IQuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Page<Question> getAllQuestions(Pageable pageable) {
        return questionRepository.findAll(pageable);
    }

    @Override
    public Question saveQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public boolean deleteQuestionById(int id) {
        if (getQuestionById(id).isPresent()) {
            questionRepository.deleteById(id);

            return true;
        }

        return false;
    }

    @Override
    public Optional<Question> getQuestionById(int id) {
        return questionRepository.findById(id);
    }
}
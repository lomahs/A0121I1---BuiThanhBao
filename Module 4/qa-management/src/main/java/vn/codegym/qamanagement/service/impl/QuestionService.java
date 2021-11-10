package vn.codegym.qamanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.qamanagement.model.Question;
import vn.codegym.qamanagement.repository.QuestionRepository;
import vn.codegym.qamanagement.service.IQuestionService;

import java.util.List;
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

    @Override
    public List<Question> getQuestionByTitleAndType(String title, int type) {

        return questionRepository.getQuestionByTitleAndType(title, type);
    }

    @Override
    public List<Question> getQuestionsByQuestionType(int type) {
        return questionRepository.getQuestionsByQuestionType(type);
    }

    @Override
    public List<Question> getQuestionsByTitle(String title) {
        return questionRepository.getQuestionsByQuestionTitle(title);
    }
}
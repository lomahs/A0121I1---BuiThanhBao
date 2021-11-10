package vn.codegym.qamanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.qamanagement.model.QuestionType;
import vn.codegym.qamanagement.repository.QuestionTypeRepository;
import vn.codegym.qamanagement.service.IQuestionTypeService;

import java.util.Optional;

@Service
public class QuestionTypeService implements IQuestionTypeService {

    @Autowired
    private QuestionTypeRepository questionTypeRepository;

    @Override
    public Page<QuestionType> getAllQuestionTypes(Pageable pageable) {
        return questionTypeRepository.findAll(pageable);
    }

    @Override
    public QuestionType saveQuestionType(QuestionType questionType) {
        return questionTypeRepository.save(questionType);
    }

    @Override
    public boolean deleteQuestionTypeById(int id) {
        if (getQuestionTypeById(id).isPresent()) {
            questionTypeRepository.deleteById(id);

            return true;
        }

        return false;
    }

    @Override
    public Optional<QuestionType> getQuestionTypeById(int id) {
        return questionTypeRepository.findById(id);
    }
}
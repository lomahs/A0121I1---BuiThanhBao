package vn.codegym.qamanagement.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.qamanagement.model.QuestionType;

import java.util.Optional;

@Service
public interface IQuestionTypeService {

    Page<QuestionType> getAllQuestionTypes(Pageable pageable);

    QuestionType saveQuestionType(QuestionType questionType);

    boolean deleteQuestionTypeById(int id);

    Optional<QuestionType> getQuestionTypeById(int id);
}
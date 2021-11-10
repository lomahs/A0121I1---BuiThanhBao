package vn.codegym.qamanagement.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int questionTypeId;

    private String questionTypeName;

    @OneToMany(mappedBy = "questionType")
    @JsonBackReference
    private Set<Question> listQuestions = new HashSet<>();
}
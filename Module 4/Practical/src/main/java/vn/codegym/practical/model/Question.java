package vn.codegym.practical.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int questionId;

    private String questionTitle;

    private String questionContent;

    private String answer;

    @ManyToOne
    private QuestionType questionType;

    private LocalDate dateCreated;

    private boolean status;
}
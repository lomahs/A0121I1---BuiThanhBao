package vn.codegym.qamanagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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

    @NotBlank(message = "Title is required")
    @Size(min = 5, max = 100, message = "Title must have 5 to 100 characters")
    private String questionTitle;

    @NotBlank(message = "Content is required")
    @Size(min = 10, max = 500, message = "Content must have 10 to 500 characters")
    private String questionContent;
    
    private String answer;

    @ManyToOne
    private QuestionType questionType;

    private LocalDate dateCreated;

    private boolean status;
}
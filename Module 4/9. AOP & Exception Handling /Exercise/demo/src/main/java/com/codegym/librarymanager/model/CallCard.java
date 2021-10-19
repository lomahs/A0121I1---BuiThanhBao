package com.codegym.librarymanager.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Random;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CallCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int code;

    private String borrower;

    @OneToOne
    private Book borrowedBook;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate borrowDate = LocalDate.now();

    public void generateCode(){
        code = new Random().nextInt(99999 - 10000) + 10000;
    }

    public void setBook(Book book){
        borrowedBook = new Book(book.getId(), book.getName(), book.getAuthor(), book.getQuantity());
    }
}
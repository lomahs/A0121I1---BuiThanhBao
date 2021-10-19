package com.codegym.librarymanager.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "nvarchar(50)")
    private String name;

    private String author;

    @Column(nullable = false)
    private int quantity;

    public void borrow() throws Exception {
        if (!isAvailable()){
            throw new Exception("No left book");
        }

        quantity--;
    }

    public void giveBack(){
        quantity++;
    }

    public boolean isAvailable(){
        return quantity > 0;
    }
}
package com.codegym.librarymanager.controller;

import com.codegym.librarymanager.model.Book;
import com.codegym.librarymanager.model.CallCard;
import com.codegym.librarymanager.service.IBookService;
import com.codegym.librarymanager.service.ICallCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class BookController {

    private final IBookService bookService;

    private final ICallCardService callCardService;

    @Autowired
    public BookController(IBookService bookService, ICallCardService callCardService) {
        this.bookService = bookService;
        this.callCardService = callCardService;
    }

    @GetMapping
    public String showBooks( Pageable pageable, Model model){
        Page<Book> listBooks = bookService.listBooks(pageable);

        model.addAttribute("listBooks", listBooks);

        return "home";
    }

    @GetMapping("/borrow/{id}")
    public String borrowBookInfo(@PathVariable("id") int id, Model model){

        CallCard callCard = new CallCard();
        callCard.setBorrowedBook(bookService.getBookById(id));
        callCard.generateCode();

        model.addAttribute("callCard", callCard);

        return "borrow";
    }

    @PostMapping("/borrow")
    public String borrowBook(CallCard callCard) throws Exception {
        callCardService.saveCallCard(callCard);

        bookService.borrow(callCard.getBorrowedBook());

        return "redirect:/";
    }

    @GetMapping("/giveback")
    public String giveBackForm(@RequestParam("code") int code, Model model, Pageable pageable){

        CallCard callCard = callCardService.getCallCardByCode(code);

        if (callCard == null){
            model.addAttribute("listBooks", bookService.listBooks(pageable));
            model.addAttribute("message", "Code is not exist");
            return "home";
        }

        model.addAttribute("callCard", callCard);

        return "giveback";
    }

    @PostMapping("/giveback")
    public String giveBackBook(CallCard callCard) throws Exception {
        callCardService.removeCallCard(callCard.getId());

        bookService.giveBack(callCard.getBorrowedBook());

        return "redirect:/";
    }


}
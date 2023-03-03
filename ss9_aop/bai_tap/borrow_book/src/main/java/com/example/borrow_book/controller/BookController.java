package com.example.borrow_book.controller;

import com.example.borrow_book.model.Book;
import com.example.borrow_book.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    IBookService bookService;

    @GetMapping("/list")
    public String showList(Model model, @RequestParam Optional<Integer> page) {
        int pageBegin = 0;
        if (page.isPresent()) {
            pageBegin = page.get();
        }
        Pageable pageable = PageRequest.of(pageBegin, 4, Sort.by("name").descending());
        Page<Book> bookPage = bookService.findAll(pageable);
        model.addAttribute("bookPage", bookPage);
        return "/list";
    }

    @GetMapping("/detail")
    public ModelAndView getInformation(@RequestParam int bookId) {
        return new ModelAndView("info", "book", bookService.findById(bookId));
    }

    @PostMapping("/rent")
    public String rentBook(@ModelAttribute Book book, RedirectAttributes attributes) {
        Book bookRent = bookService.findById(book.getId());
        System.out.printf("Đã vào");
        if (bookRent.getQuantity() > 0) {

            bookRent.setQuantity(bookRent.getQuantity() - 1);
            bookService.save(bookRent);
            return "redirect:/book/list";
        } else {
            return "error";
        }
    }

    @PostMapping("/return")
    public String returnBook(Optional<Integer> bookId, RedirectAttributes attributes) throws Exception {
        Book book = bookService.findById(bookId.get());
        if (book == null) {
            throw new Exception();
        }
        book.setQuantity(book.getQuantity() + 1);
        bookService.save(book);
        return "redirect:/book/list";
    }

    @ExceptionHandler(value = Exception.class)
    public String goErrorPage() {
        return "error";
    }
}

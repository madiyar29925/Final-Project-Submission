package kz.reself.springdata.controller;

import kz.reself.springdata.entity.Book;
import kz.reself.springdata.entity.Page;
import kz.reself.springdata.service.BookService;
import kz.reself.springdata.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private PageService pageService;

    public List<Book> getAllBooks() {
        return bookService.getAll();
    }

    public List<Page> getAllPages() {
        return pageService.getAll();
    }
}

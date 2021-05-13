package kz.reself.springdata.service.impl;

import kz.reself.springdata.entity.Book;
import kz.reself.springdata.repository.BookRepository;
import kz.reself.springdata.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }
}

package kz.reself.springdata.service;

import kz.reself.springdata.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> getAll();
}

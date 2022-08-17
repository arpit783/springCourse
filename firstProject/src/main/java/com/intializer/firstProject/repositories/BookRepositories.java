package com.intializer.firstProject.repositories;

import com.intializer.firstProject.domain.Book;

import org.springframework.data.repository.CrudRepository;

public interface BookRepositories extends CrudRepository<Book, Long> {

}

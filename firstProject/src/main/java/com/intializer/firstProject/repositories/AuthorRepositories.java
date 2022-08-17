package com.intializer.firstProject.repositories;

import com.intializer.firstProject.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepositories extends CrudRepository<Author, Long> {

}

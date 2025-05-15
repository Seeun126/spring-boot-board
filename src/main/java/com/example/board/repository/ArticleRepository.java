package com.example.board.repository;

import com.example.board.entity.Article;
import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {

  @Override
  ArrayList<Article> findAll();//Iterable -> ArrayList
}

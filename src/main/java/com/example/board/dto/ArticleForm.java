package com.example.board.dto;

import com.example.board.entity.Article;

public class ArticleForm {

  private String title;
  private String content;

  // 생성자
  public ArticleForm(String title, String content) {
    this.title = title;
    this.content = content;
  }

  // 엔티티로 변환
  public Article toEntity() {
    return new Article(null, title, content);
  }

  @Override
  public String toString() {
    return "ArticleForm{" +
        "title='" + title + '\'' +
        ", content='" + content + '\'' +
        '}';
  }
}

package com.example.board.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Article {
  @Id
  @GeneratedValue //대표값(ID) 자동생성.
  private Long id;
  @Column //DB테이블의 title열과 연결.
  private String title;
  @Column //DB테이블의 content열과 연결.
  private String content;

  public Article(Long id, String title, String content) {
    this.id = id;
    this.title = title;
    this.content = content;
  }

  public Article() {}

  @Override
  public String toString() {
    return "Article{" +
        "id=" + id +
        ", title='" + title + '\'' +
        ", content='" + content + '\'' +
        '}';
  }
}

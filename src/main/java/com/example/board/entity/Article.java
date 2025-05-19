package com.example.board.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Article {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) //대표값(ID) 자동생성.
  private Long id;
  @Column //DB테이블의 title열과 연결.
  private String title;
  @Column //DB테이블의 content열과 연결.
  private String content;


  public void patch(Article article) {
      if (article.title != null)
        this.title = article.title;
      if (article.content != null)
        this.content = article.content;
  }
}

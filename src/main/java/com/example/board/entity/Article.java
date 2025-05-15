package com.example.board.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
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
  @GeneratedValue //대표값(ID) 자동생성.
  private Long id;
  @Column //DB테이블의 title열과 연결.
  private String title;
  @Column //DB테이블의 content열과 연결.
  private String content;


}

package com.example.board.dto;

import com.example.board.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ArticleForm {
  private Long id;
  private String title;
  private String content;

  // 엔티티로 변환
  public Article toEntity() {
    return new Article(id, title, content);
  }


}

package com.example.board.service;

import com.example.board.dto.ArticleForm;
import com.example.board.entity.Article;
import com.example.board.repository.ArticleRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> index() {
        return articleRepository.findAll();
    }

    public Article show(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

  public Article create(ArticleForm dto) {
      Article article = dto.toEntity();
      if (article.getId() != null) {
        return null;
      }
      return articleRepository.save(article);
  }

  public Article update(Long id, ArticleForm dto) {
    // 1. DTO->Entity
    Article article = dto.toEntity();
    log.info("id: {}, article: {}", id, article.toString());
    // 2. DB에 대상 엔티티가 있는지 조회.
    Article target = articleRepository.findById(id).orElse(null);
    // 3. 대상 엔티티가 없거나 수정하려는 id가 잘못됐을 경우 처리.
    if (target == null || id != article.getId()) {
      // 400, 잘못된 요청 응답!
      log.info("잘못된 요청! id: {}, article:{}", id, article.toString());
      return null;
    }
    // 4. 대상 엔티티가 있으면 수정 내용으로 업데이트하고 200 보내기.
    target.patch(article); //target=target+article가 됨.
    Article updated = articleRepository.save(target);
    return updated;
  }

  public Article delete(Long id) {
    //1. 대상 찾기
    Article target = articleRepository.findById(id).orElse(null);
    //2. 잘못된 요청 처리하기
    if (target == null) {
      return null;
    }
    //3. 대상 삭제하기
    articleRepository.delete(target);
    return target;
  }
}

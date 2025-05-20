package com.example.board.repository;

import com.example.board.entity.Comment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    // 특정 게시글이 모든 댓글 조회
  @Query (value = "SELECT * FROM comment WHERE article_id =:articleId",
      nativeQuery = true)
    List<Comment> findByArticleId(Long articleId);
    // 특정 닉네임의 모든 댓글 조회
    List<Comment> findByNickname(String nickname);
}

package org.project.backend.service;

import org.project.backend.model.Comment;
import org.project.backend.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service

public class CommentService {
    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    // 댓글 생성 (Create)
    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    // 모든 댓글 조회 (Read)
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    // ID로 댓글 조회 (Read)
    public Optional<Comment> getCommentById(Long id) {
        return commentRepository.findById(id);
    }

    public class CommentNotFoundException extends RuntimeException {
        public CommentNotFoundException(String message) {
            super(message);
        }
    }
    // 댓글 수정 (Update)
    public Comment updateComment(Long id, Comment updatedComment) {
        return commentRepository.findById(id).map(comment -> {
            comment.setText(updatedComment.getText()); // 수정된 텍스트 설정
            comment.setAuthor(updatedComment.getAuthor()); // 수정된 작성자 설정
            return commentRepository.save(comment); // 저장 후 반환
        }).orElseThrow(() -> new CommentNotFoundException("Comment not found with id " + id));
    }

    // 댓글 삭제 (Delete)
    public void deleteComment(Long id) {
        if (commentRepository.findById(id).isPresent()) {
            commentRepository.deleteById(id);
        } else {
            throw new CommentNotFoundException("Comment not found with id " + id);
        }
    }

}

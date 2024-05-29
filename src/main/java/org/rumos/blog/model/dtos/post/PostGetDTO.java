package org.rumos.blog.model.dtos.post;

public record PostGetDTO(Long id, String title, String text, String category, String authorUserName) {
  
}

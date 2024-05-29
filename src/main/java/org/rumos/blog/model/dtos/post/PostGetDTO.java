package org.rumos.blog.model.dtos.post;

public class PostGetDTO {

    private Long id;
    private String title;
    private String text;
    private String category;
    private String authorUserName;


    public PostGetDTO() {
    }

    public PostGetDTO(Long id, String title, String text, String category, String authorUserName) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.category = category;
        this.authorUserName = authorUserName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    public String getAuthorUserName() {
        return authorUserName;
    }

    public void setAuthorUserName(String authorUserName) {
        this.authorUserName = authorUserName;
    }


    

    
}

package com.authorRecognition.zemberek;

import java.util.Objects;

public class Article {

    private int id;
    private String author;
    private String content;
    private ArticleType type;

    public Article() {
    }

    public Article(String author, String content) {
        this.author = author;
        this.content = content;
    }

    public Article(String author, String content, ArticleType type) {
        this.author = author;
        this.content = content;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public ArticleType getType() {
        return type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setType(ArticleType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Author is " + this.author + "\n" + "Content is " + this.getContent() + "\n" + "Type is " + this.getType();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.id;
        hash = 61 * hash + Objects.hashCode(this.author);
        hash = 61 * hash + Objects.hashCode(this.content);
        hash = 61 * hash + Objects.hashCode(this.type);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Article other = (Article) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.author, other.author)) {
            return false;
        }
        if (!Objects.equals(this.content, other.content)) {
            return false;
        }
        if (this.type != other.type) {
            return false;
        }
        return true;
    }
    
}

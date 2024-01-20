package com.weslleycabral.workshopmongodb.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class CommentDTO implements Serializable {

    private static final Long serialVersionUID = 1L;

    private String text;
    private Date date;
    private AuthorDTO authorDTO;

    public CommentDTO() {}

    public CommentDTO(String text, Date date, AuthorDTO authorDTO) {
        this.text = text;
        this.date = date;
        this.authorDTO = authorDTO;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public AuthorDTO getAuthorDTO() {
        return authorDTO;
    }

    public void setAuthorDTO(AuthorDTO authorDTO) {
        this.authorDTO = authorDTO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentDTO that = (CommentDTO) o;
        return Objects.equals(authorDTO, that.authorDTO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorDTO);
    }
}

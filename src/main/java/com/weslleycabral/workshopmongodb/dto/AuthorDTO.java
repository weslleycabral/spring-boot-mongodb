package com.weslleycabral.workshopmongodb.dto;

import com.weslleycabral.workshopmongodb.entities.User;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Objects;


public class AuthorDTO implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    private String id;
    private String name;

    public AuthorDTO() {}

    public AuthorDTO(User user) {
        this.id = user.getId();
        this.name =user.getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorDTO authorDTO = (AuthorDTO) o;
        return Objects.equals(id, authorDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

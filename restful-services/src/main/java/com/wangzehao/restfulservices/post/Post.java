package com.wangzehao.restfulservices.post;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wangzehao.restfulservices.user.User;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@JsonIgnoreProperties(value = {"user"})
@Entity
public class Post {

    @Id
    @GeneratedValue
    private Integer id;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }

}

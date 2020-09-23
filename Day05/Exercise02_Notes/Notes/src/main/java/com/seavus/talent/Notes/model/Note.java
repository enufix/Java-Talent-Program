package com.seavus.talent.Notes.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Note {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String content;


    @ManyToMany
    private List<Tag> tags;

    @ManyToOne
    private User user;


    public Note() {

    }

    public Note(String title, String content, User user) {

        this.title = title;
        this.content = content;
        this.user = user;

    }


    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }


}

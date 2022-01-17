package com.enocklubowa.springcommonexceptions.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DemoEntity {

    @Id
    private Long id;

    private String username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
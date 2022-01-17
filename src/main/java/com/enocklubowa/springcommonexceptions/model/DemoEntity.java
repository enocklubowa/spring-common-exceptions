package com.enocklubowa.springcommonexceptions.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

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

    @Override
    public String toString() {
        return "DemoEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DemoEntity entity = (DemoEntity) o;
        return id.equals(entity.id) && username.equals(entity.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username);
    }
}

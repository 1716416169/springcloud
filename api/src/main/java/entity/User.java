package entity;

import lombok.Data;

import java.util.List;

/*
CREATE TABLE user
(
    id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    username char,
    password char,
    role char
);

*/
@Data
public class User {
    private int id;
    private String username;
    private String password;
    private List<Role> role;

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<Role> getRole() {
        return role;
    }
}

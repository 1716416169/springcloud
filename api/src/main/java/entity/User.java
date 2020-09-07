package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
/*@AllArgsConstructor
@NoArgsConstructor*/
@ToString
public class User {
    private int id;
    private String username;
    private String password;
    private List<Role> role;

    public User(int id, String username, String password, List<Role> role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User() {
    }

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

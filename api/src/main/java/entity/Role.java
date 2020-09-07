package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*
create table role
(
  id        int auto_increment
    primary key,
  role      char null,
  role_user int  null,
  constraint role_user
  foreign key (role_user) references user (id)
);
*/
@Data
/*@NoArgsConstructor
@AllArgsConstructor*/
@ToString
public class Role {
    private int id;
    private String role;
    private int role_user;
    private User user;

    public Role() {
        this.role_user = role_user;
    }

    public Role(int id, String role, int role_user, User user) {
        this.id = id;
        this.role = role;
        this.role_user = role_user;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public int getRole_user() {
        return role_user;
    }

    public User getUser() {
        return user;
    }
}

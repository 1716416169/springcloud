package entity;

import lombok.Data;

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
public class Role {
    private int id;
    private String role;
    private int role_user;
    private User user;

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

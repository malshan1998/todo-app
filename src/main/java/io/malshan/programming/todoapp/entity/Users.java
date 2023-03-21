package io.malshan.programming.todoapp.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String username;
    private String password;
    @OneToMany(cascade = CascadeType.REMOVE)        // NOTE: This makes sure that if user is deleted, the related
                                                    // todos are also deleted
    private List<Todo> todoList = new ArrayList<Todo>();

    public Users(int id, String username, String password, List<Todo> todoList) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.todoList = todoList;
    }

    public Users() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Todo> getTodoList() {
        return todoList;
    }

    public void setTodoList(List<Todo> todoList) {
        this.todoList = todoList;
    }
}

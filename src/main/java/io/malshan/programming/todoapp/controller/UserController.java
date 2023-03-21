package io.malshan.programming.todoapp.controller;

import io.malshan.programming.todoapp.entity.Todo;
import io.malshan.programming.todoapp.entity.Users;
import io.malshan.programming.todoapp.repository.TodoRepository;
import io.malshan.programming.todoapp.repository.UserRepository;
import io.malshan.programming.todoapp.request.AddTodoRequest;
import io.malshan.programming.todoapp.request.AddUserRequest;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/users")
public class UserController {       // TODO: Understand this. This is the API defining class.
    private final UserRepository userRepository;
    private final TodoRepository todoRepository;

    public UserController(UserRepository userRepository, TodoRepository todoRepository) {
        this.userRepository = userRepository;
        this.todoRepository = todoRepository;
    }

    @GetMapping("/{userId}")
    public Users getUserById(@PathVariable Integer userId) {

        // TODO: Understand why this doesn't work without @PathVariable part

        return userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
    }

    @PostMapping
    public void addUser(@RequestBody AddUserRequest userRequest){
        Users user = new Users();
        user.setUsername(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        userRepository.save(user);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Integer userId) {
        Users user = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
        userRepository.delete(user);
    }

    @PostMapping("/{userId}/todos")
    public void addTodo(@PathVariable Integer userId, @RequestBody AddTodoRequest todoRequest) {
        Users user = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
        Todo todo = new Todo();
        todo.setContent(todoRequest.getContent());
        todo.setCompleted(false);
        user.getTodoList().add(todo);
        todoRepository.save(todo);
        userRepository.save(user);
    }

    @PostMapping("/todos/{todoId}")
    public void toggleTodoCompleted(@PathVariable Integer todoId) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new NoSuchElementException());
        todo.setCompleted(!todo.getCompleted());
        todoRepository.save(todo);
    }

    @DeleteMapping("/{userId}/todos/{todoId}")
    public void deleteTodo(@PathVariable Integer userId, @PathVariable Integer todoId) {
        Users user = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new NoSuchElementException());
        user.getTodoList().remove(todo);
        todoRepository.delete(todo);
    }
}

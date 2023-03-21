package io.malshan.programming.todoapp;

import io.malshan.programming.todoapp.entity.Todo;
import io.malshan.programming.todoapp.entity.Users;
import io.malshan.programming.todoapp.repository.TodoRepository;
import io.malshan.programming.todoapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoAppApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;
	@Autowired
	TodoRepository todoRepository;
	public static void main(String[] args) {
		SpringApplication.run(TodoAppApplication.class, args);
	}

	@Override
	public void run(String... args) {
		Users user1 = new Users();
		user1.setUsername("John");
		user1.setPassword("Should be hashed");

		Todo todo = new Todo();
		todo.setContent("Upload video to YT");

		user1.getTodoList().add(todo);

		todoRepository.save(todo);
		userRepository.save(user1);
	}
}

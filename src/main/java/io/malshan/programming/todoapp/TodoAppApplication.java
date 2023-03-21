package io.malshan.programming.todoapp;

import io.malshan.programming.todoapp.entity.Todo;
import io.malshan.programming.todoapp.entity.Users;
import io.malshan.programming.todoapp.repository.TodoRepository;
import io.malshan.programming.todoapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//	Video of reference: https://www.youtube.com/watch?v=XKiYaHJhEPI&t=120s

	//	Access Swagger from: http://localhost:8080/swagger-ui/
	//	Access H2 console from: http://localhost:8080/h2_console
		//	Use the spring.datasource.url from application.properties as the JDBC URL

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
	public void run(String... args) throws Exception {
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

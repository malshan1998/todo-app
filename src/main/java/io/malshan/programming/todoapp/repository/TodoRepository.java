package io.malshan.programming.todoapp.repository;

import io.malshan.programming.todoapp.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Integer> {

}

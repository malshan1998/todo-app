package io.malshan.programming.todoapp.repository;

import io.malshan.programming.todoapp.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {

}

package cn.edu.nuaa.microservice.todobackend;

import org.springframework.data.repository.CrudRepository;
import cn.edu.nuaa.microservice.todobackend.Todo;

public interface TodoRepository extends CrudRepository<Todo, Integer> {

}
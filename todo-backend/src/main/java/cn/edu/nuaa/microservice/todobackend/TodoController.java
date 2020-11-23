package cn.edu.nuaa.microservice.todobackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping(path="/todo-backend")
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @PostMapping(path="/add")
    public Todo addTodo (@RequestParam Integer user_id, @RequestParam String content) {
        Todo t = new Todo();
        t.setUserId(user_id);
        t.setContent(content);
        t.setStatus(0);
        todoRepository.save(t);
        return t;
    }

    @GetMapping(path="/all")
    public Iterable<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

}
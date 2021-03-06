package cn.edu.nuaa.microservice.todobackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.beans.factory.annotation.Value;

@CrossOrigin
@RefreshScope
@RestController
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @Value("${message:Hello default}")
    private String message;

    @RequestMapping("/message")
    String getMessage() {
        return this.message;
    }

    @PostMapping(path="/add")
    public Todo addTodo (@RequestParam Integer user_id, @RequestParam String content) {
        Todo t = new Todo();
        t.setUserId(user_id);
        t.setContent(content);
        t.setStatus(0);
        todoRepository.save(t);
        return t;
    }

    @PutMapping(path="/tick")
    public Todo tickTodo (@RequestParam Integer id) {
        Todo t = todoRepository.findById(id).get();
        t.setStatus(1 - t.getStatus());
        todoRepository.save(t);
        return t;
    }

    @GetMapping(path="/all")
    public Iterable<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    @DeleteMapping(path="/delete")
    public Todo deleteTodo (@RequestParam Integer id) {
        Todo t = todoRepository.findById(id).get();
        todoRepository.delete(t);
        return t;
    }

}
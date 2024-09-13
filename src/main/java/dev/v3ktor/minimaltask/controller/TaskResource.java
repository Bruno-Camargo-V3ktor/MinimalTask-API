package dev.v3ktor.minimaltask.controller;

import dev.v3ktor.minimaltask.model.entity.Task;
import dev.v3ktor.minimaltask.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController @RequestMapping("/api/{USER_ID}/tasks")
public class TaskResource {

    //Atributos
    @Autowired private TaskService service;

    //Endpoints
    @PostMapping()
    public Task create( @PathVariable("USER_ID") String userId, @RequestBody Task task )
    {
        return service.createTaskByUserId( userId, task );
    }

    @GetMapping("/{ID}")
    public Task getById( @PathVariable("USER_ID") String userId, @PathVariable("ID") String id )
    {
        return service.getTaskById( id, userId );
    }

    @GetMapping()
    public ResponseEntity< List<Task> > getAll( @PathVariable("USER_ID") String userId )
    {
        return ResponseEntity.ok( service.getAllTasksByUserId(userId) );
    }

    @PutMapping("/{ID}")
    public ResponseEntity< Void > updateById( @PathVariable("USER_ID") String userId, @PathVariable("ID") String id, @RequestBody Task task )
    {
        service.updateTaskById( id, userId, task );
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{ID}")
    public ResponseEntity< Void > deleteById( @PathVariable("USER_ID") String userId, @PathVariable("ID") String id)
    {
        service.deleteTaskById( id, userId );
        return ResponseEntity.ok().build();
    }

}

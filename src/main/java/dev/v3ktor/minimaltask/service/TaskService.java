package dev.v3ktor.minimaltask.service;

import dev.v3ktor.minimaltask.model.entity.Task;
import dev.v3ktor.minimaltask.model.entity.User;
import dev.v3ktor.minimaltask.model.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class TaskService {

    //Atributos
    @Autowired private UserRepository userRepository;
    @Autowired private UserService userService;


    //Métodos
    public Task createTaskByUserId( String userId, Task newTask )
    {
        var user = userService.getUserById( userId );
        var task = new Task( new ObjectId(), newTask.getTitle(), false, newTask.getTargetDate());

        user.getTasks().add( task );
        userRepository.save( user );

        return task;
    }

    public Task getTaskById( String id, String userId )
    {
        var user = userService.getUserById( userId );

        return user.getTasks().stream()
                .filter((task) -> task.getId() == id).toList().getFirst();
    }

    public List< Task > getAllTasksByUserId( String userId )
    {
        var user = userService.getUserById( userId );
        return user.getTasks();
    }

    public void updateTaskById( String id, String userId, Task newTask )
    {
        var user = userService.getUserById( userId );
        var updatedTasks = user.getTasks().stream()
                .map( (task) -> {
                    if( task.getId().equals(id) ) { newTask.setId( new ObjectId( task.getId() ) ); return newTask; }
                    else return task;
                } ).toList();

        System.out.println( newTask );
        updatedTasks.forEach( System.out::println );

        user.setTasks( updatedTasks );
        userRepository.save( user );
    }

    public void deleteTaskById( String id, String userId )
    {
        var user = userService.getUserById( userId );
        var updatedTasks = user.getTasks().stream()
                .filter( (task) -> !task.getId().equals( id ) ).toList();

        user.setTasks( updatedTasks );
        userRepository.save( user );
    }

}

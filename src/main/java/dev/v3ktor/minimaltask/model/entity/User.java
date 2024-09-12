package dev.v3ktor.minimaltask.model.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;
import java.util.List;

@Document( collection = "Users" )
public class User {

    //Propriedade
    @Id private ObjectId id;
    private String name;
    private String username;
    private String password;
    private List<Task> tasks = new ArrayList<Task>();

    //Contrutores
    public User() {}
    public User(ObjectId id, String name, String username, String password, List<Task> tasks) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.tasks = tasks;
    }

    //Getters & Setters
    public ObjectId getId() { return id; }
    public void setId(ObjectId id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public List<Task> getTasks() { return tasks; }
    public void setTasks(List<Task> tasks) { this.tasks = tasks; }

    //Métodos
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", username='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", tasks=").append(tasks);
        sb.append('}');
        return sb.toString();
    }


}
package dev.v3ktor.minimaltask.model.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import java.time.LocalDate;

public class Task {

    //Atributos
    @Id private ObjectId id;
    private String title;
    private Boolean done;
    private LocalDate targetDate;
    private LocalDate finishedDate;

    //Construtores
    public Task() {}
    public Task(ObjectId id, String title, Boolean done, LocalDate targetDate, LocalDate finishedDate) {
        this.id = id;
        this.title = title;
        this.done = done;
        this.targetDate = targetDate;
        this.finishedDate = finishedDate;
    }

    //Getters & Setters
    public String getId() { return id.toHexString(); }
    public void setId(ObjectId id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Boolean getDone() { return done; }
    public void setDone(Boolean done) { this.done = done; }

    public LocalDate getTargetDate() { return targetDate; }
    public void setTargetDate(LocalDate targetDate) { this.targetDate = targetDate; }

    public LocalDate getFinishedDate() { return finishedDate; }
    public void setFinishedDate(LocalDate finishedDate) { this.finishedDate = finishedDate; }

    //Métodos
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Task{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", done=").append(done);
        sb.append(", targetDate=").append(targetDate);
        sb.append(", finishedDate=").append(finishedDate);
        sb.append('}');
        return sb.toString();
    }
}
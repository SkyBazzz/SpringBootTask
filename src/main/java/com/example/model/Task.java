package com.example.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String summary;
    private boolean enabled;
    private int priority;

    public Task() {
    }

    public Task(String title, String summary, boolean enabled, int priority) {
        this.title = title;
        this.summary = summary;
        this.enabled = enabled;
        this.priority = priority;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return enabled == task.enabled &&
                priority == task.priority &&
                id.equals(task.id) &&
                title.equals(task.title) &&
                summary.equals(task.summary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, summary, enabled, priority);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", enabled=" + enabled +
                ", priority=" + priority +
                '}';
    }
}
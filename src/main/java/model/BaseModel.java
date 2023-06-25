package model;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class BaseModel {
    protected UUID id;
    protected LocalDateTime createdAt;

    protected BaseModel(){
        this.createdAt = LocalDateTime.now();
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}

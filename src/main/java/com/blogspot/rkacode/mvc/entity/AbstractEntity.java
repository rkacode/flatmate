package com.blogspot.rkacode.mvc.entity;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.util.UUID;

@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    protected String id;

    @Version
    protected long version;

    protected AbstractEntity() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

}

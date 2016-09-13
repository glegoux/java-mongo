package org.presentation.entities;

import java.util.Date;

import org.mongodb.morphia.annotations.Entity;

@Entity
public abstract class AbstractDocument {

    private Date updatetdAt;
    private Date createdAt;

}

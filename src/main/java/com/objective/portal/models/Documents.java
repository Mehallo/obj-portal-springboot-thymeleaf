package com.objective.portal.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "documents")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Documents {

    @Id
    private String id;
    private String name;

    @Column(name="assigned_privileges")
    private String privileges;

    @Column(name="date_delete")
    private String datedelete;

    //Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrivileges() {
        return privileges;
    }

    public void setPrivileges(String privileges) {
        this.privileges = privileges;
    }

    public String getDatedelete() {
        return datedelete;
    }

    public void setDatedelete(String date_delete) {
        this.datedelete = date_delete;
    }
}

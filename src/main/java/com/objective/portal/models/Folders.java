package com.objective.portal.models;

import javax.persistence.Column;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "folders")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Folders {

    @Id
    private String id;
    private String name;

    @Column(name="assigned_privileges")
    private String privileges;

    @Column(name="date_delete")
    private String datedelete;

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

    public void setDatedelete(String datedelete) {
        this.datedelete = datedelete;
    }
}

package com.objective.portal.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "groups")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Groups {

    @Id
    private String id;
    private String name;

    @Column(name="date_delete")
    private String datedelete;

    @Column(name="date_inactivate")
    private String dateinactivate;

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

    public String getDatedelete() {
        return datedelete;
    }

    public void setDatedelete(String datedelete) {
        this.datedelete = datedelete;
    }

    public String getDateinactivate() {
        return dateinactivate;
    }

    public void setDateinactivate(String dateinactivate) {
        this.dateinactivate = dateinactivate;
    }
}

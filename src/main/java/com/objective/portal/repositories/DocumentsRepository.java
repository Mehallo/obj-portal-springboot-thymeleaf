package com.objective.portal.repositories;

import com.objective.portal.models.Documents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface DocumentsRepository extends CrudRepository<Documents, Long> {

    //Works well IF no underscores
    //List<Documents> findByName(String name);
    //List<Documents> findByAssignedPrivilegesContaining(String assigned_privileges); // Underscores will cause you headaches....
    //@Query(value = "SELECT id FROM Documents d WHERE d.date_delete IS NULL AND d.assigned_privileges LIKE ?1", nativeQuery = true)
    //@Query(value = "SELECT id FROM Documents d WHERE d.date_delete IS NULL AND d.assigned_privileges LIKE '%gA2/%'", nativeQuery = true)
    //@Query(value="select id from documents", nativeQuery=true)
    //@Query(value = "SELECT id FROM Documents", nativeQuery = true)

    Documents findById(String id);

    List<Documents> findByName(String name);

    List<Documents> findByDatedeleteIsNullAndPrivilegesContaining(String privileges);

}

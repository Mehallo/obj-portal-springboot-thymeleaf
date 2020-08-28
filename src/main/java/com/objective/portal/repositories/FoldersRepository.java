package com.objective.portal.repositories;

import com.objective.portal.models.Documents;
import com.objective.portal.models.Folders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface FoldersRepository extends CrudRepository<Folders, Long> {

    Folders findById(String id);

    List<Folders> findByDatedeleteIsNullAndPrivilegesContaining(String privileges);

}

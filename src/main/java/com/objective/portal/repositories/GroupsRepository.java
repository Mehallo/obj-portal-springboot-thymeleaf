package com.objective.portal.repositories;

import com.objective.portal.models.Groups;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.List;

public interface GroupsRepository extends JpaRepository<Groups, Long> {

    //Iterable<Groups> findAll(Sort sort);

    Page<Groups> findAll(Pageable pagable);

    Groups findById(String id);

    List<Groups> findByDateinactivateIsNull();

    Page<Groups> findByDateinactivateIsNull(Pageable pagesable);

    Page<Groups> findByDateinactivateIsNullAndNameContaining(String groupName, Pageable pagesable);


}

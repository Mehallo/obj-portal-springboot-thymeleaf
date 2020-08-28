package com.objective.portal.controllers;

import com.objective.portal.models.Groups;
import com.objective.portal.repositories.GroupsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@Controller
@RequestMapping("/api/v1/groups")
public class GroupsContoller {

    @Autowired
    //private GroupsRepository groupsRepository;
    private GroupsRepository groupsRepository;

    @CrossOrigin
    @GetMapping("/list")
    public String list(Model model)
    {
        int pageNumber = 1;
        int pageSize = 20;



        //model.addAttribute("groups", groupsRepository.findByDateinactivateIsNull());
        //return groupsRepository.findByDateinactivateIsNull();
        return "groups";
    }

    @CrossOrigin
    @GetMapping("/id/{id}")
    public String get(@PathVariable("id") String id, Model model)
    {
        model.addAttribute("group", groupsRepository.findById(id));
        //return groupsRepository.findById(id);
        return "documents";
    }

    @GetMapping("/page/{pageNo}")
    public String getPaginated(@PathVariable(value = "pageNo") int pageNo, Model model) {
        int pageSize = 5;

        Page<Groups> page = this.findPaginated(pageNo, pageSize);
        List<Groups> listGroups = page.getContent();

        System.out.println("currentPage: " + pageNo);
        System.out.println("totalPages: " + page.getTotalPages());
        System.out.println("totalItems: " +  page.getTotalElements());
        System.out.println("listGroups: " + listGroups);

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("listGroups", listGroups);

        return "groups";
    }

    public Page<Groups> findPaginated(int pageNo, int pageSize){
        Pageable pageable = PageRequest.of(pageNo-1, pageSize);
        return groupsRepository.findByDateinactivateIsNull(pageable);
    }
}

package com.objective.portal.controllers;

import com.objective.portal.models.Groups;
import com.objective.portal.repositories.GroupsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/groups")
public class GroupsContoller {

    List<Groups> filteredListGroups;

    @Autowired
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

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("listGroups", listGroups);

        return "groups";
    }

    @GetMapping("/page/{pageNo}/{filter}")
    public String getPaginatedFiltered(@PathVariable(value = "pageNo") int filteredPageNo,@PathVariable(value = "filter") String groupName, Model model) {
        int filteredPageSize = 5;

        Page<Groups> filteredPage = this.findPaginatedFiltered(groupName, filteredPageNo, filteredPageSize);
        List<Groups> filteredListGroups = filteredPage.getContent();

        model.addAttribute("groupName", groupName);
        model.addAttribute("filteredCurrentPage", filteredPageNo);
        model.addAttribute("filteredTotalPages", filteredPage.getTotalPages());
        model.addAttribute("filteredTotalItems", filteredPage.getTotalElements());
        model.addAttribute("filteredListGroups", filteredListGroups);

        return "groupsFiltered";
    }

    public Page<Groups> findPaginated(int pageNo, int pageSize){
        Pageable pageable = PageRequest.of(pageNo-1, pageSize);
        return groupsRepository.findByDateinactivateIsNull(pageable);
    }

    public Page<Groups> findPaginatedFiltered(String groupName, int pageNo, int pageSize){
        Pageable pageable = PageRequest.of(pageNo-1, pageSize);
        return groupsRepository.findByDateinactivateIsNullAndNameContaining(groupName, pageable);
    }
}

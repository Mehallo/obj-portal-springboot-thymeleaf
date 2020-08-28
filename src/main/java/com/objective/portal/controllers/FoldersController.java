package com.objective.portal.controllers;

import com.objective.portal.models.Folders;
import com.objective.portal.repositories.FoldersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//@RestController
@Controller
@RequestMapping("/api/v1/folders")
public class FoldersController {

    @Autowired
    private FoldersRepository foldersRepository;

    @CrossOrigin
    @GetMapping("/list")
    public Iterable<Folders> list()
    {
        return foldersRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/id/{id}")
    public Folders get(@PathVariable("id") String id)
    {
        return foldersRepository.findById(id);
    }

    @CrossOrigin
    @GetMapping("/check/{privileges}")
    public List<Folders> checkPriviliges(@PathVariable("privileges") String privileges)
    {
        System.out.println(privileges);
        return foldersRepository.findByDatedeleteIsNullAndPrivilegesContaining(privileges);
    }

}

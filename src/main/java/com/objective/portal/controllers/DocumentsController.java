package com.objective.portal.controllers;

import com.objective.portal.models.Documents;
import com.objective.portal.repositories.DocumentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;


//@RestController
@Controller
@RequestMapping("/api/v1/documents")
public class DocumentsController {

   @Autowired
   private DocumentsRepository documentsRepository;

   @CrossOrigin
   @GetMapping("/list")
   public Iterable<Documents> list()
    {
        return documentsRepository.findAll();
    }

   @CrossOrigin
   @GetMapping("/id/{id}")
    public Documents get(@PathVariable("id") String id)
    {
        return documentsRepository.findById(id);
    }

    @CrossOrigin
    @GetMapping("/name/{name}")
    public List<Documents> getName(@PathVariable("name") String name)
    {
        System.out.println(name);
        return documentsRepository.findByName(name);
    }

    @CrossOrigin
    @GetMapping("/check/{privileges}")
    public String checkPriviliges(@PathVariable("privileges") String privileges, Model model)
    {
        System.out.println(privileges);
        model.addAttribute("priv", privileges);
        model.addAttribute("documents", documentsRepository.findByDatedeleteIsNullAndPrivilegesContaining(privileges));
        //return documentsRepository.findByDatedeleteIsNullAndPrivilegesContaining(privileges);
        return "documents";
    }
}

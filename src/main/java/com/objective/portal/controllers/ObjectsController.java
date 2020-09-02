package com.objective.portal.controllers;

import com.objective.portal.models.Documents;
import com.objective.portal.models.Folders;
import com.objective.portal.repositories.DocumentsRepository;
import com.objective.portal.repositories.FoldersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/v1/objects")
public class ObjectsController {

    @Autowired
    private DocumentsRepository documentsRepository;

    @Autowired
    private FoldersRepository foldersRepository;

    @GetMapping("/{privs}")
    public String getObjects(@PathVariable(value = "privs") String privs, Model model) {

        List<Documents> listDocuments = documentsRepository.findByDatedeleteIsNullAndPrivilegesContaining(privs);
        List<Folders> listFolders = foldersRepository.findByDatedeleteIsNullAndPrivilegesContaining(privs);

        model.addAttribute("privs", privs);
        model.addAttribute("documents", listDocuments);
        model.addAttribute("folders", listFolders);

        return "objects";
    }

}

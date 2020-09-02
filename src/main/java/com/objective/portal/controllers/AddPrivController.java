package com.objective.portal.controllers;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/api/v1/add/")
public class AddPrivController {

    @CrossOrigin
    @RequestMapping("menu")
    public String getMenu(){
        return "addPrivMenu";
    }

    @CrossOrigin
    @RequestMapping(value = "updateBulk", method = RequestMethod.POST)
    public String updatePrivBulk(@RequestParam("file") MultipartFile file,
                                 Model model){

        List<String[]> listOfLines = new ArrayList<String[]>();

        int count = 0;

        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {
            InputStream inputStream = file.getInputStream();
            br = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            while ((line = br.readLine()) != null) {
                System.out.println(count);
                System.out.println(line);
                // use comma as separator
                String[] entry = line.split(cvsSplitBy);
                listOfLines.add(entry);
                System.out.println("ObjID" + entry[0] + " , group=" + entry[1] + " , Privs: " + entry[2]);
                count++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        model.addAttribute("listOfLines", listOfLines);
        return "addPriv";

    }


    @CrossOrigin
    @RequestMapping("update/{id}/{group}/{privs}")
    public String updatePriv(@PathVariable(value = "id") String id,
                             @PathVariable(value = "group") String group,
                             @PathVariable(value = "privs") String privs,
                             Model model) {

        System.out.println("id: " + id);
        System.out.println("group: " + group);
        System.out.println("priv: " + privs);
        System.out.println("status: Success");

        model.addAttribute("id", id);
        model.addAttribute("group", group);
        model.addAttribute("privs", privs);
        model.addAttribute("status", "Success");

        return "addPriv";

    }

}

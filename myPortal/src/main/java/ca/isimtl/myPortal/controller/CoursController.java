/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.isimtl.myPortal.controller;

import ca.isimtl.myPortal.model.Cours;
import ca.isimtl.myPortal.service.CoursService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Francois YOUALEU
 */
@Controller
@RequestMapping("/allCours")
public class CoursController {
    
    @Autowired
    CoursService coursService;
    
    @RequestMapping(method = RequestMethod.GET)
    public String allCours(ModelMap model) {
        List<Cours> mesCours = coursService.getAllCours();
        model.addAttribute("cours", mesCours);
        return "cours";
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.isimtl.myPortal.controller;

import ca.isimtl.myPortal.model.Matiere;
import ca.isimtl.myPortal.service.MatiereService;
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
@RequestMapping("/allMatieres")
public class MatieresController {
    
    @Autowired
    MatiereService matiereService;
    
    @RequestMapping(method = RequestMethod.GET)
    public String allMatieres(ModelMap model) {
        List<Matiere> mesMatieres = matiereService.getAllMatieres();
        System.out.println("je fais un test /////////////////////"+mesMatieres);
        model.addAttribute("matieres", mesMatieres);
        return "matieres";
    }
}

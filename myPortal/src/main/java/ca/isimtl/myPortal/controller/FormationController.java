/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.isimtl.myPortal.controller;

import ca.isimtl.myPortal.model.Formation;
import ca.isimtl.myPortal.model.Matiere;
import ca.isimtl.myPortal.model.User;
import ca.isimtl.myPortal.service.FormationService;
import ca.isimtl.myPortal.service.UserService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author Francois YOUALEU
 */
@Controller
@RequestMapping("/allFormations")
@SessionAttributes("roles")
public class FormationController {

    @Autowired
    FormationService formationService;
    
    @Autowired
    UserService userService;
    
    @Autowired
    Map<String, String> sideMenu;

    //afficher les formations
    @RequestMapping(method = RequestMethod.GET)
    public String allFormations(ModelMap model) {
        
        List<Formation> mesFormations = formationService.getAll();
        
        model.addAttribute("formations", mesFormations);
        return "formations";
                
    }
    
    //afficher matieres par formation
    @RequestMapping(value = {"/edit-{id}-formation"}, method = RequestMethod.GET)
    public String formMat(@PathVariable int id, ModelMap model){
        
        Formation uneFormation = formationService.findById(id);
        List<Matiere> mesMatieres = uneFormation.getMesMatieres();
        
        model.addAttribute("matieres", mesMatieres);
        return "formationsMat";
    }
    
    //retour aux formations
    @RequestMapping(value = {"/back"}, method = RequestMethod.GET)
    public String retour(ModelMap model){
        
        
        List<Formation> mesFormations = formationService.getAll();
        
        model.addAttribute("formations", mesFormations);
        return "formations";
    }
    
    @ModelAttribute("loggedinuser")
    public String getLogedInUserFullName() {
        String result = "";
        User user = userService.getLogedInUser();
        if (user != null) {
            result = user.getPrenom() + " " + user.getNom();
        }
        return result;
    }

    @ModelAttribute("sidemenu")
    public Map<String, String> getSideMenu() {
        return sideMenu;
    }
}

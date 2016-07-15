/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.isimtl.myPortal.controller;

import ca.isimtl.myPortal.model.Matiere;
import ca.isimtl.myPortal.model.User;
import ca.isimtl.myPortal.service.MatiereService;
import ca.isimtl.myPortal.service.UserService;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @Autowired
    UserService userService;
    
    @Autowired
    Map<String, String> sideMenu;

    //afficher toutes les matieres
    @RequestMapping(method = RequestMethod.GET)
    public String allMatieres(ModelMap model) {
        List<Matiere> mesMatieres = matiereService.getAll();
        model.addAttribute("matieres", mesMatieres);
        return "matieres";
    }
    
    //ajouter une matiere
    @RequestMapping(value = {"/new"}, method = RequestMethod.GET)
    public String newMatiere(ModelMap model) {
        Matiere uneMat = new Matiere();
        model.addAttribute("matiere", uneMat);
        model.addAttribute("edit", false);
        return "matiereAdd";

    }
    
    @RequestMapping(value = {"/new"}, method = RequestMethod.POST)
    public String saveMatiere(@Valid Matiere uneMat, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "matieres";
        }

        matiereService.saveMatiere(uneMat);
        Matiere uneMatiere = new Matiere();
        model.addAttribute("matiere", uneMatiere);
        model.addAttribute("edit", false);
        return "matiereAdd";
    }
    
    //modifier une matiere
    @RequestMapping(value = {"/edit-{id}-matiere"}, method = RequestMethod.GET)
    public String editMatiere(@PathVariable int id, ModelMap model){
        
        Matiere uneMat = matiereService.findById(id);
        model.addAttribute("matiere", uneMat);
        model.addAttribute("edit", true);
        return "matiereAdd";
    }
    
    @RequestMapping(value ={"/edit-{id}-matiere"}, method = RequestMethod.POST)
    public String updateMatiere(@Valid Matiere uneMat, BindingResult result, ModelMap model){
        if(result.hasErrors()){
            return "matieres";
        }
        
        matiereService.updateMatiere(uneMat);
        List<Matiere> mesMatieres = matiereService.getAll();
        model.addAttribute("matieres", mesMatieres);
        return "matiere";
    }
    
    //supprimer une matiere
    @RequestMapping(value ={"/delete-{id}-matiere"}, method = RequestMethod.GET)
    public String deleteMatiere(@PathVariable int id, ModelMap model){
        Matiere uneMat = matiereService.findById(id);
        matiereService.deleteMatiere(uneMat);
        
        List<Matiere> mesMatieres = matiereService.getAll();
        model.addAttribute("matieres", mesMatieres);
        return "matieres";
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

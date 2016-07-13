/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.isimtl.myPortal.controller;

import ca.isimtl.myPortal.model.Matiere;
import ca.isimtl.myPortal.service.MatiereService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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

    //afficher toutes les matieres
    @RequestMapping(method = RequestMethod.GET)
    public String allMatieres(ModelMap model) {
        List<Matiere> mesMatieres = matiereService.getAll();
        model.addAttribute("matieres", mesMatieres);
        return "matieres";
    }
    
    //ajouter une matiere
    @RequestMapping(value = {"/allMatierss/new"}, method = RequestMethod.GET)
    public String newMatiere(ModelMap model) {
        Matiere uneMat = new Matiere();
        model.addAttribute("matiere", uneMat);
        model.addAttribute("edit", false);
        return "addMatiere";

    }
    
    @RequestMapping(value = {"/allMatierss/new"}, method = RequestMethod.POST)
    public String saveEmployee(@Valid Matiere uneMat, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "addMatiere";
        }

        matiereService.saveMatiere(uneMat);
        model.addAttribute("la matiere " + uneMat.getTitre() + " a ete bien enregistree");
        return "matieres";
    }
    
    //modifier une matiere
    @RequestMapping(value = {"/allMatierss/new"}, method = RequestMethod.POST)
    public String editMatiere(@PathVariable int id, ModelMap model){
        
        Matiere uneMat = matiereService.findById(id);
        model.addAttribute("matiere", uneMat);
        model.addAttribute("edit", true);
        return "addMatiere";
    }
    
    @RequestMapping(value ={"/allMatierss/new"}, method = RequestMethod.POST)
    public String updateMatiere(@Valid Matiere uneMat, BindingResult result, ModelMap model){
        if(result.hasErrors()){
            return "matieres";
        }
        
        matiereService.updateMatiere(uneMat);
        model.addAttribute("la matiere " + uneMat.getTitre() + " a ete bien modifiee");
        return "matieres";
    }
    
    @RequestMapping(value ={"allMatieres"}, method = RequestMethod.GET)
    public String deleteMatiere(@Valid Matiere uneMat){
        matiereService.deleteMatiere(uneMat);
        return "matieres";
    }

}

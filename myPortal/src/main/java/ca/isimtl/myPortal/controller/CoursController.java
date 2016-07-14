/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.isimtl.myPortal.controller;

import ca.isimtl.myPortail.entity.CoursEntity;
import ca.isimtl.myPortal.model.Cours;
import ca.isimtl.myPortal.model.Etudiant;
import ca.isimtl.myPortal.model.Matiere;
import ca.isimtl.myPortal.model.Prof;
import ca.isimtl.myPortal.model.User;
import ca.isimtl.myPortal.service.CoursService;
import ca.isimtl.myPortal.service.EtudiantService;
import ca.isimtl.myPortal.service.MatiereService;
import ca.isimtl.myPortal.service.ProfService;
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
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author Francois YOUALEU
 */
@Controller
@RequestMapping("/allCours")
@SessionAttributes("roles")
public class CoursController {
    
    @Autowired
    CoursService coursService;
    
    @Autowired
    UserService userService;
    
    @Autowired
    ProfService profService;
    
    @Autowired
    EtudiantService etuService;
    
    @Autowired
    MatiereService matiereService;
    
    @Autowired
    Map<String, String> sideMenu;
    
    //afficher tous les cours
    @RequestMapping(method = RequestMethod.GET)
    public String allCours(ModelMap model) {
        List<Cours> mesCours = coursService.getAll();
        model.addAttribute("cours", mesCours);
        return "cours";
    }
    
    //afficher les cours pour prof ou etudiant
    @RequestMapping(value = {"/etuProf"}, method = RequestMethod.GET)
    public String newMatiere(ModelMap model) {
        User unUser = userService.getLogedInUser();
        String monRole = unUser.getUserRole().getType();
        List<Cours> mesCours = null;
        
        if (monRole.equals("Professeur")){
            Prof unProf = profService.findByIdPersonne(unUser.getId());
            mesCours = unProf.getMesCours();
        }else if (monRole.equals("Etudiant")){
            Etudiant etu = etuService.findByIdPersonne(unUser.getId());
            System.out.println("je recupere un etudiant)"+ etu);
            mesCours = etu.getGroupe().getMesCours();
        }    
        
        model.addAttribute("cours", mesCours);    
        return "coursEtuProf";

    }
    
    //ajouter une cours
    @RequestMapping(value = {"/new"}, method = RequestMethod.GET)
    public String newCours(ModelMap model) {
        CoursEntity coursE = new CoursEntity();
        List<Matiere> matieres = matiereService.getAll();
        List<Prof> profs = profService.getAll();
        
        model.addAttribute("matiere", matieres);
        model.addAttribute("profs", profs);
        model.addAttribute("cours", coursE);
        model.addAttribute("edit", false);
        return "coursAdd";

    }
    
    @RequestMapping(value = {"/new"}, method = RequestMethod.POST)
    public String saveCours(@Valid CoursEntity coursE, BindingResult result, ModelMap model) {
        
        if (result.hasErrors()) {
            return "cours";
        }
        //obtenir la matiere a partir du nom du cours
        Matiere uneMat = null;
        List<Matiere> matieres = matiereService.getAll();
        for(Matiere uneMatiere : matieres){
            if (uneMatiere.getTitre().equals(coursE.getTitreMatiere())){
                uneMat = uneMatiere;
                break;
            }
        }
        //obtenir le prof a partir du nom du cours
        Prof unProf = null;
        List<Prof> profs = profService.getAll();
        for(Prof unP : profs){
            if (unP.getUser().getNom().equals(coursE.getNomProf())){
                unProf = unP;
                break;
            }
        }
        
        //enregistrement des donnes de CoursE vers CoursModel
        Cours unCours = new Cours();
        unCours.setLibelle(coursE.getLibelle());
        unCours.setMaSession(coursE.getMaSession());
        unCours.setPlageHoraire(coursE.getPlageHoraire());
        unCours.setDateDebut(coursE.getDateDebut());
        unCours.setDateFin(coursE.getDateFin());
        unCours.setProf(unProf);
        unCours.setUneMat(uneMat);

        coursService.saveCours(unCours);
        
        Cours unCours1 = new Cours();
        model.addAttribute("cours", unCours1);
        model.addAttribute("edit", false);
        return "coursAdd";
    }
    
    //modifier une cours
    @RequestMapping(value = {"/edit-{id}-cours"}, method = RequestMethod.GET)
    public String editCours(@PathVariable int id, ModelMap model){
        
        Cours unCours = coursService.findById(id);
        model.addAttribute("cours", unCours);
        model.addAttribute("edit", true);
        return "coursAdd";
    }
    
    @RequestMapping(value ={"/edit-{id}-cours"}, method = RequestMethod.POST)
    public String updateCours(@Valid Cours unCours, BindingResult result, ModelMap model){
        if(result.hasErrors()){
            return "matieres";
        }
        
        coursService.updateCours(unCours);
        model.addAttribute("edit", true);
        model.addAttribute("cours", unCours);
        return "coursAdd";
    }
    
    //supprimer une cours
    @RequestMapping(value ={"/delete-{id}-cours"}, method = RequestMethod.GET)
    public String deleteCours(@PathVariable int id, ModelMap model){
        Cours unCours = coursService.findById(id);
        coursService.deleteCours(unCours);
        
        List<Cours> mesCours = coursService.getAll();
        model.addAttribute("cours", mesCours);
        return "cours";
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

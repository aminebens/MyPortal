/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.isimtl.myPortal.controller;

import ca.isimtl.myPortal.model.Cours;
import ca.isimtl.myPortal.model.Etudiant;
import ca.isimtl.myPortal.model.Prof;
import ca.isimtl.myPortal.model.User;
import ca.isimtl.myPortal.service.EtudiantService;
import ca.isimtl.myPortal.service.ProfService;
import ca.isimtl.myPortal.service.UserService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author Francois YOUALEU
 */
@Controller
@RequestMapping("/horairesCours")
@SessionAttributes("roles")
public class EmploiController {

    @Autowired
    UserService userService;

    @Autowired
    ProfService profService;

    @Autowired
    EtudiantService etuService;

    @Autowired
    Map<String, String> sideMenu;

    @RequestMapping(method = RequestMethod.GET)
    public String horairesCours(ModelMap model) {

        List<Cours> mesCours = null;
        Cours cours = null;
        int nombreJours =0;
        int jourDebut =0;
        int jourFin = 0;
        User unUser = userService.getLogedInUser();
        String today = aujourdhui();
        LocalDate dateCours = new LocalDate();
        

        if (unUser.getUserRole().getType().toUpperCase().equals("PROFESSEUR")) {
            Prof unProf = profService.findByIdPersonne(unUser.getId());
            mesCours = unProf.getMesCours();
            for (Cours unCours : mesCours){
                dateCours = unCours.getDateDebut();
                if (dateCours.getMonthOfYear() == 07){
                    cours = unCours;
                    break;
                }
            }
            
            if(cours.getUneMat()!= null){
                nombreJours = cours.getUneMat().getDuree() / 5;
                jourDebut = cours.getDateDebut().getDayOfMonth();
                jourFin = jourDebut + nombreJours;
            }
            
            

        } else if (unUser.getUserRole().getType().toUpperCase().equals("ETUDIANT")) {
            Etudiant etu = etuService.findByIdPersonne(unUser.getId());
            mesCours = etu.getGroupe().getMesCours();
             for (Cours unCours : mesCours){
                dateCours = unCours.getDateDebut();
                if (dateCours.getMonthOfYear() == 07){
                    cours = unCours;
                    break;
                }
            }
            
            if(cours.getUneMat()!= null){
                nombreJours = cours.getUneMat().getDuree() / 5;
                jourDebut = cours.getDateDebut().getDayOfMonth();
                jourFin = jourDebut + nombreJours;
            }

        }
        
        model.addAttribute("jourFin", jourFin);
        model.addAttribute("jourDebut", jourDebut);
        model.addAttribute("today", today);
        model.addAttribute("cours", cours);
        

        return "emploiTemps";
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
    
    public String aujourdhui() {
       final Date date = new Date();
       return new SimpleDateFormat("dd-MM-yyyy").format(date);
    }
    
}

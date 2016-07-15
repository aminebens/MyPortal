/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.isimtl.myPortal.controller;

import ca.isimtl.myPortal.model.Facture;
import ca.isimtl.myPortal.model.User;
import ca.isimtl.myPortal.service.FactureService;
import ca.isimtl.myPortal.service.UserService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author Nicolas
 */
@Controller
@SessionAttributes("roles")
public class FactureController {

    @Autowired
    UserService userService;
    
    @Autowired
    FactureService factureService;

    @Autowired
    Map<String, String> sideMenu;
    
    
    @RequestMapping(value = {"/facture"}, method = RequestMethod.GET)
     public Facture getLoggedInUserFacture(ModelMap model) {
        
        Facture facture = null;
        
        model.addAttribute("facture", facture);
        model.addAttribute("edit", true);
        model.addAttribute("loggedinuser", getLogedInUserFullName());
        model.addAttribute("sidemenu", sideMenu);
        
        User user = userService.getLogedInUser();
        if (user != null) {
            facture = factureService.findByUserId(user.getId());
        }
        return facture;
    }
     
     public String getLogedInUserFullName() {
        String result = "";
        User user = userService.getLogedInUser();
        if (user != null) {
            result = user.getPrenom() + " " + user.getNom();
        }
        return result;
    }

}
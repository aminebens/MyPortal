/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.isimtl.myPortal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Francois YOUALEU
 */
@Controller
@RequestMapping("/horairesCours")
public class EmploiController {
    
    @RequestMapping(method = RequestMethod.GET)
    public String horairesCours(ModelMap model) {
     
        return "emploiTemps";
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.isimtl.myPortal.controller;

import ca.isimtl.myPortal.model.Sujet;
import ca.isimtl.myPortal.service.SujetService;
import ca.isimtl.myPortal.service.UserService;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SujetControlleur {

    @Autowired
    SujetService sujetService;
    
    @Autowired
    UserService userService;

    @RequestMapping(value = {"/sujet/add"}, method = RequestMethod.GET)
    public String ajouterSujet(ModelMap model) {
        Sujet sujet = new Sujet();
        model.addAttribute("sujet", sujet);
        model.addAttribute("idUser", 3);
        model.addAttribute("date", (new Date()).toString());
        return "sujetAdd";
    }

    @RequestMapping(value = {"/sujet/add"}, method = RequestMethod.POST)
    public String saveSujet(@Valid Sujet sujet, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            
            return "sujetAdd";
        }
        sujetService.saveSujet(sujet);
        sujet = new Sujet();
        model.addAttribute("sujet", sujet);
        model.addAttribute("idUser", 3);
        model.addAttribute("date", (new Date()).toString());
        return "sujetAdd";
    }
    
    @RequestMapping(value = {"/sujet/{id}"}, method = RequestMethod.GET)
    public String voirSujet(@PathVariable int id, ModelMap model) {
        Sujet sujet = sujetService.getSujetById(id);
        model.addAttribute("sujet", sujet);
        return "sujet";
    }
    
    @RequestMapping(value = {"/sujet/resolu/{id}"}, method = RequestMethod.GET)
    public String resoluSujet(@PathVariable int id, ModelMap model) {
        Sujet sujet = sujetService.getSujetById(id);
        if(sujet==null){
            return "sujetAdd";
        }
        sujetService.sujetResolut(sujet);
        int role=1;
        boolean user=true;
        List<Sujet> sujets;
        if(role==1){
            user=false;
            sujets=sujetService.getAllSujetNonResolut();
        }else{
            sujets=sujetService.getSujetNonResolutByIdUser(userService.findById(3));
        }
        
        model.addAttribute("sujets", sujets);
        model.addAttribute("user", user);
        return "sujets";
    }
    
    @RequestMapping(value = {"/sujets"}, method = RequestMethod.GET)
    public String allSujet( ModelMap model) {
        int role=2;
        boolean user=true;
        List<Sujet> sujets;
        if(role==1){
            user=false;
            sujets=sujetService.getAllSujetNonResolut();
        }else{
            sujets=sujetService.getSujetNonResolutByIdUser(userService.findById(3));
        }
        
        model.addAttribute("sujets", sujets);
        model.addAttribute("user", user);
        return "sujets";
    }
}

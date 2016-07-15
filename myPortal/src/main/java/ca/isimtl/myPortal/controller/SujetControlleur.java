/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.isimtl.myPortal.controller;

import ca.isimtl.myPortal.model.Message;
import ca.isimtl.myPortal.model.Sujet;
import ca.isimtl.myPortal.model.User;
import ca.isimtl.myPortal.service.MessageService;
import ca.isimtl.myPortal.service.SujetService;
import ca.isimtl.myPortal.service.UserService;
import java.util.Date;
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

@Controller
@SessionAttributes("roles")
public class SujetControlleur {

    @Autowired
    SujetService sujetService;

    @Autowired
    UserService userService;

    @Autowired
    MessageService messageService;

    @Autowired
    Map<String, String> sideMenu;

    @RequestMapping(value = {"/sujet/add"}, method = RequestMethod.GET)
    public String ajouterSujet(ModelMap model) {
        if (userService.getLogedInUser().getUserRole().getType().toUpperCase().equals("ADMIN")) {
            return "redirect:/sujets";
        }
        Sujet sujet = new Sujet();
        sujet.setUser(userService.getLogedInUser());
        sujet.setDate_creation(new Date());
        sujet.setIsResolu(false);
        model.addAttribute("sujet", sujet);
        return "sujetAdd";
    }

    @RequestMapping(value = {"/sujet/add"}, method = RequestMethod.POST)
    public String saveSujet(@Valid Sujet sujet, BindingResult result, ModelMap model) {
        if (userService.getLogedInUser().getUserRole().getId() == 6) {
            return "redirect:/sujets";
        }

        if (result.hasErrors()) {
            return "sujetAdd";
        }
        sujet.setUser(userService.getLogedInUser());
        sujetService.saveSujet(sujet);
        return "redirect:/sujets";
    }

    @RequestMapping(value = {"/sujet/{id}"}, method = RequestMethod.GET)
    public String voirSujet(@PathVariable int id, ModelMap model) {
        Sujet sujet = sujetService.getSujetById(id);
        User userLog = userService.getLogedInUser();
        if (sujet.getUser().getId() != userLog.getId() && userLog.getUserRole().getId() != 6) {
            return "redirect:/sujets";
        }
        Message message = new Message();
        message.setDate(new Date());
        model.addAttribute("sujet", sujet);
        model.addAttribute("message", message);
        return "sujet";
    }

    @RequestMapping(value = {"/sujet/{id}"}, method = RequestMethod.POST)
    public String ajouterMessage(@Valid Message message, BindingResult result, @PathVariable int id, ModelMap model) {
        Sujet sujet = sujetService.getSujetById(id);
        User userLog = userService.getLogedInUser();
        if (sujet.getUser().getId() != userLog.getId() && userLog.getUserRole().getId() != 6) {
            return "redirect:/sujets";
        }
        if (result.hasErrors()) {
            model.addAttribute("sujet", sujet);
            return "sujet";
        }
        message.setSujet(sujetService.getSujetById(id));
        if (userLog.getUserRole().getId() == 6) {
            message.setUserFrom(userLog);
            message.setUserTo(sujet.getUser());
        } else {
            message.setUserFrom(userLog);
            message.setUserTo(userService.getAdmin().get(0));
        }
        message.setId(0);
        messageService.saveMessage(message);
        return "redirect:/sujet/"+sujet.getId();
    }

    @RequestMapping(value = {"/sujet/resolu/{id}"}, method = RequestMethod.GET)
    public String resoluSujet(@PathVariable int id, ModelMap model) {
        Sujet sujet = sujetService.getSujetById(id);
        User userLog = userService.getLogedInUser();
        if (sujet.getUser().getId() != userLog.getId() && userLog.getUserRole().getId() != 6) {
            return "redirect:/sujets";
        }
        if (sujet == null) {
            return "redirect:/sujets";
        }
        sujetService.sujetResolut(sujet);
        return "redirect:/sujets";
    }

    @RequestMapping(value = {"/sujets"}, method = RequestMethod.GET)
    public String allSujet(ModelMap model) {
        User userLog = userService.getLogedInUser();
        boolean user = true;
        List<Sujet> sujets;
        if (userLog.getUserRole().getId() == 6) {
            user = false;
            sujets = sujetService.getAllSujetNonResolut();
        } else {
            sujets = sujetService.getSujetNonResolutByIdUser(userLog);
        }

        model.addAttribute("sujets", sujets);
        model.addAttribute("user", user);
        return "sujets";
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

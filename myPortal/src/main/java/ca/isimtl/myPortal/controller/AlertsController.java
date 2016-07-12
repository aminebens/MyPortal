/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.isimtl.myPortal.controller;

import ca.isimtl.myPortal.model.Alert;
import ca.isimtl.myPortal.model.Group;
import ca.isimtl.myPortal.model.User;
import ca.isimtl.myPortal.service.AlertService;
import ca.isimtl.myPortal.service.GroupService;
import ca.isimtl.myPortal.service.UserService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AlertsController {
    
    @Autowired
    AlertService alertService;
    
    @Autowired
    UserService userService;
    
    @Autowired
    GroupService groupService;
    
    @RequestMapping(value = {"/alert"}, method = RequestMethod.GET)
    public String viewAlerts(ModelMap model) {
        List<Alert> alertsUser = alertService.findByIdUserTO(3);
        List<Alert> alertsGroup = alertService.getAllAlert();
       // model.addAttribute("alertsUser", alertsUser);
        model.addAttribute("alertsUser", alertsGroup);
        return "alerts";
    }
    
    @RequestMapping(value = {"/alert/{id}"}, method = RequestMethod.GET)
    public String viewAlert(@PathVariable int id , ModelMap model) {
        Alert alert = alertService.findByid(id);
        User userFrom= userService.findById(alert.getIdUserFrom());
        model.addAttribute("alert", alert);
        model.addAttribute("userFrom", userFrom);
        return "alert";
    }
    
    @RequestMapping(value = {"/alert/admin"}, method = RequestMethod.GET)
    public String adminViewAlert (ModelMap model) {
        List<Alert> alerts = alertService.getAllAlert();
        model.addAttribute("alerts", alerts);
        return "alerts";
    }
    
    @RequestMapping(value = {"/alert/add"}, method = RequestMethod.GET)
    public String newAlert(ModelMap model) {
        Alert alert = new Alert();
        alert.setIdUserFrom(3);
        model.addAttribute("alert", alert);
        return "alertAdd";
    }
    
    @RequestMapping(value = {"alert/add"}, method = RequestMethod.POST)
    public String saveAlert(@Valid Alert alerte, BindingResult result, ModelMap model) {

       
        if (result.hasErrors()) {
            System.out.println(result.getErrorCount());
            return "alertAdd";
        }
        alertService.saveAlert(alerte);
        alerte = new Alert();
        alerte.setIdUserFrom(3);
        model.addAttribute("alert", alerte);
        return "alertAdd";
    }
    
    
    
    @ModelAttribute("users")
    public List<User> initializeUsers() {
        return userService.getAllUsers();
    }
    
    @ModelAttribute("groups")
    public List<Group> initializeGroups() {
        return groupService.getAllgroup();
    }
    
}

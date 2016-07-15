/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.isimtl.myPortal.controller;

import ca.isimtl.myPortal.model.Group;
import ca.isimtl.myPortal.model.User;
import ca.isimtl.myPortal.service.GroupService;
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
 * @author yaantech
 */
@Controller
public class GroupsControlleur {

    @Autowired
    GroupService service;

    @Autowired
    UserService userService;
    
    @Autowired
    Map<String, String> sideMenu;

    @RequestMapping(value = {"/group"}, method = RequestMethod.GET)
    public String listGroups(ModelMap model) {
        List<Group> groupes = service.getAllgroup();
        model.addAttribute("groupes", groupes);
        model.addAttribute("faire", "");
        return "group";
    }

    @RequestMapping(value = {"/group/add"}, method = RequestMethod.GET)
    public String AddGroup(ModelMap model) {
        Group groupe = new Group();
        model.addAttribute("groupe", groupe);
        model.addAttribute("faire", "ajouter");
        return "group";
    }

    @RequestMapping(value = {"/group/add"}, method = RequestMethod.POST)
    public String AddGroupBd(@Valid Group groupe, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            model.addAttribute("groupe", groupe);
            model.addAttribute("faire", "ajouter");
            return "group";
        }

        service.saveGroup(groupe);

        groupe = new Group();
        model.addAttribute("groupe", groupe);
        model.addAttribute("faire", "ajouter");
        return "group";
    }

    @RequestMapping(value = {"/group/{id}"}, method = RequestMethod.GET)
    public String listUsers(@PathVariable int id,ModelMap model) {
        Group groupe = service.findById(id);
        model.addAttribute("groupe", groupe);
        model.addAttribute("faire", "modifier");
        return "group";
    }
    
    @RequestMapping(value = {"/group/{id}"}, method = RequestMethod.POST)
    public String udategroup(@Valid Group groupe, BindingResult result, ModelMap model) {
        service.updateGroup(groupe);
        return "redirect:/group";
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

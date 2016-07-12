/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.isimtl.myPortal.controller;

import ca.isimtl.myPortal.model.Group;
import ca.isimtl.myPortal.service.GroupService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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

    @RequestMapping(value = {"/group{id}"}, method = RequestMethod.POST)
    public String listUsers(ModelMap model) {
        List<Group> groupes = service.getAllgroup();
        model.addAttribute("groupes", groupes);
        model.addAttribute("faire", "modifier");
        return "group";
    }
}

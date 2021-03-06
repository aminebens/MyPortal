package ca.isimtl.myPortal.controller;

import ca.isimtl.myPortal.model.Alert;
import ca.isimtl.myPortal.model.Group;
import ca.isimtl.myPortal.model.User;
import ca.isimtl.myPortal.service.AlertService;
import ca.isimtl.myPortal.service.GroupService;
import ca.isimtl.myPortal.service.UserService;
import java.util.ArrayList;
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
public class AlertsController {

    @Autowired
    AlertService alertService;

    @Autowired
    UserService userService;

    @Autowired
    GroupService groupService;

    @Autowired
    Map<String, String> sideMenu;

    @RequestMapping(value = {"/alerts"}, method = RequestMethod.GET)
    public String viewAlerts(ModelMap model) {
        Boolean admin=false;
        List<Alert> alerts;
        if(userService.getLogedInUser().getUserRole().getType().toUpperCase().equals("ADMIN")){
            alerts = alertService.getAllAlert();
            admin=true;
        }else{
            alerts = alertService.findByIdUserTO(userService.getLogedInUser().getId());
        }
        
        List<Alert> alertsGroup = new ArrayList<Alert>();
        if (userService.getLogedInUser().getUserRole().getType().toUpperCase().equals("ETUDIANT")) {
            alertsGroup = alertService.findByIdGroup(1);
        }
        
        
        model.addAttribute("alerts", alerts);
        model.addAttribute("alertsGroup", alertsGroup);
        model.addAttribute("vosAlerts",alertService.findByIdUserFrom(userService.getLogedInUser().getId()));
        model.addAttribute("admin", admin);
        model.addAttribute("etu",userService.getLogedInUser().getUserRole().getType().toUpperCase().equals("ETUDIANT"));
        
        return "alerts";
    }

    @RequestMapping(value = {"/alert/{id}"}, method = RequestMethod.GET)
    public String viewAlert(@PathVariable int id, ModelMap model) {
        Alert alert = alertService.findByid(id);
        User userFrom = userService.findById(alert.getIdUserFrom());
        model.addAttribute("alert", alert);
        model.addAttribute("userFrom", userFrom);
        return "alert";
    }

    
    @RequestMapping(value = {"/alert/add"}, method = RequestMethod.GET)
    public String newAlert(ModelMap model) {
        if(userService.getLogedInUser().getUserRole().getType().toUpperCase().equals("ETUDIANT")){
            return "redirect:/alerts";
        }
        Alert alert = new Alert();
        alert.setIdUserFrom(userService.getLogedInUser().getId());
        model.addAttribute("msg", "");
        model.addAttribute("alert", alert);
        model.addAttribute("edit",false);
        return "alertAdd";
    }

    @RequestMapping(value = {"alert/add"}, method = RequestMethod.POST)
    public String saveAlert(@Valid Alert alerte, BindingResult result, ModelMap model) {

        if(userService.getLogedInUser().getUserRole().getType().toUpperCase().equals("ETUDIANT")){
            return "redirect:/alerts";
        }
        
        if (result.hasErrors()) {
            return "alertAdd";
        }
        
        if((alerte.getIdGroupe()==null && alerte.getIdUserTo()==null )||(alerte.getIdGroupe()!=null && alerte.getIdUserTo()!=null ) ){
            model.addAttribute("msg", "selectionner un utilisateur ou un groupe");
            return "alertAdd";
        }
        
        return "redirect:/alert/add";
    }

    @RequestMapping(value = {"/alert/supp/{id}"}, method = RequestMethod.GET)
    public String suppAlert(@PathVariable int id, ModelMap model) {
        Alert alert = alertService.findByid(id);
        
        if(userService.getLogedInUser().getId()!=alert.getIdUserFrom()&&!userService.getLogedInUser().getUserRole().getType().toUpperCase().equals("ADMIN")){
            return "redirect:/alerts";
        }
        
        alertService.deleteAlert(alert);
        return "redirect:/alerts";
    }
    
    @RequestMapping(value = {"/alert/update/{id}"}, method = RequestMethod.POST)
    public String updateAlert(@Valid Alert alerte, BindingResult result, ModelMap model) {
        if(!userService.getLogedInUser().getUserRole().getType().toUpperCase().equals("ADMIN") && userService.getLogedInUser().getId()!=alerte.getIdUserFrom() ){
            return "redirect:/alerts";
        }
        alertService.updateAlert(alerte);
        return "redirect:/alerts";
    }
    
    @RequestMapping(value = {"/alert/update/{id}"}, method = RequestMethod.GET)
    public String editeAlert(@PathVariable int id, ModelMap model) {
        Alert alert = alertService.findByid(id);
        if(!userService.getLogedInUser().getUserRole().getType().toUpperCase().equals("ADMIN") && userService.getLogedInUser().getId()!=alert.getIdUserFrom() ){
            return "redirect:/alerts";
        }
        model.addAttribute("alert", alert);
        model.addAttribute("edit",true);
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

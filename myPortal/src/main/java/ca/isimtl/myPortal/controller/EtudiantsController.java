package ca.isimtl.myPortal.controller;

import ca.isimtl.myPortal.model.Etudiant;
import ca.isimtl.myPortal.model.Group;
import ca.isimtl.myPortal.model.User;
import ca.isimtl.myPortal.service.EtudiantService;
import ca.isimtl.myPortal.service.GroupService;
import ca.isimtl.myPortal.service.UserService;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("roles")
public class EtudiantsController {
    
    @Autowired
    GroupService groupeService;
    
    @Autowired
    UserService userService;
    
    @Autowired
    EtudiantService etuService;

    @Autowired
    MessageSource messageSource;

    @Autowired
    Map<String, String> sideMenu;
    
    @RequestMapping(value = {"/etudiants"}, method = RequestMethod.GET)
    public String listUsers(ModelMap model) {
        List<User> etudiants = userService.getEtidiantAcconts();
        model.addAttribute("etudiants", etudiants);
        model.addAttribute("sidemenu", sideMenu);
        model.addAttribute("loggedinuser", getLogedInUserFullName());
        return "etudiants";
    }
    
    @RequestMapping(value = {"/etudiants/edit-{id}-etu"}, method = RequestMethod.GET)
    public String editUser(@PathVariable int id, ModelMap model) {
        User user = userService.findById(id);
        Etudiant etu = new Etudiant();
        model.addAttribute("user", user);
        model.addAttribute("etu", etu);
        model.addAttribute("edit", true);
        model.addAttribute("loggedinuser", getLogedInUserFullName());
        model.addAttribute("sidemenu", sideMenu);
        return "etudiantAdd";
    }

    @RequestMapping(value = {"/etudiants/edit-{id}-etu"}, method = RequestMethod.POST)
    public String updateEmployee(@Valid Etudiant etu, BindingResult result,
            ModelMap model, @PathVariable int id) {

        if (result.hasErrors()) {
            return "etudiantAdd";
        }

        etuService.saveEtudiant(etu);

        model.addAttribute("success", "Etudiant inscrit");
        model.addAttribute("loggedinuser", getLogedInUserFullName());
        model.addAttribute("sidemenu", sideMenu);
        return "success";
    }
    
    public List<Group> initializeGroupes() {
        return groupeService.getAllgroup();
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

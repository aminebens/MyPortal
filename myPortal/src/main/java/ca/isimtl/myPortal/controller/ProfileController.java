package ca.isimtl.myPortal.controller;

import ca.isimtl.myPortal.model.User;
import ca.isimtl.myPortal.service.UserService;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Amine
 */
@Controller
public class ProfileController {
    
    @Autowired
    UserService service;
    
    @Autowired
    Map<String, String> sideMenu;
    
    @Autowired
    MessageSource messageSource;
    
    @RequestMapping(value = {"/profile"}, method = RequestMethod.GET)
    public String getProfile(ModelMap model) {
        User profile = service.getLogedInUser();
        //System.out.println(profile);
        model.addAttribute("loggedinuser", getLogedInUserFullName());
        model.addAttribute("profile", profile);
        model.addAttribute("sidemenu", sideMenu);
        return "profile";
    }
    
    @RequestMapping(value = {"/profile"}, method = RequestMethod.POST)
    public String updateProfile(@Valid User profile, BindingResult result, ModelMap model) {
        
        User sessionUser = service.getLogedInUser();
        profile.setId(sessionUser.getId());
        profile.setNom(sessionUser.getNom());
        profile.setPrenom(sessionUser.getPrenom());
        profile.setLogin(sessionUser.getLogin());
        profile.setPwd(sessionUser.getPwd());
        profile.setActive(sessionUser.getActive());
        profile.setDateNaissance(sessionUser.getDateNaissance());
        profile.setNumeroAssuranceSociale(sessionUser.getNumeroAssuranceSociale());
        profile.setUserRole(sessionUser.getUserRole());
        
        service.updateUser(profile);

        model.addAttribute("success", "Your Profile updated successfully");
        model.addAttribute("loggedinuser", getLogedInUserFullName());
        model.addAttribute("sidemenu", sideMenu);
        return "success";
    }
    
    public String getLogedInUserFullName() {
        String result = "";
        User user = service.getLogedInUser();
        if (user != null) {
            result = user.getPrenom() + " " + user.getNom();
        }
        return result;
    }
    
}

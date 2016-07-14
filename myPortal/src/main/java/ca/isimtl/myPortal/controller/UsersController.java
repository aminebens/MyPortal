package ca.isimtl.myPortal.controller;

import ca.isimtl.myPortal.model.User;
import ca.isimtl.myPortal.model.UserRole;
import ca.isimtl.myPortal.service.UserRoleService;
import ca.isimtl.myPortal.service.UserService;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
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
public class UsersController {

    @Autowired
    UserService service;

    @Autowired
    UserRoleService userRoleService;

    @Autowired
    MessageSource messageSource;

    @Autowired
    Map<String, String> sideMenu;

    /*
     * This method will list all existing users.
     */
    @RequestMapping(value = {"/users", "users/list"}, method = RequestMethod.GET)
    public String listUsers(ModelMap model) {
        List<User> users = service.getAllUsers();
        model.addAttribute("users", users);
        model.addAttribute("sidemenu", sideMenu);
        model.addAttribute("loggedinuser", getLogedInUserFullName());
        return "users";
    }

    /*
     * This method will provide the medium to add a new user.
     */
    @RequestMapping(value = {"/users/new"}, method = RequestMethod.GET)
    public String newUser(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("edit", false);
        model.addAttribute("sidemenu", sideMenu);
        model.addAttribute("loggedinuser", getLogedInUserFullName());
        return "registration";
    }

    /*
     * This method will be called on form submission, handling POST request for
     * saving user in database. It also validates the user input
     */
    @RequestMapping(value = {"/users/new"}, method = RequestMethod.POST)
    public String saveUser(@Valid User user, BindingResult result,
            ModelMap model) {

        if (result.hasErrors()) {
            return "registration";
        }

        service.saveUser(user);
        model.addAttribute("loggedinuser", getLogedInUserFullName());
        model.addAttribute("success", "User " + user.getPrenom() + " " + user.getNom() + " added successfully");
        return "success";
    }

    /*
     * This method will provide the medium to update an existing user.
     */
    @RequestMapping(value = {"/users/edit-{id}-user"}, method = RequestMethod.GET)
    public String editUser(@PathVariable int id, ModelMap model) {
        User user = service.findById(id);
        model.addAttribute("user", user);
        model.addAttribute("edit", true);
        model.addAttribute("loggedinuser", getLogedInUserFullName());
        model.addAttribute("sidemenu", sideMenu);
        return "registration";
    }

    /*
     * This method will be called on form submission, handling POST request for
     * updating user in database. It also validates the user input
     */
    @RequestMapping(value = {"/users/edit-{id}-user"}, method = RequestMethod.POST)
    public String updateEmployee(@Valid User user, BindingResult result,
            ModelMap model, @PathVariable int id) {

        if (result.hasErrors()) {
            return "registration";
        }

        service.updateUser(user);

        model.addAttribute("success", "User " + user.getPrenom() + " " + user.getNom() + " updated successfully");
        model.addAttribute("loggedinuser", getLogedInUserFullName());
        return "success";
    }

    /**
     * This method will provide UserRole list to views
     *
     * @return
     */
    @ModelAttribute("roles")
    public List<UserRole> initializeProfiles() {
        return userRoleService.findAll();
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
            SecurityContextHolder.getContext().setAuthentication(null);
        }
        return "redirect:/login";
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

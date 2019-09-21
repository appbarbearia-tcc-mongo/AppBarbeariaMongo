package br.com.appbarbearia.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.appbarbearia.model.User;
import br.com.appbarbearia.service.SecurityService;
import br.com.appbarbearia.service.UserServiceImpl;
import br.com.appbarbearia.validator.UserValidator;

@Controller
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;
    
    @Autowired
    private UserValidator userValidator;

    @GetMapping("/registration")
    public ModelAndView registration(Model model) {
        model.addAttribute("userForm", new User());

        return new ModelAndView("webapp/registration_index").addObject("userForm", new User());
    }

    @PostMapping("/registration")
    public ModelAndView registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return new ModelAndView("registration");
        }

        userServiceImpl.save(userForm);

        SecurityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return new ModelAndView("redirect:/welcome");
    }

    @GetMapping("/login")
    public ModelAndView login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return new ModelAndView("/webapp/login");
    }

    @GetMapping({"/", "/welcome"})
    public ModelAndView welcome(Model model) {
        return new ModelAndView("welcome");
    }

    
}
package de.hybris.platform.cuppytrailfrontend.controller;

import de.hybris.platform.cuppytrail.data.MatchSummaryData;
import de.hybris.platform.cuppytrail.facades.CuppyUserFacade;
import de.hybris.platform.cuppytrail.data.CuppyUserData;
import de.hybris.platform.cuppytrail.facades.impl.SpecialMatchFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CuppyTrUsersController {
    private CuppyUserFacade cuppyUserFacade;
    private SpecialMatchFacade specialMatchFacade;

    @RequestMapping(value = "/home")
    public String goToHomePage(final Model model) {
        return "home";
    }

    @RequestMapping(value = "/login")
    public String goToLoginPage() {
        return "cuppyUserLogin";
    }

    @RequestMapping(value = "/registration")
    public String goToRegistrationPage() {
        return "cuppyUserRegistration";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginCuppyUser(@RequestParam("username") String name, @RequestParam("password") String password, final Model model) {
        if ((name == null || name.trim().isEmpty()) || (password == null || password.trim().isEmpty())) {
            model.addAttribute("toShowError", true);
            return "cuppyUserLogin";
        }

        boolean isUser = cuppyUserFacade.isExistingUser(name, password);
        if (!isUser) {
            model.addAttribute("toShowError", true);
            return "cuppyUserLogin";
        } else {
            List<MatchSummaryData> summaryData = specialMatchFacade.getMarkedMatches();
            model.addAttribute("userName", name);
            model.addAttribute("matches", summaryData);
            return "cuppyUserProfile";
        }
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String addCuppyUser(@ModelAttribute CuppyUserData cuppyUserData, final Model model) {
        String name = cuppyUserData.getName();
        String username = cuppyUserData.getUsername();
        String phone = cuppyUserData.getPhone();
        String login = cuppyUserData.getLogin();
        String password = cuppyUserData.getPassword();

        if ((name == null || name.trim().isEmpty()) ||
                (username == null || username.trim().isEmpty()) ||
                (phone == null || phone.trim().isEmpty()) ||
                (login == null || login.trim().isEmpty()) ||
                (password == null || password.trim().isEmpty())) {
            model.addAttribute("toShowError", true);
            return "cuppyUserRegistration";
        }
        cuppyUserFacade.addUser(cuppyUserData);
        return "cuppyUserLogin";
    }

    @Autowired
    public void setFacade(final CuppyUserFacade facade) {
        this.cuppyUserFacade = facade;
    }

    @Autowired
    public void setFacade(final SpecialMatchFacade specialMatchFacade) {
        this.specialMatchFacade = specialMatchFacade;
    }
}

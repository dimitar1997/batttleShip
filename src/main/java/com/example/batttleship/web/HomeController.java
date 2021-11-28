package com.example.batttleship.web;

import com.example.batttleship.models.view.AllShipsViewModel;
import com.example.batttleship.models.view.AnotheUserShipsViewModel;
import com.example.batttleship.models.view.CurrentUserShipsViewModel;
import com.example.batttleship.services.ShipService;
import com.example.batttleship.services.impl.UserDetailsIpm;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;

@Controller
public class HomeController {


    private final ShipService shipService;

    public HomeController(ShipService shipService) {
        this.shipService = shipService;
    }

    @GetMapping("/")
    public String index(Model model,
                        @AuthenticationPrincipal UserDetailsIpm user) {
        if (user != null) {
            List<CurrentUserShipsViewModel> currentUserShipsViewModels = shipService.findAllShipsOfCurrentUser(user);
            model.addAttribute("currentUserShips", currentUserShipsViewModels);
            List<AnotheUserShipsViewModel> anotheUserShipsViewModels = shipService.findAnotherUserShips(user);
            model.addAttribute("anotherUserShips", anotheUserShipsViewModels);
            List<AllShipsViewModel> allShipsViewModels = shipService.getAllShips();
            model.addAttribute("allships", allShipsViewModels);
            return "home";
        } else {
            return "index";
        }


    }

}

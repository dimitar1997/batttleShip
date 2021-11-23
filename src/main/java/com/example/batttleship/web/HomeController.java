package com.example.batttleship.web;

import com.example.batttleship.models.view.AllShipsViewModel;
import com.example.batttleship.models.view.AnotheUserShipsViewModel;
import com.example.batttleship.services.ShipService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;

@Controller
public class HomeController {


    private final ShipService shipService;

    public HomeController( ShipService shipService) {
        this.shipService = shipService;
    }

    @GetMapping("/")
    public String index(Model model) {

//        List<CurrentUserShipsViewModel> currentUserShipsViewModels = shipService.findAllShipsOfCurrentUser();
//        model.addAttribute("currentUserShips", currentUserShipsViewModels);
        List<AnotheUserShipsViewModel> anotheUserShipsViewModels = shipService.findAnotherUserShips();
        model.addAttribute("anotherUserShips", anotheUserShipsViewModels);
        List<AllShipsViewModel> allShipsViewModels = shipService.getAllShips();
       model.addAttribute("allships", allShipsViewModels);
        return "index";

    }

}

package com.example.batttleship.web;


import com.example.batttleship.models.biding.AddShipBidingModel;
import com.example.batttleship.models.exceptions.ObjectNotFound;
import com.example.batttleship.models.service.AddShipServiceModel;
import com.example.batttleship.repository.CategoryRepository;
import com.example.batttleship.repository.UserRepository;
import com.example.batttleship.services.ShipService;
import com.example.batttleship.services.impl.UserDetailsIpm;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/ships")
public class ShipController {
    private final UserRepository userRepository;
    private final ShipService shipService;
    private final ModelMapper modelMapper;
    private final CategoryRepository categoryRepository;


    public ShipController(UserRepository userRepository, ShipService shipService, ModelMapper modelMapper, CategoryRepository categoryRepository) {
        this.userRepository = userRepository;
        this.shipService = shipService;
        this.modelMapper = modelMapper;
        this.categoryRepository = categoryRepository;

    }

    @GetMapping("/add")
    public String add(){
        return "ship-add";
    }
    @PostMapping("/add")
    public String addShip(@Valid AddShipBidingModel addShipBidingModel,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes,
     @AuthenticationPrincipal UserDetailsIpm user){
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("addShipBidingModel", addShipBidingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.addShipBidingModel", bindingResult);

            return "redirect:add";
        }
        if (user == null){
            throw new ObjectNotFound();
        }
        AddShipServiceModel addShipServiceModel = modelMapper.map(addShipBidingModel, AddShipServiceModel.class);
        addShipServiceModel.setUser(userRepository.findByUsername(user.getUserIdentifier()).orElse(null));
        addShipServiceModel.setCategory(categoryRepository.findByName(addShipBidingModel.getCategory()).orElse(null));
        shipService.addOrder(addShipServiceModel);
        return "redirect:/";
    }
    @ModelAttribute
    public AddShipBidingModel addShipBidingModel(){
        return new AddShipBidingModel();
    }
}

package com.example.batttleship.web;


import com.example.batttleship.models.biding.AddShipBidingModel;
import com.example.batttleship.models.service.AddShipServiceModel;
import com.example.batttleship.repository.CategoryRepository;
import com.example.batttleship.repository.UserRepository;
import com.example.batttleship.services.ShipService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
//    @PostMapping("/add")
//    public String addShip(@Valid AddShipBidingModel addShipBidingModel,
//                          BindingResult bindingResult,
//                          RedirectAttributes redirectAttributes){
//        if (bindingResult.hasErrors()){
//            redirectAttributes.addFlashAttribute("addShipBidingModel", addShipBidingModel)
//                    .addFlashAttribute("org.springframework.validation.BindingResult.addShipBidingModel", bindingResult);
//
//            return "redirect:add";
//        }
//        AddShipServiceModel addShipServiceModel = modelMapper.map(addShipBidingModel, AddShipServiceModel.class);
//        addShipServiceModel.setUser(userRepository.getById(currentUser.getId()));
//        addShipServiceModel.setCategory(categoryRepository.findByName(addShipBidingModel.getCategory()).orElse(null));
//        shipService.addOrder(addShipServiceModel);
//        return "redirect:/";
//    }
    @ModelAttribute
    public AddShipBidingModel addShipBidingModel(){
        return new AddShipBidingModel();
    }
}
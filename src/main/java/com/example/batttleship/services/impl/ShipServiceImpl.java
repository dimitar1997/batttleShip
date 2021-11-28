package com.example.batttleship.services.impl;


import com.example.batttleship.models.entity.Ship;
import com.example.batttleship.models.entity.User;
import com.example.batttleship.models.service.AddShipServiceModel;
import com.example.batttleship.models.view.AllShipsViewModel;
import com.example.batttleship.models.view.AnotheUserShipsViewModel;
import com.example.batttleship.models.view.CurrentUserShipsViewModel;
import com.example.batttleship.repository.ShipRepository;
import com.example.batttleship.repository.UserRepository;
import com.example.batttleship.services.ShipService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShipServiceImpl implements ShipService {

    private final ShipRepository shipRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    public ShipServiceImpl(ShipRepository shipRepository, ModelMapper modelMapper, UserRepository userRepository) {
        this.shipRepository = shipRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;

    }

    @Override
    public void addOrder(AddShipServiceModel addShipServiceModel) {
        Ship ship = modelMapper.map(addShipServiceModel, Ship.class);
        shipRepository.save(ship);
    }

    @Override
    public List<CurrentUserShipsViewModel> findAllShipsOfCurrentUser(UserDetailsIpm user) {
        User user1 = userRepository.findByUsername(user.getUserIdentifier()).orElseThrow();
        return shipRepository.findAllByUser(user1)
                .stream().map(ship -> modelMapper.map(ship, CurrentUserShipsViewModel.class))
                .collect(Collectors.toList());


    }

    @Override
    public List<AnotheUserShipsViewModel> findAnotherUserShips() {
        long id = userRepository.count();
        //TODO
//        if (currentUser.getId() == id){
//           id-=1;
//        }
        User user = userRepository.getById(id);
        return shipRepository.findAllByUser(user)
                .stream().map(ship -> modelMapper.map(ship, AnotheUserShipsViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<AllShipsViewModel> getAllShips() {
        return shipRepository.findAllByOrderByIdAndHealthPower()
                .stream().map(ship -> modelMapper.map(ship, AllShipsViewModel.class))
                .collect(Collectors.toList());
    }
}

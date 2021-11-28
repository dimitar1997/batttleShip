package com.example.batttleship.services;

import com.example.batttleship.models.service.AddShipServiceModel;
import com.example.batttleship.models.view.AllShipsViewModel;
import com.example.batttleship.models.view.AnotheUserShipsViewModel;
import com.example.batttleship.models.view.CurrentUserShipsViewModel;
import com.example.batttleship.services.impl.UserDetailsIpm;

import java.util.List;

public interface ShipService {
    void addOrder(AddShipServiceModel addShipServiceModel);

    List<AnotheUserShipsViewModel> findAnotherUserShips();

    List<AllShipsViewModel> getAllShips();

    List<CurrentUserShipsViewModel> findAllShipsOfCurrentUser(UserDetailsIpm user);
}

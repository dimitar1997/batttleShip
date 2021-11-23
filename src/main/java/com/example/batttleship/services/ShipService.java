package com.example.batttleship.services;

import com.example.batttleship.models.service.AddShipServiceModel;
import com.example.batttleship.models.view.AllShipsViewModel;
import com.example.batttleship.models.view.AnotheUserShipsViewModel;
import com.example.batttleship.models.view.CurrentUserShipsViewModel;

import java.util.List;

public interface ShipService {
    void addOrder(AddShipServiceModel addShipServiceModel);
    //List<CurrentUserShipsViewModel> findAllShipsOfCurrentUser();

    List<AnotheUserShipsViewModel> findAnotherUserShips();

    List<AllShipsViewModel> getAllShips();
}

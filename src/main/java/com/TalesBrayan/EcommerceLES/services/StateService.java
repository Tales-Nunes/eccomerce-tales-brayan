package com.TalesBrayan.EcommerceLES.services;

import com.TalesBrayan.EcommerceLES.entities.City;
import com.TalesBrayan.EcommerceLES.entities.State;
import com.TalesBrayan.EcommerceLES.repositories.CityRepository;
import com.TalesBrayan.EcommerceLES.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StateService {

    @Autowired
    private StateRepository repository;

    public List<State> findAll(){
        return repository.findAll();
    }

    public State findById(Long id){
        Optional<State> obj = repository.findById(id);
        return obj.get();
    }
}

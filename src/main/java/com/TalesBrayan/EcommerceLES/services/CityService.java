package com.TalesBrayan.EcommerceLES.services;

import com.TalesBrayan.EcommerceLES.entities.Category;
import com.TalesBrayan.EcommerceLES.entities.City;
import com.TalesBrayan.EcommerceLES.repositories.CategoryRepository;
import com.TalesBrayan.EcommerceLES.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    @Autowired
    private CityRepository repository;

    public List<City> findAll(){
        return repository.findAll();
    }

    public City findById(Long id){
        Optional<City> obj = repository.findById(id);
        return obj.get();
    }
}

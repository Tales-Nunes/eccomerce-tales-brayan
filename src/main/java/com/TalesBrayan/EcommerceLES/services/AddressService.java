package com.TalesBrayan.EcommerceLES.services;

import com.TalesBrayan.EcommerceLES.DTOs.ClientDTO;
import com.TalesBrayan.EcommerceLES.entities.*;
import com.TalesBrayan.EcommerceLES.repositories.AddressRepository;
import com.TalesBrayan.EcommerceLES.repositories.CityRepository;
import com.TalesBrayan.EcommerceLES.repositories.PhonesRepository;
import com.TalesBrayan.EcommerceLES.repositories.StateRepository;
import com.TalesBrayan.EcommerceLES.services.exceptions.DatabaseException;
import com.TalesBrayan.EcommerceLES.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AddressService {

    @Autowired
    private AddressRepository repository;

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private CityRepository cityRepository;

    public List<Address> findAll(){
        return repository.findAll();
    }

    public Address findById(Long id){
        Optional<Address> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException((id)));
    }

    public Address insert(Client client, ClientDTO clientDTO){


        clientDTO.getAddress().stream().map(addressDTO -> {
            Address address = new Address();
            address.setCep(addressDTO.getCep());
            address.setAddress(addressDTO.getAddress());
            address.setNumber(addressDTO.getNumber());
            address.setComplement(addressDTO.getComplement());
            City city = cityRepository.findById(addressDTO.getCityId())
                    .orElseThrow(() -> new ResourceNotFoundException("City not found in the specified state"));
            address.setCity(city);
            address.setClient(client);
            return repository.save(address);
        }).collect(Collectors.toList());

        return null;
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException((id));
        } catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    public Address update(Long id, Address obj) {
        try{Address address = repository.getReferenceById(id);
            updateData(address, obj);
            return repository.save(address);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    public void updateData(Address address, Address obj) {
        address.setAddress(obj.getAddress());
    }
}

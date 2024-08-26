package com.TalesBrayan.EcommerceLES.services;

import com.TalesBrayan.EcommerceLES.DTOs.ClientDTO;
import com.TalesBrayan.EcommerceLES.DTOs.PhoneDTO;
import com.TalesBrayan.EcommerceLES.entities.Address;
import com.TalesBrayan.EcommerceLES.entities.Client;
import com.TalesBrayan.EcommerceLES.entities.Phones;
import com.TalesBrayan.EcommerceLES.repositories.PhonesRepository;
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
public class PhonesService {

    @Autowired
    private PhonesRepository repository;

    public List<Phones> findAll(){
        return repository.findAll();
    }

    public Phones findById(Long id){
        Optional<Phones> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException((id)));
    }

    public Phones insert(Client client, ClientDTO clientDTO){


        List<Phones> phones = clientDTO.getPhone().stream().map(phoneDTO -> {
            Phones phone = new Phones();
            phone.setPhone(phoneDTO.getPhone());
            phone.setClient(client);
            return repository.save(phone);
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

    public Phones update(Long id, Phones obj) {
        try{Phones phones = repository.getReferenceById(id);
            updateData(phones, obj);
            return repository.save(phones);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    public void updateData(Phones phones, Phones obj) {
        phones.setPhone(obj.getPhone());
    }
}

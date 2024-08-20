package com.TalesBrayan.EcommerceLES.services;

import com.TalesBrayan.EcommerceLES.entities.Client;
import com.TalesBrayan.EcommerceLES.repositories.ClientRepository;
import com.TalesBrayan.EcommerceLES.services.exceptions.DatabaseException;
import com.TalesBrayan.EcommerceLES.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public List<Client> findAll(){
        return repository.findAll();
    }

    public Client findById(Long id){
        Optional<Client> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException((id)));
    }

    public Client insert(Client obj) {
        return repository.save(obj);
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

    public Client update(Long id, Client obj) {
        try{Client client = repository.getReferenceById(id);
            updateData(client, obj);
            return repository.save(client);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    public void updateData(Client client, Client obj) {
        client.setName(obj.getName());
        client.setCpf(obj.getCpf());
        client.setEmail(obj.getEmail());
        client.setPassword(obj.getPassword());
        client.setPhone(obj.getPhone());
        client.setAddress(obj.getAddress());
        client.setNumber(obj.getNumber());
        client.setComplement(obj.getComplement());
        client.setCity(obj.getCity());
        client.setState(obj.getState());
        client.setCep(obj.getCep());
    }
}

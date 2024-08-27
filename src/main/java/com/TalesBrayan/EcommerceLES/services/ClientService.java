package com.TalesBrayan.EcommerceLES.services;

import com.TalesBrayan.EcommerceLES.DTOs.ClientDTO;
import com.TalesBrayan.EcommerceLES.entities.Address;
import com.TalesBrayan.EcommerceLES.entities.Client;
import com.TalesBrayan.EcommerceLES.entities.Phones;
import com.TalesBrayan.EcommerceLES.entities.enums.TipoClientStatus;
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

    public Client insert(ClientDTO clientDTO) {
        Client client = new Client();
        client.setName(clientDTO.getName());
        client.setCpf(clientDTO.getCpf());
        client.setEmail(clientDTO.getEmail());
        client.setPassword(clientDTO.getPassword());

        return repository.save(client);
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

    public void deactivateClient(Long id) {
        Client client = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found"));
        client.setStatus(TipoClientStatus.INATIVO);
        repository.save(client);
    }

    public void activateClient(Long id) {
        Client client = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found"));
        client.setStatus(TipoClientStatus.ATIVO);
        repository.save(client);
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

        client.getPhone().clear();
        client.getPhone().addAll(obj.getPhone());

        client.getAddress().clear();
        client.getAddress().addAll(obj.getAddress());
    }
}

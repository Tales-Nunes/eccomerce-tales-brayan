package com.TalesBrayan.EcommerceLES.controllers;

import com.TalesBrayan.EcommerceLES.DTOs.ClientDTO;
import com.TalesBrayan.EcommerceLES.entities.Address;
import com.TalesBrayan.EcommerceLES.entities.Client;
import com.TalesBrayan.EcommerceLES.entities.Phones;
import com.TalesBrayan.EcommerceLES.repositories.AddressRepository;
import com.TalesBrayan.EcommerceLES.repositories.PhonesRepository;
import com.TalesBrayan.EcommerceLES.services.AddressService;
import com.TalesBrayan.EcommerceLES.services.ClientService;
import com.TalesBrayan.EcommerceLES.services.PhonesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private PhonesService phonesService;

    @Autowired
    private AddressService addressService;


    @GetMapping
    public ResponseEntity<List<Client>> findAll(){
        List<Client> list = clientService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Client> findById(@PathVariable Long id){
        Client obj = clientService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Client> insert(@RequestBody ClientDTO clientDTO) {
        Client createdClient = clientService.insert(clientDTO);
        phonesService.insert(createdClient, clientDTO);
        addressService.insert(createdClient, clientDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdClient);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivateClient(@PathVariable Long id) {
        clientService.deactivateClient(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/activate")
    public ResponseEntity<Void> activateClient(@PathVariable Long id) {
        clientService.activateClient(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Client>update(@PathVariable Long id, @RequestBody Client obj){
        obj = clientService.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }





}

package com.TalesBrayan.EcommerceLES.controllers;

import com.TalesBrayan.EcommerceLES.DTOs.CardDTO;
import com.TalesBrayan.EcommerceLES.DTOs.ClientDTO;
import com.TalesBrayan.EcommerceLES.entities.Card;
import com.TalesBrayan.EcommerceLES.entities.Client;
import com.TalesBrayan.EcommerceLES.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cards")
public class CardController {

    @Autowired
    private CardService cardService;

    @GetMapping
    public ResponseEntity<List<Card>> findAll(){
        List<Card> list = cardService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Card> findById(@PathVariable Long id){
        Card obj = cardService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping("/{clientId}")
    public ResponseEntity<List<Card>> createCards(
            @PathVariable Long clientId,
            @RequestBody List<CardDTO> cardDTOs) {

        List<Card> cards = cardService.insert(clientId, cardDTOs);
        return ResponseEntity.status(HttpStatus.CREATED).body(cards);
    }
}

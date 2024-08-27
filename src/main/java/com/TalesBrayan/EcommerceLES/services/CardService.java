package com.TalesBrayan.EcommerceLES.services;

import com.TalesBrayan.EcommerceLES.DTOs.CardDTO;
import com.TalesBrayan.EcommerceLES.entities.*;
import com.TalesBrayan.EcommerceLES.repositories.CardRepository;
import com.TalesBrayan.EcommerceLES.repositories.ClientRepository;
import com.TalesBrayan.EcommerceLES.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CardService {

    @Autowired
    private CardRepository repository;

    @Autowired
    private ClientRepository clientRepository;

    public List<Card> findAll(){
        return repository.findAll();
    }

    public Card findById(Long id){
        Optional<Card> obj = repository.findById(id);
        return obj.get();
    }

    public List<Card> insert(Long clientId, List<CardDTO> cardDTOs) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found"));

        List<Card> cards = cardDTOs.stream().map(cardDTO -> {
            Card card = new Card();
            card.setCardNumber(cardDTO.getCardNumber());
            card.setCardNameImpress(cardDTO.getCardNameImpress());
            card.setCardSecurityCode(cardDTO.getCardSecurityCode());
            card.setCardPreference(cardDTO.isCardPreference());
            card.setFlag(cardDTO.getFlag());
            card.setClient(client);

            return card;
        }).collect(Collectors.toList());

        return repository.saveAll(cards);
    }
}


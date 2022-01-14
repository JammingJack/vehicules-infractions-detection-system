package org.enset.immatriculationservice.commands.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.coreapi.commands.CreateProprietaireCommand;
import ma.enset.coreapi.commands.CreateViheculeCommand;
import ma.enset.coreapi.dtos.ProprietaireRequestDto;
import ma.enset.coreapi.dtos.VehiculeRequestDto;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/immatriculation/commands")
public class ImmatriculationCommandSideController {
    private CommandGateway commandGateway;
    private EventStore eventStore;

    @PostMapping("/createProprietaire")
    public CompletableFuture<String> newProprietaire(@RequestBody ProprietaireRequestDto dto){
        CompletableFuture<String> respone = commandGateway.send(new CreateProprietaireCommand(
                UUID.randomUUID().toString(),
                dto.getName(),
                dto.getEmail(),
                dto.getDateNaiss()
        ));
        return respone;
    }

    @PostMapping("/createVehicule")
    public CompletableFuture<String> newVehicule(@RequestBody VehiculeRequestDto dto){
        CompletableFuture<String> respone = commandGateway.send(new CreateViheculeCommand(
                UUID.randomUUID().toString(),
                dto.getNumImmatriculation(),
                dto.getMarque(),
                dto.getPuissanceFiscale(),
                dto.getModele(),
                dto.getPropietaireId()
        ));
        return respone;
    }

}

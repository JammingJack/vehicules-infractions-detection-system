package org.enset.immatriculationservice.commands.aggregates;

import lombok.extern.slf4j.Slf4j;
import ma.enset.coreapi.commands.CreateProprietaireCommand;
import ma.enset.coreapi.commands.CreateViheculeCommand;
import ma.enset.coreapi.events.ProprietaireCreatedEvent;
import ma.enset.coreapi.events.ViheculeCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;


@Aggregate
@Slf4j
public class VehiculeAggregate {
    @AggregateIdentifier
    private String vehiculeId;
    private String numImmatriculation;
    private String marque;
    private double puissanceFiscale;
    private String modele;
    private String proprietaireId;

    public VehiculeAggregate() {
        //required by axon
    }

    @CommandHandler
    public VehiculeAggregate(CreateViheculeCommand command){
        log.info("CreateViheculeCommand");
        AggregateLifecycle.apply(new ViheculeCreatedEvent(
                command.getId(),
                command.getNumImmatriculation(),
                command.getMarque(),
                command.getPuissanceFiscale(),
                command.getModele(),
                command.getPropietaireId()
        ));
    }

    @CommandHandler void handle(CreateProprietaireCommand command){
        log.info("CreateProprietaireCommand");
        AggregateLifecycle.apply(new ProprietaireCreatedEvent(
                command.getId(),
                command.getName(),
                command.getDateNaiss(),
                command.getEmail()
        ));
    }

}

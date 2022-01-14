package ma.enset.coreapi.commands

import org.axonframework.modelling.command.TargetAggregateIdentifier
import java.util.*

abstract class BaseCommand<T>(
        @TargetAggregateIdentifier
        open val id : T
)

data class CreateViheculeCommand(
        override val id: String,
        val numImmatriculation : String,
        val marque : String,
        val puissanceFiscale : Double,
        val modele : String,
        val propietaireId : String

):BaseCommand<String>(id)

data class CreateProprietaireCommand(
        override val id: String,
        val name : String,
        val dateNaiss : String,
        val email : String
):BaseCommand<String>(id)

data class VehiculePasseVitesseLimiteCommand(
        override val id: String,
        val dateInfraction : Date,
        val numRadar : String,
        val matVihecule : String
):BaseCommand<String>(id)

data class CreateInfractureCommand(
        override val id : String,
        val dateInfraction : Date,
        val numRadar : String,
        val matVihecule : String,
        val montantAmende : Double,
):BaseCommand<String>(id)
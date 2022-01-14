

import org.axonframework.modelling.command.TargetAggregateIdentifier

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

):BaseCommand<String>(id)

data class CreateProprietaireCommand(
        override val id: String,
        val name : String,
        val dateNaiss : String,
        val email : String
):BaseCommand<String>(id)

data class VehiculePasseVitesseLimiteCommande(
        override val id: String,
        val dateInfraction : String,
        val numRadar : String,
        val matVihecule : String
):BaseCommand<String>(id)
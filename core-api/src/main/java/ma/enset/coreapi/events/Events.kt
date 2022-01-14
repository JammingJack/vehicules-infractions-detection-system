package ma.enset.coreapi.events

import java.util.*

abstract class BaseEvent<T>(
        open val id : T
)
data class ViheculeCreatedEvent(
        override val id: String,
        val numImmatriculation : String,
        val marque : String,
        val puissanceFiscale : Double,
        val modele : String,
        val propietaireId : String
):BaseEvent<String>(id)

data class ProprietaireCreatedEvent(
        override val id: String,
        val name : String,
        val email : String,
        val dateNaiss : Date,
):BaseEvent<String>(id)

data class ViheculeSurpassedLimiteEvent(
        override val id : String,
        val name : String,
        val email : String
):BaseEvent<String>(id)

data class InfractureCreatedEvent(
        override val id : String,
        val dateInfraction : Date,
        val numRadar : String,
        val matVihecule : String,
        val montantAmende : Double,
):BaseEvent<String>(id)
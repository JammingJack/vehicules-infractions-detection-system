package ma.enset.coreapi.dtos

import java.util.*

data class ProprietaireRequestDto(
        var name : String="",
        var email : String="",
        var dateNaiss : Date = Date(),
)

data class VehiculeRequestDto(
        var id: String="",
        var numImmatriculation : String="",
        var marque : String="",
        var puissanceFiscale : Double=0.0,
        var modele : String="",
        var propietaireId : String=""
)


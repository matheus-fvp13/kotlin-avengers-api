package edu.mfvp.avengers.application.web.request

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

data class AvengerRequest(
    @field:NotBlank
    @field:NotNull
    @field:NotEmpty
    val nick: String,
    @field:NotBlank
    @field:NotNull
    @field:NotEmpty
    val person: String,
    val description: String? = "",
    val history: String? = ""
)

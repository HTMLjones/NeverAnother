package com.example.neveranother.classes.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ProfilViewModel : ViewModel() {

    // Login / Opret bruger
    var email by mutableStateOf("")
    var adgangskode by mutableStateOf("")

    // Profil
    var navn by mutableStateOf("")
    var adresse by mutableStateOf("")
    var telefon by mutableStateOf("")

    // Shipping
    var adresseKomponent by mutableStateOf("")
    var postnummer by mutableStateOf("")

    // Gavekort
    var gaveKort by mutableStateOf("")

    // Målinger
    var omfangOverBryst by mutableStateOf("")
    var omfangUnderBryst by mutableStateOf("")
    var brystbredde by mutableStateOf("")
    var brysthoejde by mutableStateOf("")
    var volumeType by mutableStateOf("")
    var datoForMaal by mutableStateOf("")
}
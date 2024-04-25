package Ventana_1_Funcion

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.application

fun main() = application{
    var verVentanaPrincipal by remember { mutableStateOf(true) }
    var verVentanaSecundaria by remember { mutableStateOf(false) }
    Ventanas()
}
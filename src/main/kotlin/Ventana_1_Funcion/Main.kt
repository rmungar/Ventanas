package Ventana_1_Funcion

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application{
    var estudiante by remember { mutableStateOf("") }
    val students = mutableListOf("Juan", "Victor", "Esther", "Jaime")
    var verVentanaPrincipal by remember { mutableStateOf(true) }
    var verVentanaSecundaria by remember { mutableStateOf(false) }
    var estadoBoton = estudiante.isNotEmpty()
    Window(
       visible = true ,
        onCloseRequest = ::exitApplication
    ){
        Ventanas(estudiante,
            students,
            estadoBoton,
            verVentanaPrincipal,
            verVentanaSecundaria,
            { estudiante = it },
            {students.add(it)}
        )
    }

}
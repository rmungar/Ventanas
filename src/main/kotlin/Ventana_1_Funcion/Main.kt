package Ventana_1_Funcion

import androidx.compose.runtime.*
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import java.io.File

fun main() = application{
    val archivoEstudiantes = File("src/Students.txt")
    var estudiante by remember { mutableStateOf("") }
    var added =  mutableListOf("")
    val students = archivoEstudiantes.useLines { it.toMutableList() }
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
            { added.add(it) },
            {
                added.forEach {
                    archivoEstudiantes.appendText("\n$it")
                }
            },
            {
                archivoEstudiantes.delete()
                archivoEstudiantes.createNewFile()
            }
        )
    }

}
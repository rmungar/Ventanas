package Ventana_1_Funcion

import androidx.compose.runtime.*
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import java.io.File

fun main() = application{
    val archivoEstudiantes = File("src/Students.txt")
    var estudiante by remember { mutableStateOf("") }
    val added =  mutableListOf("")
    val students = archivoEstudiantes.useLines { it.toMutableList() }
    var verVentanaPrincipal by remember { mutableStateOf(true) }
    var verVentanaSecundaria by remember { mutableStateOf(false) }
    val estadoBoton = estudiante.isNotEmpty()
    var user by remember { mutableStateOf("") }
    var psswd by remember { mutableStateOf("") }
    val estadoBotonLogin = user.isNotBlank() && psswd.isNotBlank()
    val psswdVisible by remember { mutableStateOf(false)}


    Window(
       visible = true ,
        onCloseRequest = ::exitApplication
    ){
        Ventanas(
            user,
            psswd,
            psswdVisible,
            estudiante,
            students,
            estadoBoton,
            estadoBotonLogin,
            verVentanaPrincipal,
            verVentanaSecundaria,
            onEntrada = { estudiante = it },
            onClick = { added.add(it) },
            onSave = {
                added.forEach {
                    archivoEstudiantes.appendText("\n$it")
                }
                verVentanaPrincipal = true
                verVentanaSecundaria = false
            },
            onDelete = {
                archivoEstudiantes.delete()
                archivoEstudiantes.createNewFile()
            },
            onEntrada1 = {user = it },
            onEntrada2 = {psswd = it},
            onLogin = {
                verVentanaPrincipal = false
                verVentanaSecundaria = true
                user = ""
                psswd = ""
            },
            {
                val lista = archivoEstudiantes.useLines { it.toMutableList() }
                lista.remove(it)
            }
        )
    }

}
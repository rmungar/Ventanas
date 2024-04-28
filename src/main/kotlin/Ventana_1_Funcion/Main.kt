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
    var user by remember { mutableStateOf("") }
    var psswd by remember { mutableStateOf("") }
    var estadoBotonLogin = user.isNotBlank() && psswd.isNotBlank()
    var psswdVisible by remember { mutableStateOf(false)}
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
            { estudiante = it },
            { added.add(it) },
            {
                added.forEach {
                    archivoEstudiantes.appendText("\n$it")
                }
                verVentanaPrincipal = true
                verVentanaSecundaria = false
            },
            {
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
            }
        )
    }

}
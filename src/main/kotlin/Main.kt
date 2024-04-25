import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.application


fun main() = application {
    var verVentanaPrincipal by remember { mutableStateOf(true) }
    var verVentanaSecundaria by remember { mutableStateOf(false) }
    if (verVentanaPrincipal && !verVentanaSecundaria){
        Ventana1(
            verVentanaPrincipal = verVentanaPrincipal,
            verVentanaSecundaria = verVentanaSecundaria,
            { exitApplication() },

        ){
            verVentanaPrincipal = false
            verVentanaSecundaria = true
        }
    }
    else{
        Ventana2(
            verVentanaPrincipal = verVentanaPrincipal,
            verVentanaSecundaria = verVentanaSecundaria,
            { exitApplication() },
        ){
            verVentanaPrincipal = true
            verVentanaSecundaria = false
        }
    }

}


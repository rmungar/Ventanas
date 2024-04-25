package Ventana_2_Funciones

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window

@Composable
@Preview
fun Ventana1(verVentanaPrincipal: Boolean, verVentanaSecundaria: Boolean, onClose: () -> Unit, onClick:() -> Unit){
    if (verVentanaPrincipal){
        Window(
            onCloseRequest = { onClose() },
            resizable = true
        ){
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Spacer(modifier = Modifier.size(50.dp))
                Text(
                    text = "Esta es la ventana principal",
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.size(100.dp))
                Button(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally),
                    onClick = {
                        onClick()
                    }
                ){
                    Text("Abrir Ventana Secundaria")
                }
                if (verVentanaSecundaria){
                    Ventana2(verVentanaPrincipal, verVentanaSecundaria, onClose, onClick)
                }
            }

        }
    }

}
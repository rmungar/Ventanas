import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.singleWindowApplication
import kotlin.math.truncate

@Composable
fun Ventana2(verVentanaPrincipal: Boolean, verVentanaSecundaria: Boolean, onClose: () -> Unit, onclick:()->Unit){
    if (verVentanaSecundaria){
        Window(
            onCloseRequest = { onClose() },
            resizable = true
        ){
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Spacer(modifier = Modifier.size(50.dp))
                Text(text = "Esta es la ventana secundaria",
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally))
                Spacer(modifier = Modifier.size(100.dp))
                Button(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally),
                    onClick = {onclick()}
                ){
                    Text("Abrir Ventana Principal")
                }
                if (verVentanaPrincipal){
                    Ventana1(verVentanaPrincipal, verVentanaSecundaria, onClose, onclick)
                }
            }

        }
    }

}
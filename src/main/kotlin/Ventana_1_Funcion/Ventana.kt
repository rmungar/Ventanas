package Ventana_1_Funcion

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.unit.dp


@Preview
@Composable
fun Ventanas(estudiante:String, students: MutableList<String>, estadoBoton:Boolean, verVentanaPrincipal: Boolean, verVentanaSecundaria: Boolean,onEntrada : (String) -> Unit, onClick: (String) -> Unit){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ){
        OutlinedTextField(
            value = estudiante,
            placeholder ={ Text("Nombre del estudiante")},
            onValueChange = {
                onEntrada(it)
            },
            label = { Text("Estudiante")},
            modifier = Modifier
                .align(Alignment.Center)
        )
        Button(
            onClick = {
                      onClick(estudiante)
                 },
            enabled = estadoBoton,
            modifier = Modifier
                .size(100.dp, 50.dp)
        ){
            Text("AÑADIR")
        }
    }
}
package Ventana_1_Funcion

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Preview
@Composable
fun Ventanas(
    estudiante: String,
    students: MutableList<String>,
    estadoBoton: Boolean,
    verVentanaPrincipal: Boolean,
    verVentanaSecundaria: Boolean,
    onEntrada: (String) -> Unit,
    onClick: (String) -> Unit,
    onSave: () -> Unit,
    onDelete: () -> Unit
){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ){
        Row {
            Column (
                modifier = Modifier
                    .fillMaxWidth(0.5F)
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){
                OutlinedTextField(
                    value = estudiante,
                    placeholder ={ Text("Nombre del estudiante")},
                    onValueChange = {
                        onEntrada(it)
                    },
                    label = { Text("Estudiante")},
                    modifier = Modifier
                )
                Spacer(modifier = Modifier.size(50.dp))
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
            Column (
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){
                Column(
                    modifier = Modifier
                        .border(2.dp, Color.Black)
                        .wrapContentWidth()
                        .wrapContentSize()
                ) {
                    for (estudiante in students){
                        OutlinedTextField(
                            modifier = Modifier
                                .wrapContentSize()
                                .background(Color.White),
                            value = estudiante,
                            enabled = false,
                            onValueChange = {},
                            trailingIcon = {
                                IconButton(
                                    enabled = true,
                                    onClick = {
                                    }
                                ){
                                    Icon(imageVector = Icons.Default.Delete, "Eliminar Estudiante")
                                }
                            }
                        )
                    }
                }
                Spacer(modifier = Modifier.size(50.dp))
                Button(
                    onClick = {
                        onDelete()
                    },
                    enabled = true,
                    modifier = Modifier
                        .size(100.dp, 50.dp)
                ){
                    Text("VACIAR")
                }
            }
        }
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter),
        ) {
            Button(
                modifier = Modifier
                    .align(Alignment.CenterVertically),
                onClick = {
                          onSave()
                },


            ){
                Text("GUARDAR CAMBIOS")
            }
            Spacer(Modifier.size(10.dp))
        }


    }
}
package Ventana_1_Funcion

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogWindow
import kotlinx.coroutines.delay


@Preview
@Composable
fun Ventanas(
    user:String,
    psswd: String,
    psswdVisible: Boolean,
    estudiante: String,
    students: MutableList<String>,
    estadoBoton: Boolean,
    estadoBotonLogin: Boolean,
    verVentanaPrincipal: Boolean,
    verVentanaSecundaria: Boolean,
    onEntrada: (String) -> Unit,
    onAgregar: (String) -> Unit,
    onSave: () -> Unit,
    onDelete: () -> Unit,
    onEntrada1: (String) -> Unit,
    onEntrada2: (String) -> Unit,
    onLogin: () -> Unit,
    onBorrar: (String) -> Unit,
    showInfoMensaje : Boolean,
    onDismiss: () -> Unit
){
    var infoMessage by remember { mutableStateOf("") }
    var showInfoMessage by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ){
        if (showInfoMessage) {
            InfoMensaje(
                mensaje = infoMessage,
                onDismiss = {
                    showInfoMessage = true
                    infoMessage = ""
                }
            )
        }
        LaunchedEffect(showInfoMessage) {
            if (showInfoMessage) {
                delay(2000)
                showInfoMessage = false
                infoMessage = ""
            }
        }
        if (verVentanaPrincipal && !verVentanaSecundaria){
            Login(user, onEntrada1, psswd, psswdVisible, onEntrada2, estadoBotonLogin, onLogin)
        }
        else{
            Students(estudiante, onEntrada, students, estadoBoton, onBorrar, onDelete)
            Spacer(modifier = Modifier.size(50.dp))
            Guardar(onSave)
        }


    }


    // Automáticamente oculta el mensaje después de un retraso

}
@Composable
fun Usuario(
    user: String,
    onEntrada : (String) -> Unit
){
    OutlinedTextField(
        value = user,
        placeholder = { Text("Nombre de usuario") },
        onValueChange = { onEntrada(it) },
        label = { Text("Usuario")}
    )
}

@Composable
fun Psswd(psswd: String, psswdVisible: Boolean, onEntrada2: (String) -> Unit){
    OutlinedTextField(
        value = psswd,
        placeholder = { Text("Contraseña") },
        visualTransformation = if (psswdVisible) VisualTransformation.None else PasswordVisualTransformation(),
        onValueChange = {onEntrada2(it)},
        label = { Text("Contraseña")},
        trailingIcon = {
            IconToggleButton(
                checked = psswdVisible,
                onCheckedChange = {!psswdVisible}
            ){
                Icon(
                    imageVector = if (psswdVisible) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                    contentDescription = null
                )
            }
        }
    )
}

@Composable
fun Boton(estadoBoton: Boolean, onLogin: () -> Unit){
    Button(
        onClick = {
            onLogin() },
        enabled = estadoBoton,
        modifier = Modifier
            .size(100.dp, 50.dp)
    ){
        Text("LOGIN")
    }
}


@Composable
fun Login(user: String, onEntrada1: (String) -> Unit, psswd: String, psswdVisible: Boolean, onEntrada2: (String) -> Unit, estadoBotonLogin: Boolean, onLogin: () -> Unit){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){

        Usuario(user,onEntrada1)

        Spacer(modifier = Modifier.size(10.dp))

        Psswd(psswd, psswdVisible, onEntrada2)

        Spacer(modifier = Modifier.size(10.dp))

        Boton(estadoBotonLogin, onLogin)
    }
}

@Composable
fun Students(estudiante: String, onEntrada: (String) -> Unit, students: MutableList<String>, estadoBoton: Boolean, onBorrar: (String) -> Unit, onDelete: () -> Unit){
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
                    students.add(estudiante)
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
            LazyColumn(
                modifier = Modifier
                    .border(2.dp, Color.Black)
                    .wrapContentWidth()
                    .size(225.dp),

                ) {
                items(students.size){ x ->
                    OutlinedTextField(
                        modifier = Modifier
                            .wrapContentSize()
                            .background(Color.White),
                        value = students[x],
                        enabled = false,
                        onValueChange = {},
                        trailingIcon = {
                            IconButton(
                                enabled = true,
                                onClick = {
                                    onBorrar(students[x])
                                }
                            ){
                                Icon(imageVector = Icons.Default.Delete, "Eliminar Estudiante")
                            }
                        }
                    )
                }
            }
            Spacer(modifier = Modifier.size(50.dp))
            Vaciar(onDelete)
        }
    }
}

@Composable
fun Guardar(onSave: () -> Unit  ){
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ){
        Button(
            modifier = Modifier
                .align(Alignment.Center),
            onClick = {
                onSave()
            }
            ){
            Text("GUARDAR CAMBIOS\n          Y SALIR")
        }
    }
}

@Composable
fun Vaciar(onDelete: () -> Unit){
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

@Composable
fun InfoMensaje(mensaje:String, onDismiss: () -> Unit){
    DialogWindow(
        icon = painterResource("atencion-1.png")    ,
        title = "ATENCION",
        resizable = false,
        onCloseRequest = onDismiss
    ){
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize().padding(16.dp)
        ){
            Text(mensaje)
        }
    }

}
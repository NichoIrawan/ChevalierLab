package org.chevalier.cheva3.screens

import android.util.Patterns
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.chevalier.cheva3.R
import org.chevalier.cheva3.components.CustomTextFieldBox

@Composable
fun LoginScreen (modifier: Modifier = Modifier) {

    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordState by remember { mutableStateOf(false) }
    var error by remember { mutableStateOf(true) }

    val context = LocalContext.current

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = stringResource(R.string.Register),
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight(500),
            )
        )

        Box(modifier = Modifier.size(4.dp))

        Text(
            text = stringResource(R.string.Register_sub_heading)
        )

        Box(modifier = Modifier.size(16.dp))

        CustomTextFieldBox(
            label = stringResource(R.string.Username),
            hint = stringResource(R.string.Username),
            value = username,
            onValueChanged = { text ->
                username = text
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Username"
                )
            },
            show = true,
        )

        CustomTextFieldBox(
            label = stringResource(R.string.Email),
            hint = stringResource(R.string.Email),
            value = email,
            onValueChanged = {
                text -> email = text
                error = !Patterns.EMAIL_ADDRESS.matcher(email).matches()
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "Email"
                )
            },
            show = true,
            isEmail = true,
        )

        CustomTextFieldBox(
            label = stringResource(R.string.Password),
            hint = stringResource(R.string.Password),
            value = password,
            onValueChanged = { text ->
                password = text
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "Password"
                )
            },
            show = passwordState,
            trailingIcon = {
                IconButton(onClick = {passwordState = !passwordState}) {
                    Icon(
                        painter = painterResource(R.drawable.baseline_remove_red_eye_24),
                        contentDescription = "Password State",
                    )
                }
            }
        )

        Button(
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(colorResource(R.color.purple_500)),
            onClick = {
                var text: String

                if (!error) text = "Berhasil registrasi"
                else text = "Terdapat error"

                Toast.makeText(context,text, Toast.LENGTH_SHORT).show()
            }
        ) {
            Text(
                text = stringResource(R.string.Register)
            )
        }
    }
}
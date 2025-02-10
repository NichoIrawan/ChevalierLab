package org.chevalier.cheva3.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import org.chevalier.cheva3.R
import org.chevalier.cheva3.components.CustomTextFieldBox

@Composable
fun LoginScreen (modifier: Modifier = Modifier) {

    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordState by remember { mutableStateOf(false) }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = stringResource(R.string.Register)
        )

        Text(
            text = stringResource(R.string.Register_sub_heading)
        )

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
            onValueChanged = { text ->
                email = text
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "Email"
                )
            },
            show = true,
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
            show = passwordState
        )

        Button(
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.secondary),
            onClick = {}
        ) {
            Text(
                text = stringResource(R.string.Register)
            )
        }
    }
}
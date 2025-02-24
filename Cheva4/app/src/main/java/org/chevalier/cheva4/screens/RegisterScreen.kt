package org.chevalier.cheva4.screens

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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.chevalier.cheva4.R
import org.chevalier.cheva4.component.CustomTextField
import org.chevalier.cheva4.viewmodel.RegisterViewModel

@Composable
fun RegisterScreen (
    modifier: Modifier = Modifier,
    viewModel: RegisterViewModel
) {
    val username by viewModel.username.collectAsState()
    val email by viewModel.email.collectAsState()
    val password by viewModel.password.collectAsState()
    val passwordState by viewModel.passwordState.collectAsState()

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

        CustomTextField(
            label = stringResource(R.string.Username),
            hint = stringResource(R.string.Username),
            value = username,
            onValueChanged = { text ->
                viewModel.updateUsername(text)
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Username"
                )
            },
            show = true,
        )

        CustomTextField(
            label = stringResource(R.string.Email),
            hint = stringResource(R.string.Email),
            value = email,
            onValueChanged = { text ->
                viewModel.updateEmail(text)
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

        CustomTextField(
            label = stringResource(R.string.Password),
            hint = stringResource(R.string.Password),
            value = password,
            onValueChanged = { text ->
                viewModel.updatePassword(text)
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "Password"
                )
            },
            show = passwordState,
            trailingIcon = {
                IconButton (
                    onClick = {viewModel.updatePasswordState()}
                ) {
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
                val text: String = viewModel.checkError()

                Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
            }
        ) {
            Text(
                text = stringResource(R.string.Register)
            )
        }
    }
}
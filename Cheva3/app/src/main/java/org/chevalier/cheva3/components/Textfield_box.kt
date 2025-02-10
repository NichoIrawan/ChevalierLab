package org.chevalier.cheva3.components

import android.util.Patterns
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun CustomTextFieldBox (
    modifier: Modifier = Modifier,
    label: String,
    hint: String,
    value: String,
    onValueChanged: (String) -> Unit,
    leadingIcon: @Composable (() -> Unit),
    trailingIcon: @Composable (() -> Unit) = { },
    isEmail: Boolean = false,
    show: Boolean,
) {
    Column (
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
    ){
        Text(
            text = label,
            style = MaterialTheme.typography.labelLarge
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = value,
            onValueChange = onValueChanged,
            leadingIcon = leadingIcon,
            placeholder = {
                Text(text = hint)
            },
            visualTransformation =
                if (show) VisualTransformation.Companion.None
                else PasswordVisualTransformation(),
            trailingIcon = trailingIcon,
            isError =
                if (!isEmail) false
                else !Patterns.EMAIL_ADDRESS.matcher(value).matches(),

        )

        Box(modifier = Modifier.size(16.dp))
    }
}
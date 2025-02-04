package org.chevalier.cheva3.components

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun CustomTextFieldBox (
    modifier: Modifier = Modifier,
    label: String,
    hint: String,
    value: String,
    onValueChanged: (String) -> Unit,
    leadingIcon: @Composable (() -> Unit),
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
            }
        )
    }
}
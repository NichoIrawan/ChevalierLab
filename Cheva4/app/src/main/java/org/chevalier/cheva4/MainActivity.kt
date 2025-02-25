package org.chevalier.cheva4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import org.chevalier.cheva4.screens.RegisterScreen
import org.chevalier.cheva4.ui.theme.Cheva4Theme
import org.chevalier.cheva4.viewmodel.RegisterViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel = viewModel<RegisterViewModel>()
            val state by viewModel.state.collectAsStateWithLifecycle()

            Cheva4Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RegisterScreen(
                        modifier = Modifier.padding(innerPadding),
                        state = state,
                        onEvent = viewModel::onEvent
                    )
                }
            }
        }
    }
}
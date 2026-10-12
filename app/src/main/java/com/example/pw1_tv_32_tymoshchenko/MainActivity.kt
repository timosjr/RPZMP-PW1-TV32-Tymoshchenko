package com.example.pw1_tv_32_tymoshchenko

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.pw1_tv_32_tymoshchenko.composables.AdvancedMicrogridApp
import com.example.pw1_tv_32_tymoshchenko.composables.AdvancedMicrogridApp
import com.example.pw1_tv_32_tymoshchenko.composables.AuthScreen
import com.example.pw1_tv_32_tymoshchenko.ui.theme.PW1_TV32_TymoshchenkoTheme

/**
 * Головна активність застосунку, яка керує станом авторизації та переходом до екранів енергосистеми.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PW1_TV32_TymoshchenkoTheme() {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Стан для перемикання між екраном авторизації та головним робочим екраном
                    var isAuthenticated by remember { mutableStateOf(false) }

                    if (!isAuthenticated) {
                        // Відображаємо екран входу/реєстрації (ПЗ №4)
                        AuthScreen(
                            onAuthSuccess = {
                                isAuthenticated = true
                            }
                        )
                    } else {
                        // Після успішного входу відкриваємо головний екран розрахунків мікрогріду
                        AdvancedMicrogridApp()
                    }
                }
            }
        }
    }
}
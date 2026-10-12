package com.example.pw1_tv_32_tymoshchenko.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pw1_tv_32_tymoshchenko.R

@Composable
fun AdvancedMicrogridApp() {
    // Стан для режимів роботи мікрогріду (Середній/Просунутий рівень взаємодії)
    var selectedMode by remember { mutableStateOf("Денний (Генерація)") }
    var forecastPower by remember { mutableStateOf(1500) }
    var systemComment by remember { mutableStateOf("Максимальна ефективність сонячних панелей.") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Базовий рівень: Текстовий заголовок екрану
        Text(
            text = "Мікрогрід з ВДЕ - Прогноз потужності",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary
        )

        // Середній рівень: Панель кнопок перемикання режимів у рядку (Row)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = {
                selectedMode = "Денний (Генерація)"
                forecastPower = 1800
                systemComment = "Стабільна робота сонячних модулів."
            }) {
                Text("Денні")
            }

            Button(onClick = {
                selectedMode = "Нічний (АКБ)"
                forecastPower = 200
                systemComment = "Живлення від накопичувачів енергії."
            }) {
                Text("Нічні")
            }

            Button(onClick = {
                selectedMode = "Хмарний (Зниження)"
                forecastPower = 600
                systemComment = "Обмежена генерація через погодні умови."
            }) {
                Text("Хмарні")
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Базовий/Просунутий рівень: Відображення зображення (сол. панель / іконка)
        // Якщо у вас немає унікальної картинки в drawable, можна використати дефолтну або іконку
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {

                Image(
                    painter = painterResource(id = R.drawable.battary),
                    contentDescription = "Акумулятор мікрогріду",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Просунутий рівень: Детальна інформаційна картка з динамічним станом
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(text = "Режим роботи: $selectedMode", fontSize = 16.sp, color = MaterialTheme.colorScheme.secondary)
                Text(text = "Прогнозована потужність: $forecastPower кВт", fontSize = 18.sp, color = Color.Black)

                Divider(color = Color.LightGray, thickness = 1.dp)

                Text(
                    text = "Коментар: $systemComment",
                    fontSize = 14.sp,
                    color = Color.DarkGray
                )
            }
        }
    }
}
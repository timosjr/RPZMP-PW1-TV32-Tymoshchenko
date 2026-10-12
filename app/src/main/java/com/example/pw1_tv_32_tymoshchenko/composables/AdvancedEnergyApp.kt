package com.example.pw1_tv_32_tymoshchenko.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pw1_tv_32_tymoshchenko.model.MicrogridCalculator

@Composable
fun AdvancedEnergyApp() {
    // Змінні стану для кількох параметрів мікрогріду (Варіант 19)
    var solarInput by remember { mutableStateOf("") }       // Генерація ВДЕ (Вт)
    var loadInput by remember { mutableStateOf("") }         // Навантаження (Вт)
    var batteryInput by remember { mutableStateOf("") }     // Ємність АКБ (Вт*год)
    var calculationResult by remember { mutableStateOf("Введіть параметри для аналізу балансу") }

    val calculator = MicrogridCalculator()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Просунутий рівень: Мікрогрід з ВДЕ (ПЗ №2)",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary
        )

        // Поле 1: Генерація ВДЕ
        TextField(
            value = solarInput,
            onValueChange = { solarInput = it },
            label = { Text("Генерація ВДЕ (Вт)") },
            modifier = Modifier.fillMaxWidth()
        )

        // Поле 2: Навантаження
        TextField(
            value = loadInput,
            onValueChange = { loadInput = it },
            label = { Text("Поточне навантаження (Вт)") },
            modifier = Modifier.fillMaxWidth()
        )

        // Поле 3: Ємність батареї
        TextField(
            value = batteryInput,
            onValueChange = { batteryInput = it },
            label = { Text("Ємність накопичувача АКБ (Вт*год)") },
            modifier = Modifier.fillMaxWidth()
        )

        // Кнопка запуску розрахунку через окремий клас бізнес-логіки
        Button(
            onClick = {
                calculationResult = calculator.calculateAdvancedBalance(solarInput, loadInput, batteryInput)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Виконати розрахунок балансу")
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Відображення результату
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
        ) {
            Text(
                text = calculationResult,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}
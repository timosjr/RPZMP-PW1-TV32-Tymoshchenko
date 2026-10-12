package com.example.pw1_tv_32_tymoshchenko.model

import kotlin.random.Random

/**
 * Клас бізнес-логіки для управління станом та розрахунками мікрогріду (Варіант 19).
 */
class MicrogridState {
    var solarPower: Float = 850.0f
        private set

    var loadPower: Float = 600.0f
        private set

    var isOptimized: Boolean = true
        private set

    /**
     * Метод оновлення показників енергосистеми (симуляція роботи датчиків ВДЕ).
     */
    fun updateMetrics() {
        solarPower = Random.nextFloat() * 1500f + 200f
        loadPower = Random.nextFloat() * 1000f + 300f
        isOptimized = solarPower >= loadPower
    }
}
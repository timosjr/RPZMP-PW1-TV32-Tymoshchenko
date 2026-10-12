package com.example.pw1_tv_32_tymoshchenko.model

/**
 * Клас бізнес-логіки для просунутих розрахунків мікрогріду (Варіант 19).
 * Винесено в окремий пакет згідно з вимогами Практичного заняття №2.
 */
class MicrogridCalculator {

    /**
     * Комплексний розрахунок балансу потужності мікрогріду.
     * @param solarGen Рівень генерації ВДЕ (Вт)
     * @param currentLoad Поточне навантаження (Вт)
     * @param batteryCapacity Ємність накопичувача (Вт*год)
     * @return Текстовий звіт про стан енергосистеми та ефективність
     */
    fun calculateAdvancedBalance(solarGen: String, currentLoad: String, batteryCapacity: String): String {
        val solar = solarGen.toDoubleOrNull() ?: 0.0
        val load = currentLoad.toDoubleOrNull() ?: 0.0
        val battery = batteryCapacity.toDoubleOrNull() ?: 0.0

        val balance = solar - load
        val efficiencyMetric = if (load > 0) (solar / load) * 100.0 else 0.0

        return if (balance >= 0) {
            "Статус: НАДЛИШОК ЕНЕРГІЇ (+${balance.toInt()} Вт). Ефективність: ${efficiencyMetric.toInt()}%. Накопичувач заряджається."
        } else {
            "Статус: ДЕФІЦИТ ПОТУЖНОСТІ (${balance.toInt()} Вт). Задіяно резерв АКБ (${battery.toInt()} Вт*год)."
        }
    }
}
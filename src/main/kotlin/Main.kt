package ru.netology

fun main() {
    println(finalCommission("VK Pay", 40_000.0, 15_100.0))
}

fun finalCommission(paymentType: String = "VK Pay", totalThisMonth: Double, transactionSum: Double): Double {
    // задаем ограничения для типов платежных систем
    val cardLimitPerDay = 150_000.0
    val cardLimitPerMonth = 600_000.0
    val vkPayLimitPerTransaction = 15_000.0
    val vkPayLimitPerMonth = 40_000.0
    var calculation = 0.0
    calculation = if (totalThisMonth < cardLimitPerMonth && transactionSum <= cardLimitPerDay) {
        when (paymentType) {
            "Mastercard" -> if (transactionSum in 300.0..75000.0) 0.0 else 0.006 * transactionSum + 20.0
            "Maestro" -> if (transactionSum in 300.0..75000.0) 0.0 else 0.006 * transactionSum + 20.0
            "Visa" -> if (transactionSum * 0.0075 < 35.0) 35.0 else 0.0075 * transactionSum
            "Мир" -> if (transactionSum * 0.0075 < 35.0) 35.0 else 0.0075 * transactionSum
            "VK Pay" -> if (transactionSum <= vkPayLimitPerTransaction &&   totalThisMonth <= vkPayLimitPerMonth) 0.0 else -99999.0
            else -> 0.0
        }
    } else {
        -99998.0
    }
    return calculation
}



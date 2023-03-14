import org.junit.Test

import org.junit.Assert.*
import ru.netology.finalCommission

class MainKtTest {

    @Test
    fun finalCommission() {
        val ttlThisMonth = 40_000.0
        val trSum = 14_000.0
        val paymentT = "VK Pay"
        val result = finalCommission(
            paymentType = paymentT,
            totalThisMonth = ttlThisMonth,
            transactionSum = trSum
        )
        assertEquals(0.0, result,0.001)
    }
    @Test
    fun finalCommissionMcDefaultCommission() {
        val ttlThisMonth = 40_000.0
        val trSum = 74_000.0
        val paymentT = "Mastercard"
        val result = finalCommission(
            paymentType = paymentT,
            totalThisMonth = ttlThisMonth,
            transactionSum = trSum
        )
        assertEquals(0.0, result, 0.001)
    }
    @Test
    fun finalCommissionMcCalculatedCommission() {
        val ttlThisMonth = 40_000.0
        val trSum = 76_000.0
        val paymentT = "Mastercard"
        val result = finalCommission(
            paymentType = paymentT,
            totalThisMonth = ttlThisMonth,
            transactionSum = trSum
        )
        assertEquals(476.0, result, 0.001)
    }
    @Test
    fun finalCommissionMaestroDefaultCommission() {
        val ttlThisMonth = 40_000.0
        val trSum = 74_000.0
        val paymentT = "Maestro"
        val result = finalCommission(
            paymentType = paymentT,
            totalThisMonth = ttlThisMonth,
            transactionSum = trSum
        )
        assertEquals(0.0, result, 0.001)
    }
    @Test
    fun finalCommissionMaestroCalculatedCommission() {
        val ttlThisMonth = 40_000.0
        val trSum = 76_000.0
        val paymentT = "Maestro"
        val result = finalCommission(
            paymentType = paymentT,
            totalThisMonth = ttlThisMonth,
            transactionSum = trSum
        )
        assertEquals(476.0, result, 0.001)
    }
    @Test
    fun finalCommissionVisaDefaultCommission() {
        val ttlThisMonth = 40_000.0
        val trSum = 1_000.0
        val paymentT = "Visa"
        val result = finalCommission(
            paymentType = paymentT,
            totalThisMonth = ttlThisMonth,
            transactionSum = trSum
        )
        assertEquals(35.0, result, 0.001)
    }
    @Test
    fun finalCommissionVisaCalculatedCommission() {
        val ttlThisMonth = 40_000.0
        val trSum = 50_000.0
        val paymentT = "Visa"
        val result = finalCommission(
            paymentType = paymentT,
            totalThisMonth = ttlThisMonth,
            transactionSum = trSum
        )
        assertEquals(375.0, result, 0.001)
    }
    @Test
    fun finalCommissionMirDefaultCommission() {
        val ttlThisMonth = 40_000.0
        val trSum = 1_000.0
        val paymentT = "Мир"
        val result = finalCommission(
            paymentType = paymentT,
            totalThisMonth = ttlThisMonth,
            transactionSum = trSum
        )
        assertEquals(35.0, result, 0.001)
    }
    @Test
    fun finalCommissionMirCalculatedCommission() {
        val ttlThisMonth = 40_000.0
        val trSum = 50_000.0
        val paymentT = "Мир"
        val result = finalCommission(
            paymentType = paymentT,
            totalThisMonth = ttlThisMonth,
            transactionSum = trSum
        )
        assertEquals(375.0, result, 0.001)
    }
    @Test
    fun finalCommissionDefault() {
        val ttlThisMonth = 30_000.0
        val trSum = 1_000.0
        val result = finalCommission(
            totalThisMonth = ttlThisMonth,
            transactionSum = trSum
        )
        assertEquals(0.0, result, 0.001)
    }
    @Test
    fun finalCommissionBrakeMonthLimit() {
        val ttlThisMonth = 610_000.0
        val trSum = 1_000.0
        val paymentT = "Мир"
        val result = finalCommission(
            paymentType = paymentT,
            totalThisMonth = ttlThisMonth,
            transactionSum = trSum
        )
        assertEquals(-99998.0, result, 0.001)
    }
    @Test
    fun finalCommissionBrakeDayLimit() {
        val ttlThisMonth = 60_000.0
        val trSum = 160_000.0
        val paymentT = "Мир"
        val result = finalCommission(
            paymentType = paymentT,
            totalThisMonth = ttlThisMonth,
            transactionSum = trSum
        )
        assertEquals(-99998.0, result, 0.001)
    }
    @Test
    fun finalCommissionBrakeVkPayTransactionLimit() {
        val ttlThisMonth = 35_000.0
        val trSum = 16_000.0
        val paymentT = "VK Pay"
        val result = finalCommission(
            paymentType = paymentT,
            totalThisMonth = ttlThisMonth,
            transactionSum = trSum
        )
        assertEquals(-99999.0, result, 0.001)
    }
    @Test
    fun finalCommissionBrakeVkPayMonthLimit() {
        val ttlThisMonth = 41_000.0
        val trSum = 13_000.0
        val paymentT = "VK Pay"
        val result = finalCommission(
            paymentType = paymentT,
            totalThisMonth = ttlThisMonth,
            transactionSum = trSum
        )
        assertEquals(-99999.0, result, 0.001)
    }
}
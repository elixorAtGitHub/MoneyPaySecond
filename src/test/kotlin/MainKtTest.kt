import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun comission_visa() {
        val ammount = 10000
        val previous = 60000
        val typeCard = TYPE_VISA

        val result = comission(typeCard, ammount, previous)

        assertEquals(75, result)
    }

    @Test
    fun comission_mir_error() {
        val ammount = 5000
        val previous = 50000
        val typeCard = TYPE_MIR

        val result = comission(typeCard, ammount, previous)

        assertEquals(37, result)
    }

    @Test
    fun comission_visa_error() {
        val ammount = 10_000_000
        val previous = 60000
        val typeCard = TYPE_VISA

        val result = comission(typeCard, ammount, previous)

        assertEquals(-2, result)
    }


    @Test
    fun comission_mir() {
        val ammount = 50_000_000
        val previous = 0
        val typeCard = TYPE_MIR

        val result = comission(typeCard, ammount, previous)

        assertEquals(-2, result)
    }

    @Test
    fun comission_mastercard() {
        val ammount = 5000
        val previous = 50000
        val typeCard = TYPE_MASTERCARD

        val result = comission(typeCard, ammount, previous)

        assertEquals(0, result)
    }

    @Test
    fun comission_mastercard_error() {
        val ammount = 99_999_999
        val previous = 50000
        val typeCard = TYPE_MASTERCARD

        val result = comission(typeCard, ammount, previous)

        assertEquals(-2, result)
    }

    @Test
    fun comission_maestro() {
        val ammount = 40_000
        val previous = 100_000
        val typeCard = TYPE_MAESTRO

        val result = comission(typeCard, ammount, previous)

        assertEquals(0, result)
    }

    @Test
    fun comission_maestro_error() {
        val ammount = 400_000
        val previous = 100_000
        val typeCard = TYPE_MAESTRO

        val result = comission(typeCard, ammount, previous)

        assertEquals(-2, result)
    }

    @Test
    fun comission_vkpay() {
        val ammount = 5000
        val previous = 50000
        val typeCard = TYPE_VKPAY

        val result = comission(typeCard, ammount, previous)

        assertEquals(0, result)
    }

    @Test
    fun comission_error_pay_system() {
        val ammount = 5000
        val previous = 50000
        val typeCard = "other"

        val result = comission(typeCard, ammount, previous)

        assertEquals(0, result)
    }

}
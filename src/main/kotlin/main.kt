import kotlin.math.max

const val TYPE_MASTERCARD = "MasterCard"
const val TYPE_MAESTRO = "Maestro"
const val TYPE_VISA = "Visa"
const val TYPE_MIR = "Мир"
const val TYPE_VKPAY = "VK Pay"
const val ERROR_TYPE = -1
const val ERROR_LIMIT = -2

fun main() {
    val transactionAmmount = 40_000
    val previousTransactions = 100_000
    val text1 = "Если ранее в течении месяца отправлялось через "
    val text2 = " " + (previousTransactions).toString() + ", то комиссия для $transactionAmmount составит "
    println(text1 + TYPE_VISA + text2 + comission(TYPE_VISA, transactionAmmount, previousTransactions))
    println(text1 + TYPE_MIR + text2 + comission(TYPE_MIR, transactionAmmount, previousTransactions))
    println(text1 + TYPE_MASTERCARD + text2 + comission(TYPE_MASTERCARD, transactionAmmount, previousTransactions))
    println(text1 + TYPE_MAESTRO + text2 + comission(TYPE_MAESTRO, transactionAmmount, previousTransactions))
    println(text1 + TYPE_VKPAY + text2 + comission(TYPE_VKPAY, transactionAmmount, previousTransactions))
}
fun comission(typeCard: String, amount: Int, previous: Int): Int = when (typeCard) {
    "Visa", "Мир" -> if (amount <= 150_000 && amount+previous <= 600_000) max(35, (amount * 0.0075f).toInt()) else ERROR_LIMIT
    "MasterCard", "Maestro" -> if (amount <= 150_000 && amount+previous <= 600_000) 0 else ERROR_LIMIT
    "VK Pay" -> 0
    else -> ERROR_TYPE
}
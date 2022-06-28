private const val INCORRECT_PRICE_LIST = "incorrect price list"
private const val INCORRECT_DISCOUNT_VALUE = "incorrect discount value"
private const val INCORRECT_OFFSET_VALUE = "incorrect offset value"
private const val INCORRECT_READLENGTH_VALUE = "incorrect readLength value"

fun main() {
    println(
        decryptData(
            price = listOf(5, 100, 20, 66, 16),
            discount = 50,
            offset = 1,
            readLength = 3,
        )
    )
}

private fun decryptData(
    price: List<Int>,
    discount: Int,
    offset: Int,
    readLength: Int,
): List<Int> {
    price.forEach {
        if (it < 0) {
            return throw java.lang.IllegalArgumentException(INCORRECT_PRICE_LIST)
        }
    }
    if (discount < 1 || discount > 99) {
        return throw java.lang.IllegalArgumentException(INCORRECT_DISCOUNT_VALUE)
    }
    if (offset < 0 || offset > price.size) {
        return throw java.lang.IllegalArgumentException(INCORRECT_OFFSET_VALUE)
    }
    if (readLength < 0 || readLength > price.size) {
        return throw java.lang.IllegalArgumentException(INCORRECT_READLENGTH_VALUE)
    }

    return price.subList(offset, offset + readLength).map {
        (it * discount) / 100
    }
}
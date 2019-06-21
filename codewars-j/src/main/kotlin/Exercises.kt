fun main(args: Array<String>) {
    val yearBad = 1234
    val yearGood = 1984
    print(isLeapYear(yearGood))
}

fun isLeapYear(year: Int) : Boolean {
    return when {
        year % 400 == 0 || (year % 100 != 0 && year % 4 == 0) -> true
        else -> false
    }
}
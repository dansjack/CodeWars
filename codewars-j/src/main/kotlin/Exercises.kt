import java.nio.CharBuffer
import kotlin.math.abs


fun main(args: Array<String>) {

    // Leap Years (7 kyu)
    /*
    val yearBad = 1234
    val yearGood = 1984
    print(isLeapYear(yearGood))
    */

    // Twice as old (8 kyu)
    /*
    Your function takes two arguments:

    current father's age (years)
    current age of his son (years)

    Сalculate how many years ago the
    father was twice as old as his
    son (or in how many years he will
    be twice as old).
    print(twiceAsOld(42, 21))
    */

    // Alphabet war (7 kyu)
    /*
    Write a function that accepts fight string
    consists of only small letters and return
    who wins the fight. When the left side wins
    return Left side wins!, when the right side
    wins return Right side wins!, in other case
    return Let's fight again!.

    The left side letters and their power:
     w - 4
     p - 3
     b - 2
     s - 1

    The right side letters and their power:
     m - 4
     q - 3
     d - 2
     z - 1

    The other letters don't have power and are only victims.
    Example

    AlphabetWar("z");        //=> Right side wins!
    AlphabetWar("zdqmwpbs"); //=> Let's fight again!
    AlphabetWar("zzzzs");    //=> Right side wins!
    AlphabetWar("wwwwwwz");  //=> Left side wins!
    alphabetWar("z")
    */

    // Get the Middle Character (7 kyu)
    /*
    You are going to be given a word.
    Your job is to return the middle
    character of the word. If the
    word's length is odd, return the
    middle character. If the word's
    length is even, return the middle
    2 characters.
    getMiddle("middle")
    */

    // Salesman's Travel (6 kyu)
    /*
    The function travel will take two
    parameters r (addresses' list of
    all clients' as a string) and
    zipcode and returns a string in
    the following format:

    zipcode:street and town,street and town,.../house number,house number,...

    The street numbers must be in the
    same order as the streets where
    they belong.

    If a given zipcode doesn't exist
    in the list of clients' addresses
    return "zipcode:/"

    r = "123 Main Street St. Louisville OH 43071,432 Main Long Road St. Louisville OH 43071,786 High Street Pollocksville NY 56432"

    travel(r, "OH 43071") --> "OH 43071:Main Street St. Louisville,Main Long Road St. Louisville/123,432"
    travel(r, "NY 56432") --> "NY 56432:High Street Pollocksville/786"
    travel(r, "NY 5643") --> "NY 5643:/"

    val r = "123 Main Street St. Louisville OH 43071,432 Main Long Road St. " +
            "Louisville OH 43071,786 High Street Pollocksville NY 56432"


    println(travel(r, "NY 5643"))
    */

    // Small enough? - beginner (7 kyu)
    /*
    You will be given an array and a
    limit value. You must check that
    all values in the array are below or
    equal to the limit value. If they are,
    return true. Else, return false.

    You can assume all values in the array
    are numbers.

    println(smallEnough(intArrayOf(78, 117, 110, 99, 104, 117, 107, 115), 100))
    */

}

fun twiceAsOld(dadYearsOld: Int, sonYearsOld: Int): Int =
        abs(dadYearsOld - (sonYearsOld * 2))

fun isLeapYear(year: Int) : Boolean {
    return when {
        year % 400 == 0 || (year % 100 != 0 && year % 4 == 0) -> true
        else -> false
    }
}

fun alphabetWar(fight: String): String {
    val leftPower = "sbpw"
    val rightPower = "zdqm"

    var leftCount = 0
    var rightCount = 0

    for (l in fight) {
        for (p in 0 until leftPower.length) {
            if (l == leftPower[p]) {
                leftCount += p + 1
            } else if (l == rightPower[p]) {
                rightCount += p + 1
            }
        }
    }
    return when {
        rightCount > leftCount -> "Right side wins!"
        rightCount < leftCount -> "Left side wins!"
        else -> "Let's fight again!"
    }
}

fun getMiddle(word : String) : String {
    var result = ""
    when {
        word.length % 2 == 0 -> {
            result += word[word.length / 2 - 1]
            result += word[(word.length / 2)]
        }
        else -> result += word[word.length / 2]
    }
    return result
}

fun travel(r:String, zipcode:String):String {
    val rArray = r.split(",").toTypedArray()
    var result = ""
    var resultEnd = ""

    for (string in rArray) {
        if (zipcode == string.substring(string.length - 8)) {
            if (result.isEmpty()) {
                result += string
                        .substring(string.length - 8) + ":" + string
                        .substring(string.
                                indexOf(" ") + 1, string.length - 9)
                resultEnd += "/" + string.
                        substring(0, string.indexOf(" "))
            } else {
                result += "," + string.
                        substring(string.indexOf(" ") + 1,
                        string.length - 9)
                resultEnd += "," + string.
                        substring(0, string.indexOf(" "))
            }
        }
    }

    if (result.isEmpty()) {
        return "$zipcode:/"
    }
    result += resultEnd
    return result
}

fun smallEnough(a : IntArray, limit : Int) : Boolean {
    for (num in 0 until a.size) {
        if (a[num] > limit) {
            return false
        }
    }
    return true
}
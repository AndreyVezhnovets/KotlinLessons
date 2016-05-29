package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(date2: MyDate): Int = when {
        year > date2.year -> 1
        year < date2.year -> -1
        else -> {
            when {
                month > date2.month -> 1
                month < date2.month -> -1
                else -> {
                    when {
                        dayOfMonth > date2.dayOfMonth -> 1
                        dayOfMonth < date2.dayOfMonth -> -1
                        else -> 0
                    }
                }
            }
        }
    }
}

operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this,other)

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(val start: MyDate, val endInclusive: MyDate) {
    infix operator fun contains(date: MyDate): Boolean {
        if ( date > start && date < endInclusive) {
            return true
        } else return false
    }
}

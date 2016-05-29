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

class DateRange(val start: MyDate, val endInclusive: MyDate){

    infix operator fun contains(date: MyDate): Boolean {
        if ( date > start && date < endInclusive) {
            return true
        } else return false
    }

     operator fun iterator(): Iterator<MyDate> = DateIterator(this)


}
class DateIterator(val dateRange: DateRange) : Iterator<MyDate> {
    var current: MyDate = dateRange.start
    override fun next(): MyDate {
        val result = current
        current = current.addTimeIntervals(TimeInterval.DAY, 1)
        return result
    }
    override fun hasNext(): Boolean = current <= dateRange.endInclusive
}



class RepeatedTimeInterval(val timeInterval: TimeInterval, val number: Int)
operator fun TimeInterval.times(number: Int) = RepeatedTimeInterval(this, number)

operator fun MyDate.plus(timeInterval: TimeInterval) = addTimeIntervals(timeInterval, 1)
operator fun MyDate.plus(timeIntervals: RepeatedTimeInterval) = addTimeIntervals(timeIntervals.timeInterval, timeIntervals.number)
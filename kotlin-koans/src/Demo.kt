import java.lang.IllegalArgumentException
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.Month
import java.time.Month.*
import java.time.temporal.IsoFields
import java.time.temporal.Temporal

fun main() {
    val start = LocalDateTime.now()
    val end = LocalDateTime.now()
    val dayOfQuarter = LocalDateTime.now().get(IsoFields.DAY_OF_QUARTER)
    println(start.dayOfMonth)
    println(start)
    println(end)
    println(start.month.firstMonthOfQuarter())
    println(FEBRUARY.minLength())
    println(FEBRUARY.maxLength())
    println(start.month.maxLength())
    println(getCurrentQuarter(start))
    println("---=")
    println(getCurrentQuarter(LocalDateTime.now().minusDays(90)))
    println("---=")
    println(getCurrentQuarter(LocalDateTime.now().minusDays(30)))
    println("---=")
    println(getCurrentQuarter(LocalDateTime.now().plusDays(30)))
    println("---=")
    println(dayOfQuarter)
    println(getCurrentQuarter(LocalDateTime.now().minusDays(dayOfQuarter.toLong())))
    println("---=")
    val (begin, finish) = getCurrentQuarter(LocalDateTime.now())
    println(begin)
    println(finish)
    println(begin.get(IsoFields.DAY_OF_QUARTER))
    println("---=")
    println(LocalDateTime.now().minusDays(dayOfQuarter.toLong()))
    println(getCurrentQuarter(LocalDateTime.now()))
    println(minOf(LocalDateTime.now(), getCurrentQuarter(LocalDateTime.now()).second))
}

fun getCurrentQuarter(date: LocalDateTime): Pair<LocalDateTime, LocalDateTime> {
    return when (date.month) {
        JANUARY, FEBRUARY, MARCH -> {
            Pair(
                LocalDateTime.of(LocalDate.of(date.year, JANUARY, 1), LocalTime.MIN),
                LocalDateTime.of(LocalDate.of(date.year, MARCH, MARCH.maxLength()), LocalTime.MAX)
            )
        }
        APRIL, MAY, JUNE -> {
            Pair(
                LocalDateTime.of(LocalDate.of(date.year, APRIL, 1), LocalTime.MIN),
                LocalDateTime.of(LocalDate.of(date.year, JUNE, JUNE.maxLength()), LocalTime.MAX)
            )
        }

        JULY, AUGUST, SEPTEMBER -> {
            Pair(
                LocalDateTime.of(LocalDate.of(date.year, JULY, 1), LocalTime.MIN),
                LocalDateTime.of(LocalDate.of(date.year, SEPTEMBER, SEPTEMBER.maxLength()), LocalTime.MAX)
            )

        }
        OCTOBER, NOVEMBER, DECEMBER -> {
            Pair(
                LocalDateTime.of(LocalDate.of(date.year, OCTOBER, 1), LocalTime.MIN),
                LocalDateTime.of(LocalDate.of(date.year, DECEMBER, DECEMBER.maxLength()), LocalTime.MAX)
            )
        }
        null -> throw IllegalArgumentException("Month cannot be null!")
    }

}
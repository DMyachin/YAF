package xyz.myachin.yaf.tools.datetime

import java.util.*

object TDateUtil {

    /**
     * @param [year] год с 1
     * @param [month] месяц с 0
     * @param [date] день месяца с 1
     * @param [hourOfDay] время дня с 0
     * @param [minute] минуты с 0
     * @param [second] секунды с 0
     * @param [timeZone] тайм зона
     * @return [Date] в миллисекундах
     */
    fun dateFromCalendar(year: Int, month: Int, date: Int,
                         hourOfDay: Int = 0, minute: Int = 0, second: Int = 0,
                         timeZone: String = "Europe/Moscow"): Date {
        GregorianCalendar(TimeZone.getTimeZone(timeZone))
            .apply { set(year, month, date, hourOfDay, minute, second) }
            .let { calendar ->
                return Date(calendar.timeInMillis)
            }
    }
}
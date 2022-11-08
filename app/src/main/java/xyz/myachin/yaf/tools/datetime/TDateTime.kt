package xyz.myachin.yaf.tools.datetime

import xyz.myachin.yaf.core.exceptions.TDateTimeParseFail
import xyz.myachin.yaf.tools.datetime.TDateTime.Companion.createFromFormat
import xyz.myachin.yaf.tools.datetime.TDateTime.Companion.createFromNowDateTime
import xyz.myachin.yaf.tools.datetime.TDateTime.Companion.createFromNowTime
import java.text.SimpleDateFormat
import java.util.*
import java.util.Calendar.*


/** Uses for date compares. Can be creates with [createFromFormat], [createFromNowTime] or [createFromNowDateTime]*/
class TDateTime(private val dateTime: Date) {
    companion object {
        /** Creates [TDateTime] from string
         *
         * [format] is format for date or time. For example hh:mm:ss
         *
         * [dateTime] is date ot time what need to format
         */
        fun createFromFormat(format: String, dateTime: String): TDateTime {
            SimpleDateFormat(format, Locale.getDefault()).parse(dateTime)?.let { date ->
                return TDateTime(date)
            }
            throw TDateTimeParseFail(format, dateTime)
        }

        /** Creates [TDateTime] from current Android's time. Can be used ONLY for HH:mm[:ss] */
        fun createFromNowTime(): TDateTime {
            val calendar = GregorianCalendar()
            calendar.set(1970, Calendar.JANUARY, 1)
            return TDateTime(calendar.time)
        }

        /** Create [TDateTime] from current Android's time. Can be used ONLY for dd MM YYYY  */
        fun createFromNowDate(): TDateTime {
            val calendar = GregorianCalendar()
            calendar.set(
                calendar.get(YEAR),
                calendar.get(MONTH),
                calendar.get(DAY_OF_MONTH),
                0,
                0,
                0
            )
            return TDateTime(calendar.time)
        }

        /** Creates [TDateTime] from current Android's time. Can be used for full date */
        fun createFromNowDateTime(): TDateTime {
            return TDateTime(Date())
        }
    }

    /** Compares date with [tDateTime]. Returns milliseconds between dates */
    fun diffBetween(tDateTime: TDateTime): Long {
        return tDateTime.dateTime.time - this.dateTime.time
    }
}
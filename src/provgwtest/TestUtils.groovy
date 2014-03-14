package provgwtest

import java.text.SimpleDateFormat

class TestUtils {

    private static final timeFormat = "yyyy-MM-dd hh:mm:ss"
    
    static boolean isTimeCorrect(strExpectedTime, javatime) {
        //return true
        return isTimeCorrectDay(strExpectedTime, javatime)
    }
    
    static boolean isTimeCorrectDay(strExpectedTime, javatime) {
        def timeTruncate = 10
        def strTime = new SimpleDateFormat(timeFormat).format(new Date())
        def strTimeCmp = strTime.substring(0,timeTruncate)
        def strstrExpectedTimeCmp = strExpectedTime.substring(0,timeTruncate)
        println strTime
        println strTimeCmp
        println strstrExpectedTimeCmp
        return strTimeCmp==strstrExpectedTimeCmp
    }

    static boolean isTimeCorrectMinute(strExpectedTime, javatime) {
        def timeTruncate = 16
        def strTime = new SimpleDateFormat(timeFormat).format(new Date())
        def strTimeCmp = strTime.substring(0,timeTruncate)
        def strstrExpectedTimeCmp = strExpectedTime.substring(0,timeTruncate)
        println strTime
        println strTimeCmp
        println strstrExpectedTimeCmp
        return strTimeCmp==strstrExpectedTimeCmp
    }

    static void getSecondsFrom1900(timeZone) {
        def date1990 = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse("1900-01-01 00:00:00").getTime()/1000//+timeZone*3600
        date1990 +=timeZone*3600
        //def date1990pos = Long.parseLong(String.valueOf(date1990).substring(1))
        //println date1990pos
        def curdate = (new Date().getTime()/1000)
        println curdate
        Long curSince1900 = curdate-date1990
        println curSince1900
    }
    
    static main(args) {
        //println(isTimeCorrect('2014-03-11 09:38:00', new Date()))
        
        //println((new Date().getTime())/1000)
        //println((new SimpleDateFormat(timeFormat)).parse("1900-01-01 00:00:00").getTime()/1000)
        
        getSecondsFrom1900(8);
    }

}

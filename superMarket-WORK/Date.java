/**
 * This class represents a Date Object
 * 
 * @author (Ben Cohen) 
 * @version (2020a)
 */

public class Date
{
    private int _day;
    private int _month;
    private int _year;
    private final int DEFAULT_YEAR=2000;
    private final int DEFAULT_DAY=1;
    private final int DEFAULT_MONTH=1;
    private final int JAN=1;
    private final int FEB=2;
    private final int MAR=3;
    private final int APR=4;
    private final int MAY=5;
    private final int JUN=6;
    private final int JUL=7;
    private final int AUG=8;
    private final int SEP=9;
    private final int OCT=10;
    private final int NOV=11;
    private final int DEC=12;
    private final int SHORT_MONTH=28;
    private final int SMALL_MONTH=29;
    private final int MEDIUM_MONTH=30;
    private final int LONG_MONTH=31;
    private final int START_MONTH=1;

    /**
     * creates a new Date object if the date is valid, otherwise creates the date 1/1/2000
     * @param day the day in the month(1-31)
     * @param month the month in the year(1-12)
     * @param year the year ( 4 digits)
     */

    public Date(int day, int month, int year){
        if(!(validYear(year))){//checking the validation of the year using a private boolean function.
            _year=DEFAULT_YEAR;
            _day=DEFAULT_DAY;
            _month=DEFAULT_MONTH;}
        else{
            _year=year;
            if(!(validMonth(month))){//checking the validation of the month using a private boolean function.
                _year=DEFAULT_YEAR;
                _day=DEFAULT_DAY;
                _month=DEFAULT_MONTH;}
            else{
                _month=month;
                if(!(validDay(day))){//checking the validation of the day using a private boolean function including leap years.
                    _year=DEFAULT_YEAR;
                    _day=DEFAULT_DAY;
                    _month=DEFAULT_MONTH;}
                else
                    _day=day;
            }
        }
    }

    /**
     * checking the validation of a year
     * @param year the year you want to check its validation
     * @return true if the year is in our range 1000-9999
     */

    private boolean validYear(int year){
        if((year>=1000)&&(year<=9999))
            return true;
        return false;
    }

    /**
     * checking the validation of a month
     * @param month the month you want to check its validation
     * @return true if the month is in our range January-December
     */

    private boolean validMonth(int month){
        if(month>=JAN&&month<=DEC)
            return true;
        return false;
    }

    /**
     * checking the validation of a day
     * @param day the day you want to check its validation
     * @return true if the day is in our range in a month referenced leap years and months lengths
     */

    private boolean validDay(int day){
        if((_month==JAN)||(_month==MAR)||(_month==MAY)||(_month==JUL)||(_month==AUG)||(_month==OCT)||(_month==DEC)){
            if(day>=START_MONTH&&day<=LONG_MONTH)//31 days in these months
                return true;
            return false;}
        else if((_month==APR)||(_month==JUN)||(_month==SEP)||(_month==NOV)){
            if(day>=START_MONTH&&day<=MEDIUM_MONTH)//30 days in these months
                return true;
            return false;}
        else if(_month==FEB){//28 day in this month regulary, in a leap year its 29.
            if(_year%400==0){//leap year checking
                if(day>=START_MONTH&&day<=SMALL_MONTH)
                    return true;
                return false;}
            else if(_year%4==0&&(_year%100!=0)){//leap year checking
                if(day>=START_MONTH&&day<=SMALL_MONTH)
                    return true;
                return false;}
            else if(day>=START_MONTH&&day<=SHORT_MONTH)
                return true;
            return false;
        }
        return false;
    }

    /**
     * calculates the how many days passed since the start of the Gregorian Calendar
     * @return how many days passed since the start of the Gregorian Calendar
     */
    private int calculateDate ( int day, int month, int year){
        if (month < 3){
            year--;             
            month = month + 12;}          
        return 365 * year + year/4 - year/100 + year/400 + ((month+1) * 306)/10 + (day - 62);
    }   

    /**
     * Copy Constructor
     * @param date to be copied
     */

    public Date (Date other){
        _day = other._day;
        _month = other._month;
        _year = other._year;
    }

    /** sets the year
     * @param yearToSet the value to be set
     */

    public void setYear(int yearToSet){
        if(validYear(yearToSet))
            _year=yearToSet;
        else
            _year=_year;
    }

    /** sets the month
     * @param monthToSet the value to be set
     */

    public void setMonth(int monthToSet){
        if(validMonth(monthToSet)){
            if(((_day<=LONG_MONTH)&&(_day>=START_MONTH))&&((monthToSet==JAN)||(monthToSet==MAR)||(monthToSet==MAY)||(monthToSet==JUL)||(monthToSet==AUG)||(monthToSet==OCT)||(monthToSet==DEC)))
                _month=monthToSet;//comparing between the month and the day, and checks if that month set is availbale.
            else{ 
                if(((_day<=MEDIUM_MONTH)&&(_day>=START_MONTH))&&((monthToSet==APR)||(monthToSet==JUN)||(monthToSet==SEP)||(monthToSet==NOV)))
                    _month=monthToSet;//comparing between the month and the day, and checks if that month set is availbale.
                else{
                    if(((_day<=SMALL_MONTH)&&(_day>=START_MONTH))&&(monthToSet==FEB)&&(_year%400==0))
                        _month=monthToSet;//comparing between the month and the day, and checks if that month set is availbale including leap years.
                    else{
                        if(((_day<=SMALL_MONTH)&&(_day>=START_MONTH))&&(monthToSet==FEB)&&(_year%4==0)&&((_year%100!=0)))
                            _month=monthToSet;//comparing between the month and the day, and checks if that month set is availbale including leap years.
                        else{
                            if(((_day<=SHORT_MONTH)&&(_day>=START_MONTH))&&(monthToSet==FEB))
                                _month=monthToSet;//comparing between the month and the day, and checks if that month set is availbale.
                            else
                                _month=_month;}}}}}
        else  
            _month=_month;
    }

    /** sets the day
     * @param dayToSet the value to be set
     */

    public void setDay(int dayToSet){
        if(validDay(dayToSet))
            _day=dayToSet;
        else
            _day=_day;
    }

    /** gets the day
     * @return the day
     */ 

    public int getDay(){
        return this._day;
    }

    /** gets the month
     * @return the month
     */ 

    public int getMonth(){
        return this._month;
    }

    /** gets the year
     * @return the year
     */ 

    public int getYear(){
        return this._year;
    }

    /**
     * comparing between 2 dates and telling us if a date comes before another
     * @param dateToCompare the date you want to compare to the object you use that function
     * @return true if the date object you using on this function is earlier then the another date
     */

    public boolean before(Date dateToCompare) {
        if (_year < dateToCompare._year)
            return true;
        if (_year == dateToCompare._year) {
            if (_month < dateToCompare._month)
                return true;
            if (_month == dateToCompare._month && _day < dateToCompare._day)
                return true;
        }
        return false;
    }

    /**
     * comparing between 2 dates and telling us if a date comes after another
     * @param dateToCompare the date you want to compare to the object you use that function
     * @return true if the date object you using on this function is afterwards then the another date
     */

    public boolean after(Date dateToCompare){
        if(dateToCompare.before(this))//using before function
            return true;
        return false;
    }

    /** check if 2 dates are the same
     * @param other the date to compare this date to
     *  @return true if the dates are the same
     */

    public boolean equals(Date other){
        if((this._day==other._day)&&(this._month==other._month)&&(this._year==other._year))
            return true;
        return false;
    }

    /**
     * returns a  String that represents this date
     *
     * @return String that represents this date
     * in the following format:
     * day/month/year (30/9/1917)
     */

    public String toString() {
        if((_day<10)&&(_month<OCT))//check if there is a singel number that needs "0" before him
            return "0"+this._day +"/" +"0"+ this._month + "/" +this. _year;
        else if(_month<10)//check if there is a singel number that needs "0" before him
            return this._day +"/" +"0"+ this._month + "/" +this. _year;
        else if(_day<10)//check if there is a singel number that needs "0" before him
            return "0"+this._day +"/" + this._month + "/" +this. _year;
        else
            return this._day +"/" + this._month + "/" +this. _year;
    }
    
    /**
     * comparing between 2 dates and telling us the difference by days between them
     * @param dateToCompare the date you want to compare to the object you use that function
     */
    
    public int difference(Date other){
        int A,B;
        A=calculateDate(this._day,this._month,this._year);
        B=calculateDate(other._day,other._month,other._year);
        return Math.abs(A-B);
    }

    /**
     * calculate the day after the date you are using this function on
     * @return new object that represent the day after the date you are using this function on
     */

    public Date tomorrow(){
        int d,m,y;
        if((_day==LONG_MONTH)&&(_month==12)){//checking the 31/12/xxxx situation.
            d=1;
            m=1;
            y=_year+1; 
            return new Date(d,m,y);}
        else if(((_month==JAN)||(_month==MAR)||(_month==MAY)||(_month==JUL)||(_month==AUG)||(_month==OCT))&&(_day==LONG_MONTH)){//checking the 31/x/xxxx situation.
            d=1;
            m=_month+1;
            y=_year;
            return new Date(d,m,y);}
        else if(((_month==APR)||(_month==JUN)||(_month==SEP)||(_month==NOV))&&(_day==MEDIUM_MONTH)){//checking the 30/x/xxxx situation.
            d=1;
            m=_month+1;
            y=_year;
            return new Date(d,m,y);}
        else
        if((_month==FEB)&&(_year%400==0)&&(_day==SMALL_MONTH)){//checking the 29/x/xxxx situation in a leap year.
            d=1;
            m=_month+1;
            y=_year;
            return new Date(d,m,y);}
        else 
        if((_month==FEB)&&(_year%4==0)&&(_year%100!=0)&&(_day==SMALL_MONTH)){//checking the 29/x/xxxx situation in a leap year.
            d=1;
            m=_month+1;
            y=_year;
            return new Date(d,m,y);}
        else 
        if((_month==FEB)&&(_day==SHORT_MONTH)&&(_year%4!=0)){//checking the 28/x/xxxx situation.
            d=1;
            m=_month+1;
            y=_year;
            return new Date(d,m,y);}
        else {//checking the situation that the day tommorow is not changing the month/year count.
            d=_day+1;
            m=_month;
            y=_year;
            return new Date(d,m,y);}
    }

    /**
     * returns which day in the week is that date referenced to
     * @return which day in the week is that date referenced to in this format:
     * 0 will be saturday and 1-6 will be sunday-friday
     */
    public int dayInWeek(){
        int d,m,y,c,day,year1,calculation;
        d=_day;
        if((_month==JAN)||(_month==FEB)){//at that formula January is 13 and February is 14.
            m=_month+12;
            year1=(_year-1);}
        else{
            m=_month;
            year1=_year;}
        y=year1%100;
        c=(year1-y)/100;
        calculation=(d+(26*(m+1))/10+y+y/4+c/4-2*c);
        if(calculation>=7)
            day=(d+(26*(m+1))/10+y+y/4+c/4-2*c)%7;
        else
            day=Math.floorMod(calculation,7);
        return day;
    }
}

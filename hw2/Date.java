/* Date.java */

import java.io.*;

class Date {

  /* Put your private data fields here. */
  private int month;
  private int day;
  private int year;

  /** Constructs a date with the given month, day and year.   If the date is
   *  not valid, the entire program will halt with an error message.
   *  @param month is a month, numbered in the range 1...12.
   *  @param day is between 1 and the number of days in the given month.
   *  @param year is the year in question, with no digits omitted.
   */
  public Date(int month, int day, int year) {
    if (month >= 1 && month <= 12 && day >=1 && day <= daysInMonth(month, year)){
      this.month = month;
      this.day = day;
      this.year = year;
    }
    else {
      System.out.println("Date constructor failed");
      System.exit(0);
    }

  }

  /** Constructs a Date object corresponding to the given string.
   *  @param s should be a string of the form "month/day/year" where month must
   *  be one or two digits, day must be one or two digits, and year must be
   *  between 1 and 4 digits.  If s does not match these requirements or is not
   *  a valid date, the program halts with an error message.
   */
  public Date(String s) {
    String[] dates = s.split("/");
    int smonth = Integer.parseInt(dates[0]);
    int sday = Integer.parseInt(dates[1]);
    int syear = Integer.parseInt(dates[2]);
    int monthLength = dates[0].length();
    int dayLength = dates[1].length();
    int yearLength = dates[2].length();
  

    if (monthLength >= 1 && monthLength <= 2 && dayLength >= 1 && 
    dayLength <= 2 && yearLength <= 4 && yearLength >= 1 && 
    isValidDate(smonth, sday, syear)){
      

      if (smonth >= 1 && smonth <= 12 && sday >=1 && sday <= daysInMonth(smonth, syear)){
        
        this.month = smonth;
        this.day = sday;
        this.year = syear;
      }
      else {
        System.out.println("Date constructor failed");
        System.exit(0);
      }
    }
    else {
      System.out.println("Month = " + smonth);
      System.out.println("Day = " + sday);
      System.out.println("Year = " + syear);
      System.out.println("Date string not valid");
      System.exit(0);
    }

    


  }

  /** Checks whether the given year is a leap year.
   *  @return true if and only if the input year is a leap year.
   */
  public static boolean isLeapYear(int year) {
    if(year % 4 != 0){   //year is not divisible by 4, not leap year
      return false;
    }  
    else if(year % 100 == 0){   //year is divisible by 4 and 100
      if (year % 400 == 0) return true; // divisible by 400, leap year
      else return false;    //not divisible by 400, not leap year
    } else return true;  //year is divisible by 4, not 100
                             // replace this line with your solution
  }

  /** Returns the number of days in a given month.
   *  @param month is a month, numbered in the range 1...12.
   *  @param year is the year in question, with no digits omitted.
   *  @return the number of days in the given month.
   */
  public static int daysInMonth(int month, int year) {
    if (month == 2){
      if (isLeapYear(year)==true) return 29;
      else return 28;
    }
    else if (month == 4 || month == 6 || month == 9 || month == 11) return 30;
    else return 31;
                             // replace this line with your solution
  }

  /** Checks whether the given date is valid.
   *  @return true if and only if month/day/year constitute a valid date.
   *
   *  Years prior to A.D. 1 are NOT valid.
   */
  public static boolean isValidDate(int month, int day, int year) {
    if (day > daysInMonth(month, year) || year < 1) return false;
    else return true;
                           // replace this line with your solution
  }

  /** Returns a string representation of this date in the form month/day/year.
   *  The month, day, and year are expressed in full as integers; for example,
   *  12/7/2006 or 3/21/407.
   *  @return a String representation of this date.
   */
  public String toString() {
    String smonth = Integer.toString(month);
    String sday = Integer.toString(day);
    String syear = Integer.toString(year);
    String sdate = smonth + "/" + sday + "/" + syear;
    return sdate;

    // replace this line with your solution
  }

  /** Determines whether this Date is before the Date d.
   *  @return true if and only if this Date is before d. 
   */
  public boolean isBefore(Date d) {
    // year not same  d = 1/1/2011, this = 12/31/2010
    if (d.year != this.year){
      if (this.year+1 == d.year && this.month == 12 && d.month == 1
      && this.day == 31 && d.day == 1) return true;
      else return false;
    }
    else {
      // year same, month not same  d = 2/1/2011, this = 1/31/2011
      if (d.month != this.month){
        if (this.month+1 == d.month && this.day == daysInMonth(this.month, this.year)
        && d.day == 1) return true;
        else return false;
      }
      // year same, month same, d.day = this.day+1
      else{
        if (d.day == this.day+1) return true;
        else return false;
      }
    }
                           // replace this line with your solution
  }

  /** Determines whether this Date is after the Date d.
   *  @return true if and only if this Date is after d. 
   */
  public boolean isAfter(Date d) {
    Date thisDate = new Date(this.month, this.day, this.year);
    if (d.isBefore(thisDate)) return true;
    else return false;
                          // replace this line with your solution
  }

  /** Returns the number of this Date in the year.
   *  @return a number n in the range 1...366, inclusive, such that this Date
   *  is the nth day of its year.  (366 is used only for December 31 in a leap
   *  year.)
   */
  public int dayInYear() {
    int dayCount = this.day;
    for (int i = 1; i < this.month; i++){
      dayCount = dayCount + daysInMonth(i, this.year);
    }
    return dayCount;
                              // replace this line with your solution
  }

  /** Determines the difference in days between d and this Date.  For example,
   *  if this Date is 12/15/2012 and d is 12/14/2012, the difference is 1.
   *  If this Date occurs before d, the result is negative.
   *  @return the difference in days between d and this date.
   */
  public int difference(Date d) {
    // year same
    
    if (d.year == this.year){
      return this.dayInYear() - d.dayInYear();
    }
    // year not same, d = 1/31/2011, this = 4/20/2009
    // d = 2011.120, this = 2009.230 nagetive
    // d = 2011.120, this = 2013.230
    else {
      int daysBetween  = 0;
      if (d.year > this.year){
        
        if (d.year - 1 > this.year){
          for (int i = this.year+1; i < d.year; i++){
            if (isLeapYear(i)){
              daysBetween = daysBetween + 366;
            }
            else {
              daysBetween = daysBetween + 365;
            }
          }
        }
        if (isLeapYear(this.year)){
          daysBetween = daysBetween + 366 - this.dayInYear();
        }
        else {
          daysBetween = daysBetween + 365 - this.dayInYear();
        }
        daysBetween = daysBetween + d.dayInYear();
        return -daysBetween;
      }
      else {
       
        if (this.year - 1 > d.year){
          
          for (int i = d.year+1; i < this.year; i++){
            if (isLeapYear(i)){
              daysBetween = daysBetween + 366;
            }
            else {
              daysBetween = daysBetween + 365;
            }
          }
        }
        if (isLeapYear(d.year)){
          daysBetween = daysBetween + 366 - d.dayInYear();
          
        }
        else {
          daysBetween = daysBetween + 365 - d.dayInYear();
          
        }
        
        daysBetween = daysBetween + this.dayInYear();
        return daysBetween;


      }


    }

    // replace this line with your solution
  }

  public static void main(String[] argv) {
    System.out.println("\nTesting constructors.");
    // Date d1 = new Date(1, 1, 1);
    // System.out.println("Date should be 1/1/1: " + d1);
    // Date d1 = new Date("2/4/2");
    // System.out.println("Date should be 2/4/2: " + d1);
    // Date d1 = new Date("2/29/2000");
    // System.out.println("Date should be 2/29/2000: " + d1);
    // d1 = new Date("2/29/1904");
    // System.out.println("Date should be 2/29/1904: " + d1);

    Date d1 = new Date(12, 31, 1975);
    // System.out.println("Date should be 12/31/1975: " + d1);
    Date d2 = new Date("1/1/1976");
    // System.out.println("Date should be 1/1/1976: " + d2);
    Date d3 = new Date("1/2/1976");
    // System.out.println("Date should be 1/2/1976: " + d3);

    Date d4 = new Date("2/27/1977");
    Date d5 = new Date("8/31/2110");

    /* I recommend you write code to test the isLeapYear function! */

    // System.out.println("\nTesting before and after.");
    // System.out.println(d2 + " after " + d1 + " should be true: " + 
    //                    d2.isAfter(d1));
    // System.out.println(d3 + " after " + d2 + " should be true: " + 
    //                    d3.isAfter(d2));
    // System.out.println(d1 + " after " + d1 + " should be false: " + 
    //                    d1.isAfter(d1));
    // System.out.println(d1 + " after " + d2 + " should be false: " + 
    //                    d1.isAfter(d2));
    // System.out.println(d2 + " after " + d3 + " should be false: " + 
    //                    d2.isAfter(d3));

    // System.out.println(d1 + " before " + d2 + " should be true: " + 
    //                    d1.isBefore(d2));
    // System.out.println(d2 + " before " + d3 + " should be true: " + 
    //                    d2.isBefore(d3));
    // System.out.println(d1 + " before " + d1 + " should be false: " + 
    //                    d1.isBefore(d1));
    // System.out.println(d2 + " before " + d1 + " should be false: " + 
    //                    d2.isBefore(d1));
    // System.out.println(d3 + " before " + d2 + " should be false: " + 
    //                    d3.isBefore(d2));

    System.out.println("\nTesting difference.");
    System.out.println(d1 + " - " + d1  + " should be 0: " + 
                       d1.difference(d1));
    System.out.println(d2 + " - " + d1  + " should be 1: " + 
                       d2.difference(d1));
    System.out.println(d3 + " - " + d1  + " should be 2: " + 
                       d3.difference(d1));
    System.out.println(d3 + " - " + d4  + " should be -422: " + 
                       d3.difference(d4));
    System.out.println(d5 + " - " + d4  + " should be 48762: " + 
                       d5.difference(d4));
  }
}

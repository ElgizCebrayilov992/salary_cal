/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.util;

import com.mycompany.entity.MonthDate;
import java.util.Calendar;

/**
 *
 * @author Virtu
 */
public class FindMonthAllDay {

    public static MonthDate getDaily() {
        Calendar now = Calendar.getInstance();
        String ayAdi = "Unknown";
        int gun = 0;

        int month = now.get(Calendar.MONTH) + 1;
        //int month = 2;

        int year = now.get(Calendar.YEAR);

        switch (month) {
            case 1:
                ayAdi = "January";
                gun = 31;
                break;
            case 2:
                ayAdi = "February";
                if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
                    gun = 29;
                } else {
                    gun = 28;
                }
                break;
            case 3:
                ayAdi = "March";
                gun = 31;
                break;
            case 4:
                ayAdi = "April";
                gun = 30;
                break;
            case 5:
                ayAdi = "May";
                gun = 31;
                break;
            case 6:
                ayAdi = "June";
                gun = 30;
                break;
            case 7:
                ayAdi = "July";
                gun = 31;
                break;
            case 8:
                ayAdi = "August";
                gun = 31;
                break;
            case 9:
                ayAdi = "September";
                gun = 30;
                break;
            case 10:
                ayAdi = "October";
                gun = 31;
                break;
            case 11:
                ayAdi = "November";
                gun = 30;
                break;
            case 12:
                ayAdi = "December";
                gun = 31;
        }

        return new MonthDate(gun, month, year);

    }

    

}

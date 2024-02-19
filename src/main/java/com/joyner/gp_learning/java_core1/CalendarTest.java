package com.joyner.gp_learning.java_core1;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 陆清云 luqy
 * @version 1.00.00
 *
 * <pre>
 * 修改记录
 * 修改后版本: 修改人： 修改日期: 修改内容:
 * </pre>
 */
public class CalendarTest {

    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        int month = date.getMonthValue();
        int today = date.getDayOfMonth();

        //月初
        date = date.minusDays(today - 1);
        //月初是周几
        DayOfWeek weekDay = date.getDayOfWeek();
        int value = weekDay.getValue();

        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        //打印月初的空格
        for (int i = 1; i < value; i++) {
            System.out.print("    ");
        }
        while (date.getMonthValue() == month) {
            System.out.printf("%3d", date.getDayOfMonth());
            if (date.getDayOfMonth() == today) {
                System.out.print("*");
            } else {
                System.out.print(" ");
            }
            date = date.plusDays(1);
            if (date.getDayOfWeek().getValue() == 1) {
                System.out.println();
            }

        }
        if(date.getDayOfWeek().getValue() != 1) {
            System.out.println();
        }



    }
}

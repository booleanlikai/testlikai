package com.xiaoming.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Comparator;
import java.util.Date;


public class TimerTest {
    public static void main(String[] args) {
        ActionListener listener=new TimePrinter();
//        Timer timer=new Timer(1000,listener);
        Timer timer=new Timer(1000,event->System.out.println("At the tone,the time is"+new Date()));
        timer.start();
        JOptionPane.showMessageDialog(null,"quit program");
        System.exit(0);


    }


    static class TimePrinter implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("At the tone,the time is"+new Date());
            Toolkit.getDefaultToolkit().beep();
        }


    }
}

package com.util;

import ch.qos.logback.core.util.FileUtil;
import sun.applet.Main;

import java.io.File;

public class MainFile {
    public static void main(String[] args) {
        File read = new File("D:/HEAD1.txt");
        File read1 = new File("D:/HEAD2.txt");
        System.out.println(read.length());
        System.out.println(read1.length());
        new FileUtilThread(read , 0).start();
        new FileUtilThread(read1, 0).start();
    }

}

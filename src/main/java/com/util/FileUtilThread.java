package com.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileUtilThread extends Thread {
    private RandomAccessFile read ;
    private static RandomAccessFile write = null;

    static {
        try {
            write = new RandomAccessFile(new File("D:/a.txt"), "rw");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    private long start;

    public FileUtilThread(File read, long start) {
        try {
            this.read = new RandomAccessFile(read, "r");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.start = start;
    }

    @Override
    public void run() {
        try {
            read.seek(start);
            write.seek(start);
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = read.read(bytes)) != -1) {
                write.write(bytes,0,len);
            }
//            String sep = System.getProperty("line.separator");
//            write.writeBytes(sep);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

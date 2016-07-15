package io;

import net.mindview.util.IoUtils;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by qinbingbing on 7/15/16.
 */
public class GetChannel {
    private static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) {
        FileChannel fc = null;
        String fileName = "GetChannel";
        try {
            fc = new FileOutputStream(fileName).getChannel();
            fc.write(ByteBuffer.wrap("Some text ".getBytes()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IoUtils.close(fc);
        }

        try {
            fc = new RandomAccessFile(fileName, "rw").getChannel();
            fc.position(fc.size());
            fc.write(ByteBuffer.wrap("Some more".getBytes()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IoUtils.close(fc);
        }

        try {
            fc = new FileInputStream(fileName).getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);
            fc.read(buffer);
            buffer.flip();
            while (buffer.hasRemaining())
                System.out.print((char)buffer.get());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }

}

package io;

import net.mindview.util.IoUtils;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * Created by qinbingbing on 7/15/16.
 */
public class BufferToText {
    public static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) {
        String fileName = "BufferToText";
        FileChannel fc = null;
        try {
            fc = new FileOutputStream(fileName).getChannel();
            fc.write(ByteBuffer.wrap("Some text".getBytes()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IoUtils.close(fc);
        }

        ByteBuffer buff = ByteBuffer.allocate(BUFFER_SIZE);
        try {
            fc = new FileInputStream(fileName).getChannel();
            fc.read(buff);
            buff.flip();
            System.out.println(buff.asCharBuffer());
            buff.rewind();
            String encoding = System.getProperty("file.encoding");
            System.out.println("Decoding using "
                    + encoding
                    + ": "
                    + Charset.forName(encoding).decode(buff));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IoUtils.close(fc);
        }

        try {
            fc = new FileOutputStream(fileName).getChannel();
            fc.write(ByteBuffer.wrap("Some text".getBytes("UTF-8")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IoUtils.close(fc);
        }

        try {
            fc = new FileInputStream(fileName).getChannel();
            buff.clear();
            fc.read(buff);
            buff.flip();
            System.out.println(buff.asCharBuffer());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IoUtils.close(fc);
        }

        try {
            fc = new FileOutputStream(fileName).getChannel();
            String str = "Some text";
            buff = ByteBuffer.allocate(str.length() * 2);
            buff.asCharBuffer().put(str);
            fc.write(buff);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IoUtils.close(fc);
        }

        try {
            fc = new FileInputStream(fileName).getChannel();
            buff.clear();
            fc.read(buff);
            buff.flip();
            System.out.println(buff.asCharBuffer());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IoUtils.close(fc);
        }
    }
}

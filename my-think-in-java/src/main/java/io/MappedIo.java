package io;

import java.io.*;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by qinbingbing on 7/27/16.
 */
public class MappedIo {
    private static int numOfInts = 4000000;
    private static int numOfUbuffInts = 200000;

    private abstract static class Tester {
        private String name;
        public Tester(String name) {
            this.name = name;
        }

        public void runTest() {
            System.out.println(name + "------------------- ");
            try {
                long start = System.nanoTime();
                test();
                long duration = System.nanoTime() - start;
                System.out.format("time: %.2f\n", duration / 1.0e9);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public abstract void test() throws IOException;
    }

    private static Tester[] testers = {
        new Tester("Stream Write") {
            @Override
            public void test() throws IOException {
                DataOutputStream dos = new DataOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream("temp.tmp")));
                for (int i = 0; i < numOfInts; i++)
                    dos.writeInt(i);
                dos.close();
            }
        },
        new Tester("Mapped Write") {
            @Override
            public void test() throws IOException {
                FileChannel fc = new RandomAccessFile("temp.tmp", "rw").getChannel();
                long size = fc.size();
                System.out.println("fc.size:" + size);
                IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE, 0, size).asIntBuffer();
                for (int i = 0; i < numOfInts; i++)
                    ib.put(i);
                fc.close();
            }
        },
        new Tester("Stream Read") {
            @Override
            public void test() throws IOException {
                DataInputStream dis = new DataInputStream(
                        new BufferedInputStream(
                                new FileInputStream("temp.tmp")));
                for (int i = 0; i < numOfInts; i++)
                    dis.readInt();
                dis.close();
            }
        },
        new Tester("Mapped Read") {
            @Override
            public void test() throws IOException {
                FileChannel fc = new FileInputStream("temp.tmp").getChannel();
                long size = fc.size();
                System.out.println("fc.size:" + size);
                IntBuffer ib = fc.map(FileChannel.MapMode.READ_ONLY, 0, size).asIntBuffer();
                while (ib.hasRemaining())
                    ib.get();
                fc.close();
            }
        },
        new Tester("Stream Read/Write") {
            @Override
            public void test() throws IOException {
                RandomAccessFile raf = new RandomAccessFile("temp.tmp", "rw");
                System.out.println("raf.length" + raf.length());;
                raf.writeInt(1);
                for (int i = 0; i < numOfUbuffInts; i++) {
                    raf.seek(raf.length() - 4);
                    raf.writeInt(raf.readInt());
                }
                System.out.println("raf.length" + raf.length());;
                raf.close();
            }
        },
        new Tester("Mapped Read/Write") {
            @Override
            public void test() throws IOException {
                FileChannel fc = new RandomAccessFile("temp.tmp", "rw").getChannel();
                long size = fc.size();
                System.out.println("fc.size:" + size);
                IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE, 0, size).asIntBuffer();
                int position = ib.position();
                System.out.println("ib.position before put:" + position);
                System.out.println("value before put:" + ib.get(position));
                ib.put(0);
                System.out.println("ib.position after:" + ib.position());
                for (int i = 1; i < numOfUbuffInts; i++)
                    ib.put(ib.get(i - 1));
                System.out.println("ib.position:" + ib.position());
                System.out.println("fc.size:" + size);
                fc.close();
            }
        }
    };

    public static void main(String[] args) {
        for (Tester tester : testers)
            tester.runTest();
    }
}

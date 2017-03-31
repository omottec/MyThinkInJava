package io;

import net.mindview.util.IoUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.concurrent.CountDownLatch;

/**
 * Created by qinbingbing on 7/27/16.
 */
public class LockingMappedFiles {
    static final int LENGTH = 0x8ffffff;
    static FileChannel fc;
    static CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) {
        try {
            fc = new RandomAccessFile("test.dat", "rw").getChannel();
            MappedByteBuffer out = fc.map(FileChannel.MapMode.READ_WRITE, 0, LENGTH);
            for (int i = 0; i < LENGTH; i++)
                out.put((byte) 'x');
            new LockAndModify(out, 0, LENGTH / 3).start();
            new LockAndModify(out, LENGTH / 2, LENGTH * 3 / 4).start();
            countDownLatch.await();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            IoUtils.close(fc);
        }
    }

    public static class LockAndModify extends Thread {
        private ByteBuffer buff;
        private int start, end;

        LockAndModify(ByteBuffer mbb, int start, int end) {
            this.start = start;
            this.end = end;
            mbb.limit(end);
            mbb.position(start);
            buff = mbb.slice();
        }

        @Override
        public void run() {
            FileLock fl = null;
            try {
                fl = fc.lock(start, end, false);
                System.out.println("Locked: " + start + " to " + end);
                while (buff.position() < buff.limit() - 1)
                    buff.put((byte) (buff.get() + 1));
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fl != null) {
                    try {
                        fl.release();
                        System.out.println("Released " + start + " to " + end);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                countDownLatch.countDown();
            }
        }
    }
}

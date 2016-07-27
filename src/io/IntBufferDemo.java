package io;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * Created by qinbingbing on 7/27/16.
 */
public class IntBufferDemo {
    public static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(BUFFER_SIZE);
        IntBuffer ib = bb.asIntBuffer();

        ib.put(new int[]{11, 42, 47, 99, 143, 811, 1016});
        System.out.println(ib.get(3));
        ib.put(3, 1811);
        ib.flip();
        while (ib.hasRemaining()) {
            System.out.println(ib.get());
        }
    }
}

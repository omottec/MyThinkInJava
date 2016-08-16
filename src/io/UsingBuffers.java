package io;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/**
 * Created by qinbingbing on 7/27/16.
 */
public class UsingBuffers {
    private static void symmeticScramble(CharBuffer buffer) {
        while (buffer.hasRemaining() && buffer.remaining() > 1) {
            buffer.mark();
            char c1 = buffer.get();
            char c2 = buffer.get();
            buffer.reset();
            buffer.put(c2).put(c1);
        }
    }

    public static void main(String[] args) {
        char[] data = "UsingBuffer".toCharArray();
        ByteBuffer bb = ByteBuffer.allocate(data.length * 2);
        CharBuffer cb = bb.asCharBuffer();
        cb.put(data);
        System.out.println(cb.rewind());
        symmeticScramble(cb);
        System.out.println(cb.rewind());
        symmeticScramble(cb);
        System.out.println(cb.rewind());

    }
}

package io;

import net.mindview.util.IoUtils;

import java.io.*;

/**
 * Created by qinbingbing on 7/28/16.
 */
public class SerialCtl implements Serializable {
    private String a;
    private transient String b;

    public SerialCtl(String aa, String bb) {
        a = "Not Transient: " + aa;
        b = "Transient: " + bb;
    }

    @Override
    public String toString() {
        return a + '\n' + b;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        Thread.dumpStack();
        out.defaultWriteObject();
        out.writeObject(b);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        Thread.dumpStack();
        /*StackTraceElement[] elements = new Throwable().getStackTrace();
        if (elements != null) {
            for (StackTraceElement element : elements)
                System.out.println(element.getClassName() + ":"
                        + element.getMethodName() + ":"
                        + element.getLineNumber());
        }*/
        in.defaultReadObject();
        b = (String) in.readObject();
    }

    public static void main(String[] args) {
        SerialCtl sc = new SerialCtl("Test1", "Test2");
        System.out.println("After constructed:\n" + sc);
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(buf);
            out.writeObject(sc);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IoUtils.close(out);
        }

        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new ByteArrayInputStream(buf.toByteArray()));
            sc = (SerialCtl) in.readObject();
            System.out.println("After restored:\n" + sc);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            IoUtils.close(in);
        }
    }
}

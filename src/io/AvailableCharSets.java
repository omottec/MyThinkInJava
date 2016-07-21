package io;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.SortedMap;

/**
 * Created by qinbingbing on 7/21/16.
 */
public class AvailableCharSets {
    public static void main(String[] args) {
        SortedMap<String, Charset> charsets = Charset.availableCharsets();
        for (SortedMap.Entry<String, Charset> entry : charsets.entrySet()) {
            System.out.print(entry.getKey());
            Charset charset = entry.getValue();
            Iterator<String> it = charset.aliases().iterator();
            if (it.hasNext())
                System.out.print(": ");
            while (it.hasNext()) {
                System.out.print(it.next());
                if (it.hasNext())
                    System.out.print(", ");
            }
            System.out.println();
        }
    }
}

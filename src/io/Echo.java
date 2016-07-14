package io;

import net.mindview.util.IoUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by qinbingbing on 7/14/16.
 */
public class Echo {
    public static void main(String[] args) {
        BufferedReader br = null;
        br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        try {
            while ((s = br.readLine()) != null && !s.isEmpty())
                System.out.println(s.toUpperCase());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IoUtils.close(br);
        }
    }
}

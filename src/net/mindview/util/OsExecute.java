package net.mindview.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by qinbingbing on 7/14/16.
 */
public class OsExecute {
    public static void command(String command) {
        boolean err = false;
        BufferedReader results = null;
        BufferedReader errors = null;
        try {
            Process process = new ProcessBuilder(command.split(" ")).start();
            results = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String s;
            while ((s = results.readLine()) != null)
                System.out.println(s);
            errors = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while ((s = errors.readLine()) != null) {
                System.err.println(s);
                err = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IoUtils.close(results, errors);
        }
        if (err)
            throw new OsException("Errors executing " + command);
    }
}

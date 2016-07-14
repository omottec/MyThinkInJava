package io;

import net.mindview.util.Directory;

import java.io.File;
import java.io.IOException;

/**
 * Created by qinbingbing on 7/14/16.
 */
public class ProcessFiles {
    public interface Strategy {
        void process(File file);
    }
    private Strategy strategy;
    private String ext;

    public ProcessFiles(Strategy strategy, String ext) {
        this.strategy = strategy;
        this.ext = ext;
    }

    public void start(String[] args) {
        if (args.length == 0)
            processDirectoryTree(new File("."));
        else
            for (String arg : args) {
                File fileArg = new File(arg);
                if (fileArg.isDirectory())
                    processDirectoryTree(fileArg);
                else {
                    if (!arg.endsWith("." + ext))
                        arg += "." + ext;
                    try {
                        System.out.println("-----------------------------");
                        System.out.println(new File(arg));
                        strategy.process(new File(arg).getCanonicalFile());
                        System.out.println("-----------------------------");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
    }

    public void processDirectoryTree(File root) {
        Directory.TreeInfo treeInfo = Directory.walk(root.getAbsolutePath(), ".*\\." + ext);
        for (File file : treeInfo)
            strategy.process(file);
    }

    public static void main(String[] args) {
        new ProcessFiles(new Strategy() {
            @Override
            public void process(File file) {
                System.out.println(file);
            }
        }, "java").start(args);
    }
}

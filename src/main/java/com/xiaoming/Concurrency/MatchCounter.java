package com.xiaoming.Concurrency;

import org.apache.poi.ss.formula.functions.T;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class MatchCounter implements Callable<Integer> {

    private File directory;
    private String keyword;

    public MatchCounter(File directory, String keyword) {
        this.directory = directory;
        this.keyword = keyword;
    }

    @Override
    public Integer call() throws Exception {
        Integer count = 0;
        try {
            File[] files = directory.listFiles();
            List<Future<Integer>> result = new ArrayList<>();
            for (File file : files) {
                if (file.isDirectory()) {
                    MatchCounter matchCounter = new MatchCounter(file, keyword);
                    FutureTask<Integer> task = new FutureTask<Integer>(matchCounter);
                    result.add(task);
                    Thread thread = new Thread(task);
                    thread.start();
                } else {
                    if (search(file)) count++;
                }
            }
            for (Future<Integer> future : result) {
                try {
                    count += future.get();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {

        }
        return count;
    }

    public boolean search(File file) {
        try (Scanner in = new Scanner(file, "UTF-8")) {
            boolean found = false;
            while (!found && in.hasNextLine()) {
                String line = in.nextLine();
                if (line.contains(keyword))
                    found = true;
            }
            return found;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}

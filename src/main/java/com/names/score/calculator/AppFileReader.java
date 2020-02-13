package com.names.score.calculator;

import exceptions.FileNameNotFoundException;
import org.apache.commons.lang3.StringUtils;
import java.io.*;
import java.util.*;

public class AppFileReader {

    private static final String SPLIT_BY = ",";

    // returns sortedList
    public List<String> readFile() throws FileNameNotFoundException, IOException {
        List<String> fileContents = new ArrayList<>();
        String fileName = getFileNameFromUser();
        if (!doesFileExist(fileName)) {
            throw new IOException("File " + fileName + " not found.");
        } else {
            // try with resources - java 7
            try (BufferedReader fileBufferReader = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = fileBufferReader.readLine()) != null) {
                    String[] names = line.split(SPLIT_BY);
                    Collections.addAll(fileContents, names);
                }
            }
        }
        return sortList(fileContents);
    }

    public boolean doesFileExist(String fileName) {
        File f = new File(fileName);
        if (f.exists()) {
            return true;
        }
        return false;
    }

    public List<String> sortList(List<String> list) {
        Collections.sort(list); // internally uses mergesort (check the performance )
        return list;
    }

    /*
     this method will only read the filename and returns it *
     for empty filename - will give exception
    */
    public String getFileNameFromUser() throws FileNameNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter file name with full path:");
        String fileName = scanner.nextLine();
        // from commons library ( commons-lang3 )
        if (StringUtils.isBlank(fileName)) {
            throw new FileNameNotFoundException("File name is empty. Please enter file name");
        }
        return fileName;
    }
}



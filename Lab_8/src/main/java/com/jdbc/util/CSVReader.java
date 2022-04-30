package com.jdbc.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVReader {
    private List<List<String>> records = new ArrayList<>();

    public void readCSV(String path){
        parseCSVFile(path);
    }

    private void parseCSVFile(String path){
        boolean first = true;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if(!first){
                    records.add(Arrays.asList(values));
                    /*System.out.println(records);
                    records.clear();*/
                }
                first = false;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }



}

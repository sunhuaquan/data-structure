package com.sun.util.graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ReadGraph {

    public ReadGraph(Graph g, String filename) {
        try {
            File file = new File("E:/work/data-structure/src/" + filename);
            FileInputStream fis = new FileInputStream(file);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fis));
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] split = line.split(" ");

                g.addEdge(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Double.parseDouble(split[2]));
                line = bufferedReader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package main;

import javafx.scene.shape.Line;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Model {
    ArrayList<String> stringLines;
    ArrayList<Line> lines;

    public Model() {
        ArrayList<String> stringLines = readFromFile("/textfiles/large.txt");
        this.lines = lineBuilder(stringLines);
    }

    private ArrayList<String> readFromFile(String filename) {
        stringLines = new ArrayList<>();
        try {
            InputStream stream = Model.class.getResourceAsStream(filename);
            InputStreamReader reader = new InputStreamReader(stream, "UTF-8");
            BufferedReader bf = new BufferedReader(reader);

            while(bf.readLine()!=null){
                stringLines.add(bf.readLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringLines;
    }

    private ArrayList<Line> lineBuilder(ArrayList<String> stringLines) {
        ArrayList<Line> newLines = new ArrayList<>();

        final String lineRegex = "^((?<Type>[a-zA-ZæøåÆØÅ]+)\\s+(?<x1>[0-9.]+?)\\s+(?<y1>[0-9.]+?)\\s(?<x2>[0-9.]+?)\\s+(?<y2>[0-9.]+?))$";
        final Pattern pattern = Pattern.compile(lineRegex);

        for(String line : stringLines){
            final Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {
                if (matcher.group("Type").equals("LINE")) {
                    double x1 = Double.parseDouble(matcher.group("x1"));
                    double y1 = Double.parseDouble(matcher.group("y1"));
                    double x2 = Double.parseDouble(matcher.group("x2"));
                    double y2 = Double.parseDouble(matcher.group("y2"));
                    Line newLine = new Line(x1, y1, x2, y2);
                    newLines.add(newLine);
                }
            }
        }
        return newLines;
    }

    public List<String> getStringLines() { return stringLines; }

    public ArrayList<Line> getLines() {  return lines;  }
}

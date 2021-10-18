/*
* Rezab Ud Dawla
* ID: 011191187
* UNITED INTERNATION UNIVERSITY
*/


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class demoFileReaderWriter {
    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new FileReader("G:\\Study\\Java\\Codes\\src\\input.txt"));
        String line;
        int totalLine = 0;
        int cur = 0;
        List<Integer> list = new ArrayList<>();
        while ((line = b.readLine())!=null){
            if (line.length() == 1) totalLine = Integer.parseInt(line);
            else{
                String[] x = line.split(",");
                if (totalLine == 0) break;
                else{
                    for (String s : x) {
                        cur = cur + Integer.parseInt(s);
                    }
                    list.add(cur);
                    cur = 0;
                    totalLine--;
                }
            }
        }
        b.close();
        PrintWriter p = new PrintWriter(new FileWriter("G:\\Study\\Java\\Codes\\src\\output.txt"));
        for (Integer integer : list) p.println(integer);
        p.close();
    }
}
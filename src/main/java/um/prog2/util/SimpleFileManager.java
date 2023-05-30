package um.prog2.util;

import java.io.*;
import java.util.ArrayList;

/*
 * NO LICENCE
 * Author: Ing. Nicolás Navarro Gutérrez
 */
public class SimpleFileManager
{
    public static void writeFile(String fileName,String[] fileLines)
    {
        FileWriter fw;
        try
        {
            fw = new FileWriter(fileName, true);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < fileLines.length; i++)
            {
                String currentLine = fileLines[i];
                bw.write(currentLine);
                bw.newLine();
            }
            bw.close();
            fw.close();
        }
        catch (IOException e)
        {
            System.out.println("Error writing file " + fileName);
            e.printStackTrace();
        }
    }

    public static String[] readFile(String fileName)
    {
        FileReader fr;
        ArrayList<String> fileLines = new ArrayList<String>();
        try
        {
            fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String currentLine = br.readLine();
            while (currentLine != null)
            {
                fileLines.add(currentLine);
                currentLine = br.readLine();
            }
            br.close();
            fr.close();
        }
        catch (IOException e)
        {
            System.out.println("Error reading file " + fileName);
            e.printStackTrace();
        }

        System.out.println("Read file OK.");

        return fileLines.toArray(new String[0]);
    }
}

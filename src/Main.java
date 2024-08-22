// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Vector;


public class Main {
    public static void main(String[] args) {
        File f = new File("text.txt");
        boolean b; //Эта переменная используется только внутри блока try. Ее объявление лучше подвинуть внутрь блока.
        try {

            b = f.createNewFile();
            if (b) { //Имена надо давать понятные, например, isFileCreated
                System.out.println("File Created!");
            } else {
                System.out.println("File already exists!");
            }
        } catch (IOException e) {
            System.out.println("Error!");
            e.printStackTrace();
        }
        String line; //Объявление можно сделать ближе к использованию.


        Vector<strInf> stroki = new Vector<>();// Лучше использовать ArrayList, т.к. методы вектора - synchronized (для многопоточности, медленные)
        try {
            FileReader readf = new FileReader("text.txt"); //Строковый литерал можно вынести в переменную
            BufferedReader buffread = new BufferedReader(readf);
            line = buffread.readLine();
            while (line != null) {
                strInf stroka = new strInf();
                stroka.Str = line;//Строку можно пережавать в конструктор класса где в том числе может вычисляться длина
                stroka.strLen = line.length();
                stroki.add(stroka);
                line = buffread.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error while reading");
            e.printStackTrace();
        }

        boolean cont = true;
        while (cont) {
            strInf stroka = new strInf();
            cont = false; // Лучше использовать break
            for (int i = 0; i < stroki.size() - 1; i++) {
                if (stroki.get(i + 1).strLen < stroki.get(i).strLen) {
                    stroka = stroki.get(i);
                    stroki.set(i, stroki.get(i + 1));
                    stroki.set(i + 1, stroka);
                    cont = true;
                }
            }
        }

        try {
            FileWriter writer = new FileWriter("rezult.txt");

            for(int j = 0; j < stroki.size(); j++ ) {
                writer.write(stroki.get(j).Str);
                writer.write("\r\n");
            }
            writer.flush();
            writer.close(); //Попробуй try-with-resources + reader тоже надо закрывать.
        }
        catch(IOException e) {
            System.out.println("Error while writing");
            e.printStackTrace();
            System.err.format("IOException: %s%n", e);
        }
    }
}
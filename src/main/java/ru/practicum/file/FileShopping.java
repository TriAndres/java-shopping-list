package ru.practicum.file;

import ru.practicum.model.Shopping;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileShopping {
    private final String file = "src\\main\\java\\ru\\practicum\\file\\Shopping.txt";

    public void setFile(List<Shopping> list) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (Shopping shopping : list) {
                bw.write(String.valueOf(shopping.getId()) + "/" + String.valueOf(shopping.getName()) + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Shopping> getFile() {
        List<Shopping> list = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String s;
            while ((s = br.readLine()) != null) {
               String[] ss = s.split("/");
               list.add(new Shopping(Long.parseLong(ss[0]),ss[1]));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}

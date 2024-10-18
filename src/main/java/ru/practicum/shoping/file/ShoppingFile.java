package ru.practicum.shoping.file;

import ru.practicum.shoping.model.Shopping;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

public class ShoppingFile {
    private final String file = "src\\main\\java\\ru\\practicum\\shoping\\file\\Shopping.txt";

    public void setFile(Collection<Shopping> list) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (Shopping shopping : list) {
                bw.write(shopping.toString() + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Collection<Shopping> getFile() {
        Collection<Shopping> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String s;
            while ((s = br.readLine()) != null) {
                String[] ss = s.split("/");
                list.add(new Shopping(Long.parseLong(ss[0]), ss[1]));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
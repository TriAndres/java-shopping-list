package ru.practicum.file;

import ru.practicum.model.Shopping;
import ru.practicum.repository.ShoppingRepositoryImpl;

import java.io.*;
import java.util.Collection;

public class ShoppingFile extends ShoppingRepositoryImpl {
    private final String file;

    public ShoppingFile(String file) {
        this.file = file;
    }

    private void saveShopping() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Shopping shopping : findAll()) {
                writer.write(shopping.toString());
                writer.write("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Collection<Shopping> findAll() {
        return super.findAll();
    }

    @Override
    public Shopping save(Shopping shopping) {
        Shopping shopping1 = super.save(shopping);
        saveShopping();
        return shopping1;
    }

    @Override
    public void deleteAll() {
        super.deleteAll();
    }

    public static ShoppingFile loadFromFile(String file) {
        ShoppingFile shoppingFile = new ShoppingFile(file);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split("/");
                shoppingFile.save(
                        new Shopping(
                                Long.parseLong(row[0]),
                                row[1]
                        )
                );
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return shoppingFile;
    }
}
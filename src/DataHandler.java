import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import static java.util.Comparator.comparing;


public class DataHandler {

    // Method to create a list of Order objects from a JSON file
    public ArrayList<Order> createListOfOrderFromJsonFile(String filePath) throws IOException {

        String content = Files.readString(Paths.get(filePath));
        Type listType = new TypeToken<ArrayList<Order>>() {
        }.getType();
        ArrayList<Order> orders = new Gson().fromJson(content, listType);
        orders.remove(0);
        return orders;
    }
    // Method to create a list of Order objects from a CSV file
    public ArrayList<Order> createListOfOrderFromCsvFile(String filePath) throws IOException {

        ArrayList<Order> orders = new ArrayList<>();
        String line = null;

        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String totalCost = "";

        while ((line = bufferedReader.readLine()) != null) {
            // Split the line into an array of strings using a comma
            String[] temp = line.split(",");
            String orderDate = temp[0];
            String region = temp[1];
            String rep1 = temp[2];
            String rep2 = temp[3];
            String item = temp[4];
            String units = temp[5];
            String unitCost = temp[6];
            if (temp.length > 7) {
                totalCost = temp[7];
            }

            // Create an Order object and add it to the ArrayList
            orders.add(new Order(orderDate, region, rep1, rep2, item, units, unitCost, totalCost));
        }
        bufferedReader.close();
        orders.remove(0);
        return orders;
    }
    // Method to sort the ArrayList of Order objects by region alphabetically
    public void sortRegionAlpabetically(ArrayList<Order> orders) {
        Collections.sort(orders, comparing(Order::getRegion));
    }
}
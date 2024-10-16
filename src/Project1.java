import java.util.List;
import java.util.ArrayList;
import java.io.*;
import javax.swing.*;
import java.awt.*;

public class Project1 {
    public static void main(String[] args) {
        Appliance[] appliances = new Appliance[100];  // Partially-filled array
        int count = 0;

        // Reading serial numbers from the input file
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                appliances[count] = new Appliance(line);
                count++;
            }
        } catch (IOException e) {
            System.out.println("Error reading file.");
            return;
        }

        // Sort and classify appliances
        List<Appliance> refrigerators = new ArrayList<>();
        List<Appliance> dishwashers = new ArrayList<>();
        List<Appliance> microwaves = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            Appliance appliance = appliances[i];
            char type = appliance.getSerialNumber().charAt(0);
            if (type == 'R') {
                refrigerators.add(appliance);
            } else if (type == 'D') {
                dishwashers.add(appliance);
            } else if (type == 'M') {
                microwaves.add(appliance);
            }
        }

        // Sort each list using Selection Sort
        sortList(refrigerators);
        sortList(dishwashers);
        sortList(microwaves);

        // Create GUI
        JFrame frame = new JFrame("Appliance Display");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(1, 3));

        JTextArea fridgeArea = new JTextArea();
        JTextArea dishwasherArea = new JTextArea();
        JTextArea microwaveArea = new JTextArea();

        for (Appliance appliance : refrigerators) {
            fridgeArea.append(appliance.toString() + "\n");
        }

        for (Appliance appliance : dishwashers) {
            dishwasherArea.append(appliance.toString() + "\n");
        }

        for (Appliance appliance : microwaves) {
            microwaveArea.append(appliance.toString() + "\n");
        }

        frame.add(new JScrollPane(fridgeArea));
        frame.add(new JScrollPane(dishwasherArea));
        frame.add(new JScrollPane(microwaveArea));

        frame.setSize(600, 300);
        frame.setVisible(true);
    }

    // Selection sort helper method
    private static void sortList(List<Appliance> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).compareTo(list.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            // Swap
            Appliance temp = list.get(minIndex);
            list.set(minIndex, list.get(i));
            list.set(i, temp);
        }
    }
}

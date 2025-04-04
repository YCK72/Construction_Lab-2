import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList; 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main {
    public static void main(String[] args) {
        String filePath = System.getProperty("data");
        if (filePath == null) {
            System.out.println("Please specify the JSON file path using the 'data' system property.");
            return;
        }

        List<IVehicle> vehicles = parseVehiclesFromFile(filePath);
        if (vehicles == null) {
            System.out.println("Error parsing vehicles.");
            return;
        }

        // Display vehicle info
        vehicles.forEach(System.out::println);

        // Calculate and print total cost
        int totalCost = new VehicleService().calculateTotal(vehicles);
        System.out.println("Total Service Charge: $" + totalCost);
    }

    private static List<IVehicle> parseVehiclesFromFile(String filePath) {
        List<IVehicle> vehicles = new ArrayList<>();
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader(filePath)) {
            JSONArray jsonArray = (JSONArray) parser.parse(reader);

            for (Object obj : jsonArray) {
                JSONObject vehicleObj = (JSONObject) obj;
                String vtype = (String) vehicleObj.get("vtype");

                IVehicle vehicle = createVehicleFromJson(vtype, vehicleObj);
                if (vehicle != null) {
                    vehicles.add(vehicle);
                } else {
                    System.out.println("Unknown vehicle type: " + vtype);
                }
            }
        } catch (IOException | ParseException e) {
            System.err.println("Error reading or parsing the file: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
        return vehicles;
    }

    private static IVehicle createVehicleFromJson(String vtype, JSONObject vehicleObj) {
        switch (vtype.trim()) {
            case "Car":
                return new Car((String) vehicleObj.get("color"), Integer.parseInt((String) vehicleObj.get("myear")));
            case "Van":
                return new Van(Integer.parseInt((String) vehicleObj.get("storage")), Integer.parseInt((String) vehicleObj.get("numdoors")));
            case "Motorbike":
                return new Motorbike(Integer.parseInt((String) vehicleObj.get("engine")), (String) vehicleObj.get("brand"));
            default:
                return null;
        }
    }
}

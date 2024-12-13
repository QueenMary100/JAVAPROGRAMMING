
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetworkInfo {
    public static void main(String[] args) {
        try {
            // Get Hostname
            String hostname = InetAddress.getLocalHost().getHostName();
            System.out.println("Hostname: " + hostname);

            // Get IP Address
            String ipAddress = InetAddress.getLocalHost().getHostAddress();
            System.out.println("IP Address: " + ipAddress);

            // Get Wi-Fi Name
            String wifiName = getWiFiName();
            System.out.println("Wi-Fi Name: " + wifiName);

            // Get Current Location
            String location = getCurrentLocation();
            System.out.println("Current Location: " + location);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getWiFiName() {
        try {
            Process process = Runtime.getRuntime().exec("netsh wlan show interfaces");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().startsWith("SSID")) {
                    return line.split(":")[1].trim();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Wi-Fi Name Not Found";
    }

    private static String getCurrentLocation() {
        try {
            // Replace with your chosen API URL (e.g., IP-API, Google Geolocation API)
            String apiUrl = "http://ip-api.com/json/";
            HttpURLConnection connection = (HttpURLConnection) new URL(apiUrl).openConnection();
            connection.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            return response.toString(); // Return the JSON response
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Location Not Found";
    }
}

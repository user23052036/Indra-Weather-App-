import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

class API
{
    
    private static final String API_key = "e01eaa6b5b05805bea9572f6e4e70208";
    //private static final HttpClient client = HttpClient.newHttpClient(); set with default settings
    private static final HttpClient client = HttpClient.newBuilder()
                                            .version(HttpClient.Version.HTTP_2)
                                            .connectTimeout(Duration.ofSeconds(10))
                                            .build();    
    
    public static String getWeatherData(String city) 
    {
        String url = "http://api.weatherstack.com/current?access_key="+API_key+
                     "&query="+city+
                     "&units=m"; // optional parameters

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        try 
        {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            // You can add more error handling here based on response.statusCode()
            return response.body();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
public class Demo_API
{
    public static void main(String[] args) 
    {
        String weather_Data = API.getWeatherData("Kolkata");
        System.out.println(weather_Data);
    }
}
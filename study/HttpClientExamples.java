import java.net.URI;
import java.time.Duration;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientExamples 
{
    private static final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    public static void main(String[] args) throws Exception 
    {
        getExample();
        postExample();
        putExample();
        deleteExample();
    }

    // GET Request
    public static void getExample() throws Exception 
    {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts/1"))
                .build();

        HttpResponse<String> response = httpClient.send(
                request, HttpResponse.BodyHandlers.ofString());

        System.out.println("GET Response Code: " + response.statusCode());
        System.out.println("GET Response Body: " + response.body());
    }

    // POST Request
    public static void postExample() throws Exception 
    {
        String json = """
            {
                "title": "foo",
                "body": "bar",
                "userId": 1
            }""";

        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts"))
                .header("Content-Type", "application/json")
                .build();

        HttpResponse<String> response = httpClient.send(
                request, HttpResponse.BodyHandlers.ofString());

        System.out.println("\nPOST Response Code: " + response.statusCode());
        System.out.println("POST Response Body: " + response.body());
    }

    // PUT Request
    public static void putExample() throws Exception 
    {
        String json = """
            {
                "id": 1,
                "title": "updated title",
                "body": "updated body",
                "userId": 1
            }""";

        HttpRequest request = HttpRequest.newBuilder()
                .PUT(HttpRequest.BodyPublishers.ofString(json))
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts/1"))
                .header("Content-Type", "application/json")
                .build();

        HttpResponse<String> response = httpClient.send(
                request, HttpResponse.BodyHandlers.ofString());

        System.out.println("\nPUT Response Code: " + response.statusCode());
        System.out.println("PUT Response Body: " + response.body());
    }

    // DELETE Request
    public static void deleteExample() throws Exception 
    {
        HttpRequest request = HttpRequest.newBuilder()
                .DELETE()
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts/1"))
                .build();

        HttpResponse<String> response = httpClient.send(
                request, HttpResponse.BodyHandlers.ofString());

        System.out.println("\nDELETE Response Code: " + response.statusCode());
        System.out.println("DELETE Response Body: " + response.body());
    }
}

import org.json.JSONObject;
import org.json.JSONArray;

public class Demo_JSON 
{
    public static void main(String[] args) 
    {
        JSONObject obj = new JSONObject();
        JSONArray arr = new JSONArray();

        arr.put("games");
        arr.put(false);
        arr.put(JSONObject.NULL);
        arr.put("money");

        obj.put("name","sonu");
        obj.put("isStudent","false");
        obj.put("dead",JSONObject.NULL);
        obj.put("random array ",arr);
        obj.put("skills", new JSONArray().put("Java").put("Python"));

        System.out.println(arr);
        System.out.println(obj);
    }
}

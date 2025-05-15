import org.json.JSONObject;
import org.json.JSONArray;
import org.json.XML;

class JSON2xml 
{
    public static void main(String[] args) 
    {  
        String json = "{\"website\":{\"address\":[{\"area\":\"Mumbai\",\"plot\":53,\"type\":\"office\",\"sector\":20},{\"area\":\"Navi Mumbai\",\"plot\":35,\"type\":\"hq\",\"sector\":10}],\"serverDetails\":{\"hostingStatus\":\"active\",\"serverOS\":\"Linux\"},\"phone\":[12345,54321,\"098765\",999888],\"author\":\"Zartab Nakhwa\",\"name\":\"1LineCode\",\"url\":\"www.1LineCode.com\"}}";
        
        JSONObject obj = new JSONObject(json);
        String xml = XML.toString(obj);
        System.out.println(xml);


        System.out.println("\n\n-------parshing data if JSON file----------\n\n");
        JSONObject obj_web = obj.getJSONObject("website");
        JSONArray array = obj_web.getJSONArray("address");

        System.out.println("ADDRESS");
        for(int i=0; i<array.length(); i++)
        {
            JSONObject sub_obj = array.getJSONObject(i);

            String area = sub_obj.getString("area");
            int plot = sub_obj.getInt("plot");
            String type = sub_obj.getString("type");
            int sector = sub_obj.getInt("sector");

            System.out.println("area: "+area+"\nplot: "+plot+"\ntype: "+type+"\nsector: "+sector);
        }
    }
}

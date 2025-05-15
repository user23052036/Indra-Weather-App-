import org.json.JSONObject;
import org.json.XML;

class xml2JSON
{
    public static void main(String[] args) 
    {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><website><address><area>Mumbai</area><plot>53</plot><type>office</type><sector>20</sector></address><address><area>Navi Mumbai</area><plot>35</plot><type>hq</type><sector>10</sector></address><serverDetails><hostingStatus>active</hostingStatus><serverOS>Linux</serverOS></serverDetails><phone>12345</phone><phone>54321</phone><phone>098765</phone><phone>999888</phone><author>Zartab Nakhwa</author><name>1LineCode</name><url>www.1LineCode.com</url></website>";

        JSONObject obj = XML.toJSONObject(xml);
        String json = obj.toString();
        System.out.println(json);
    }
}
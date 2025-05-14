import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class weatherGUI extends JFrame
{
    weatherGUI()
    {
        super("Indra");
        setSize(450,650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);

        addComponents();
    }
    private void addComponents()
    {
        //adding the TextField
        JTextField search_text = new JTextField();
        search_text.setBounds(15,15,350,45);
        search_text.setFont(new Font("Dialog",Font.PLAIN,25));
        add(search_text);


        //change the cursor to hand-cursor
        JButton search_btn = new JButton(LoadImage("indra\\src\\assets\\search.png"));
        search_btn.setBounds(365,15,55,45);
        search_btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(search_btn);


        //add weather Image
        JLabel weather_img = new JLabel(LoadImage("indra\\src\\assets\\rain.png"));
        weather_img.setBounds(0,120,450,200);
        weather_img.setHorizontalAlignment(SwingConstants.CENTER);
        add(weather_img);


        //temperature text
        JLabel temp_text = new JLabel("10°C");
        temp_text.setBounds(0,330,450,50);
        temp_text.setFont(new Font("Dialog",Font.BOLD,40));
        temp_text.setHorizontalAlignment(SwingConstants.CENTER);
        add(temp_text);


        // weather condition description
        JLabel weather_desc = new JLabel("Cloudy");
        weather_desc.setBounds(0, 370, 450, 36);
        weather_desc.setFont(new Font("Dialog", Font.PLAIN, 32));
        weather_desc.setHorizontalAlignment(SwingConstants.CENTER);
        add(weather_desc);


        // humidity image
        JLabel humidityImage = new JLabel(LoadImage("indra\\src\\assets\\humidity.png"));
        humidityImage.setBounds(0, 500, 75, 70);
        add(humidityImage);

        
        // humidity text
        JLabel humidityText = new JLabel("<html><b>Humidity</b> 100%</html>");
        humidityText.setBounds(75, 500, 95, 60);
        humidityText.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(humidityText);

        // windspeed image
        JLabel windspeedImage = new JLabel(LoadImage("indra\\src\\assets\\windspeed.png"));
        windspeedImage.setBounds(235, 500, 80, 70);
        add(windspeedImage);


        // windspeed text
        JLabel windspeedText = new JLabel("<html><b>Windspeed</b> 15km/h</html>");
        windspeedText.setBounds(320, 500, 125, 60);
        windspeedText.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(windspeedText);

    }

    private ImageIcon LoadImage(String path)
    {
        try
        {
            BufferedImage image = ImageIO.read(new File(path));
            return new ImageIcon(image);

        } catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("Could not find resource");
        return null;
    }
}
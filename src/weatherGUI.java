import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class weatherGUI extends JFrame implements ActionListener
{
    private JLabel weather_img,temp_text,weather_desc,humidityImage,humidityText,windspeedImage,windspeedText;
    private JTextField search_text;
    private JButton search_btn;

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
        search_text = new JTextField();
        search_text.setBounds(15,15,350,45);
        search_text.setFont(new Font("Dialog",Font.PLAIN,25));
        add(search_text);


        //change the cursor to hand-cursor
        search_btn = new JButton(LoadImage("indra\\src\\assets\\search.png"));
        search_btn.setBounds(365,15,55,45);
        search_btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(search_btn);


        //add weather Image
        weather_img = new JLabel(LoadImage("indra\\src\\assets\\rain.png"));
        weather_img.setBounds(0,120,440,190);
        weather_img.setHorizontalAlignment(SwingConstants.CENTER);
        add(weather_img);


        //temperature text
        temp_text = new JLabel("10°C");
        temp_text.setBounds(0,330,450,50);
        temp_text.setFont(new Font("Dialog",Font.BOLD,40));
        temp_text.setHorizontalAlignment(SwingConstants.CENTER);
        add(temp_text);


        // weather condition description
        weather_desc = new JLabel("Cloudy");
        weather_desc.setBounds(0, 370, 450, 36);
        weather_desc.setFont(new Font("Dialog", Font.PLAIN, 25));
        weather_desc.setHorizontalAlignment(SwingConstants.CENTER);
        add(weather_desc);


        // humidity image
        humidityImage = new JLabel(LoadImage("indra\\src\\assets\\humidity.png"));
        humidityImage.setBounds(0, 500, 75, 70);
        add(humidityImage);

        
        // humidity text
        humidityText = new JLabel("<html><b>Humidity</b> 100%</html>");
        humidityText.setBounds(75, 500, 95, 60);
        humidityText.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(humidityText);

        // windspeed image
        windspeedImage = new JLabel(LoadImage("indra\\src\\assets\\windspeed.png"));
        windspeedImage.setBounds(235, 500, 80, 70);
        add(windspeedImage);


        // windspeed text
        windspeedText = new JLabel("<html><b>Windspeed</b> 15km/h</html>");
        windspeedText.setBounds(320, 500, 125, 60);
        windspeedText.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(windspeedText);


        //logic part integrating front-end and back-end
        search_btn.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String location = search_text.getText();

        String condition = WeatherAPI.WeatherCondition(WeatherAPI.WeatherData(location));
        weather_img.setIcon(LoadImage("indra\\src\\assets\\"+condition+".png"));
        temp_text.setText(Integer.toString(WeatherAPI.temperature)+"°C");
        weather_desc.setText(WeatherAPI.weather_descriptions);

        windspeedText.setText("<html><b>Windspeed</b><br>"+WeatherAPI.wind_speed+"km/h</html>");
        humidityText.setText("<html><b>Humidity</b><br>"+WeatherAPI.humidity+"%</html>");
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
import javax.swing.SwingUtilities;

class AppLauncher 
{
    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(new Runnable() 
        {
            @Override
            public void run()
            {
                //displays weather gui app
                new weatherGUI().setVisible(true);
            }
            
        });    
    }
}

import java.awt.Window;

import javax.swing.JFrame;

public class Login extends JFrame {

    public Login() {
        setup();
        
    }
    private void setup(){
        setTitle("Login Page");
        setBounds(0, 0, Window.WIDTH, Window.HEIGHT);
        setVisible(true);
    }

}

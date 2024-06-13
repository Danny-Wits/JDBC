import javax.swing.JFrame;

public class LoginPage extends JFrame{
    private void setUp(){
       setTitle("LoginPage");
       setBounds(100,100,500,700);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setVisible(true); 
    }
    LoginPage(){
        setUp();
    }
    
}

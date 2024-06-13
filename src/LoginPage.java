import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class LoginPage extends JFrame{
    private JTextField nameI,passwordI;
    private void setUp(){
       setTitle("LoginPage");
       setBounds(100,100,500,700);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    LoginPage(){
        setUp();
        JPanel header = new JPanel();
        JLabel title = new JLabel("WELCOME TO BCA CENTRE");
        

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(2,2));
        //Name 
        JLabel nameL=new JLabel("NAME : ");
        nameI=new JTextField();

        //Password
        JLabel passwordL=new JLabel("PASSWORD : ");
        passwordI=new JTextField();
        
        center.add(nameL);
        center.add(nameI);
        center.add(passwordL);
        center.add(passwordI);
        
        add(center,BorderLayout.CENTER);
        setVisible(true);
    }
    
}

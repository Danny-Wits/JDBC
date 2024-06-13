import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginPage extends JFrame implements ActionListener {
    private JTextField nameI, passwordI;

    private void setUp() {
        setTitle("LoginPage");
        setBounds(100, 100, 500, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    LoginPage() {
        setUp();
        JPanel header = new JPanel();
        JLabel title = new JLabel("WELCOME TO BCA CENTRE");
        title.setFont(new Font("DIGIFACE", 0, 40));
        header.add(title);
        add(header, BorderLayout.NORTH);

        JPanel center = new JPanel();
        center.setLayout(null);
        // Name
        JLabel nameL = new JLabel("NAME : ");
        nameL.setBounds(10, 50, 400, 100);
        nameI = new JTextField();
        nameI.setBounds(10, 150, 400, 50);
        // Password
        JLabel passwordL = new JLabel("PASSWORD : ");
        passwordL.setBounds(10, 250, 400, 100);
        passwordI = new JTextField();
        passwordI.setBounds(10, 350, 400, 50);

        // SUBMIT

        JButton submit = new JButton("LOGIN?SIGNUP");
        submit.setFont(new Font("DIGIFACE", 0, 32));
        submit.setBounds(50, 450, 300, 100);
        submit.addActionListener(this);

        center.add(nameL);
        center.add(nameI);
        center.add(passwordL);
        center.add(passwordI);
        center.add(submit);
        add(center, BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = nameI.getText();
        String password = passwordI.getText();

        // data base connection
        Connection connection = DataBase.setConnection();

        // TODO Double check
        ResultSet r = null;
        String query = String.format("SELECT * FROM login_detail WHERE name='%s'", name);
        var list = DataBase.run(connection, query, r);
        if (list.size() == 1) {
            String hasPass = Integer.toString(stringEnc(password));
            if (list.get(0).get(2).equals(password)) {
              message("password match");
              }else{
                message("password no no ");
            }
        } else {

        }
        // TODO ADD - name passHash

       
        // TODo login in
    }

    private int stringEnc(String input) {
        return input.hashCode();
    }
    
    private void message(String msg){
        JOptionPane.showMessageDialog(this,msg);
    }
}

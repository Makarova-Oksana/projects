import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame {//Лишнее?
    public int result = 0;
    public App() {
        setTitle("Calculator");
        result = 0;
        JPanel panel = new JPanel();
       // panel.setLayout(new FlowLayout());
        JButton plus = new JButton("+");
        JButton minus = new JButton("-");
        JButton multiply = new JButton("*");
        JButton division = new JButton("/");

        JLabel RES = new JLabel(String.valueOf(result));
        JLabel operaton = new JLabel("?");
        JLabel equal = new JLabel("=");
        JTextField a = new JTextField("");
        JTextField b = new JTextField("");

        ActionListener listenerPlus = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x1 = Integer.parseInt(a.getText());
                int x2 = Integer.parseInt(b.getText());
                result = x1 + x2;
                RES.setText(String.valueOf(result));
                operaton.setText("+");

            }
        };
        ActionListener listenerMinus = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               int x1 = Integer.parseInt(a.getText());
               int x2 = Integer.parseInt(b.getText());
               result = x1 - x2;
               RES.setText(String.valueOf(result));
               operaton.setText("-");
            }
        };
        ActionListener listenerMultiply = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                int x1 = Integer.parseInt(a.getText());
                int x2 = Integer.parseInt(b.getText());
                result = x1 * x2;
                RES.setText(String.valueOf(result));
                operaton.setText("*");
            }

        };
        ActionListener listenerDivision = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               int x1 = Integer.parseInt(a.getText());
               int x2 = Integer.parseInt(b.getText());
               result = x1/x2;
               RES.setText(String.valueOf(result));
               operaton.setText("/");
            }
        };


        //set ActionListeners to buttons
        plus.addActionListener(listenerPlus);
        minus.addActionListener(listenerMinus);
        multiply.addActionListener(listenerMultiply);
        division.addActionListener(listenerDivision);
        // set Bounds
        plus.setBounds(0,0,30,70);
        minus.setBounds(102,50,50,50);
        multiply.setBounds(154,50,50,50);
        division.setBounds(208,50,50,50);
        panel.setSize(new Dimension( 600, 600));
        //adds
        add(panel);
        panel.add(RES);
        panel.add(plus);
        panel.add(minus);
        panel.add(multiply);
        panel.add(division);
        panel.add(a);
        panel.add(b);



        setPreferredSize(new Dimension(600,600));
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();


    }
}

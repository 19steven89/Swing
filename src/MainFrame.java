import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{

    private JTextArea txtArea;
    private JButton btn;

    public MainFrame() {
        super("title1");
        setLayout(new BorderLayout());

        txtArea = new JTextArea();
        btn = new JButton("Click");

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtArea.append("Hello\n");
            }
        });

        add(txtArea, BorderLayout.CENTER);
        add(btn, BorderLayout.SOUTH);
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

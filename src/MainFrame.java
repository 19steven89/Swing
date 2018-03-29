import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{

    private TextPanel textPanel;
    private Toolbar toolbar;
    private FormPanel formPanel;

    public MainFrame() {
        super("title1");
        setLayout(new BorderLayout());

        toolbar = new Toolbar();
        textPanel = new TextPanel();
        formPanel = new FormPanel();

        toolbar.setStringListener(new StringListener() {
            @Override
            public void textEmitted(String text) {
                textPanel.appendTxt(text);
            }
        });

        formPanel.setFormListener(new FormListener(){
            @Override
            public void formEventOccurred(FormEvent ev){
                String name = ev.getName();
                String occupation = ev.getOccupation();

                textPanel.appendTxt(name + ": " + occupation + "\n");
            }
        });

        add(formPanel, BorderLayout.WEST);
        add(textPanel, BorderLayout.CENTER);
        add(toolbar, BorderLayout.NORTH);
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

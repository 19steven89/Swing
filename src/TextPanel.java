import javax.swing.*;
import java.awt.*;

public class TextPanel extends JPanel{

    private JTextArea txtArea;

    public TextPanel(){
        txtArea = new JTextArea();
        setLayout(new BorderLayout());

        //add scroll pane to the text area
        add(new JScrollPane(txtArea), BorderLayout.CENTER);
    }

    public void appendTxt(String text){
        txtArea.append(text);
    }

}

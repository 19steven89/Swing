import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Toolbar extends JPanel implements ActionListener{

    private JButton hbtn;
    private JButton gbtn;
    private StringListener txtlistener;

    /**
     * constructor adds 2 buttons to the JPanel using flow layout
     */
    public Toolbar(){
        setBorder(BorderFactory.createEtchedBorder());
        hbtn = new JButton("Hello");
        gbtn = new JButton("Goodbye");
        hbtn.addActionListener(this);
        gbtn.addActionListener(this);

        //set the buttons to be added to the left of the frame
        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(hbtn);
        add(gbtn);
    }

    public void setStringListener(StringListener listener){
        this.txtlistener = listener;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //get the button clicked by user by accessing e source
        JButton clicked = (JButton) e.getSource();

        if(clicked == hbtn){
            if(txtlistener != null){
                txtlistener.textEmitted("Hello\n");
            }
        }else if(clicked == gbtn){
            if(txtlistener != null){
                txtlistener.textEmitted("Goodbye\n");
            }

        }
    }
}

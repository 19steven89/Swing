import sun.java2d.loops.GeneralRenderer;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormPanel extends JPanel {

    private JLabel nameLabel;
    private JLabel occupationLabel;
    private JTextField nameField;
    private JTextField occField;
    private JButton okBtn;
    private FormListener formListener;

    public FormPanel(){
        nameLabel = new JLabel();
        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);
        Border innerBorder = BorderFactory.createTitledBorder("Add Person");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        nameLabel = new JLabel("Name: ");
        occupationLabel = new JLabel("Occupation: ");
        //10 characters wide
        nameField = new JTextField(10);
        occField = new JTextField(10);
        okBtn = new JButton("OK");

        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String occupation = occField.getText();

                FormEvent ev = new FormEvent(this, name, occupation);

                if(formListener != null){
                    formListener.formEventOccurred(ev);
                }
            }
        });

        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        //weight controls how much space it takes up relative to the other cells
        gbc.weightx = 1;
        gbc.weighty = 0.1;

        /**
         * first Row
         */
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.NONE;
        //using anchor to force label to left side, i.e. LINE_END
        gbc.anchor = GridBagConstraints.LINE_END;
        //inset used to create space between label and text field
        gbc.insets = new Insets(0, 0, 0, 5);
        add(nameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.anchor = GridBagConstraints.LINE_START;
        add(nameField, gbc);


        /**
         * 2nd Row
         */
        gbc.weightx = 1;
        gbc.weighty = 0.1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 0, 5);
        gbc.anchor = GridBagConstraints.LINE_END;
        add(occupationLabel, gbc);

        gbc.gridy = 1;
        gbc.gridx = 1;
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.anchor = GridBagConstraints.LINE_START;
        add(occField, gbc);

        /**
         * 3rd Row
         */
        gbc.weightx = 1;
        gbc.weighty = 2;
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(okBtn, gbc);

    }

    public void setFormListener(FormListener listener){
        this.formListener = listener;
    }
}

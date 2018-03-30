package com.company;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This method describe GUI and method for button
 * @Author Shvingelskiy Evgeniy
 * @since 1.0
 * @version 1.0
 */

public class LabGUI extends JFrame {

    private JLabel labelGrad = new JLabel("Градусы");
    private JLabel labelRad = new JLabel("Радианы");
    private JLabel textAngle = new JLabel(" ");
    private JButton buttonGrad = new JButton("Посчитать градусы");
    private JButton buttonRad = new JButton("Посчитать радианы");
    private JTextField inputGrad = new JTextField();
    private JTextField inputRad = new JTextField();


    public LabGUI() {

        this.setBounds(200, 200, 300, 140);
        //super.setSize(300,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridBagLayout());


        this.add(labelGrad, new GridBagConstraints(0,0,1,1,
                1,1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2,2,2,2),0,0));

        this.add(inputGrad, new GridBagConstraints(1,0,1,1,
                1,1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2,-65,2,2),0,0));

        this.add(labelRad, new GridBagConstraints(0,1,1,1,
                1,1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2,2,2,2),0,0));

        this.add(inputRad, new GridBagConstraints(1,1,1,1,
                1,1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2,-65,2,2),0,0));

        this.add(textAngle, new GridBagConstraints(0,2,2,1,
                1,1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2,2,2,2),0,0));

        this.add(buttonGrad, new GridBagConstraints(0,3,1,1,
                1,1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2,2,2,2),0,0));

        this.add(buttonRad, new GridBagConstraints(1,3,1,1,
                1,1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2,2,2,2),0,0));

        // реализация действия кнопки
        buttonGrad.addActionListener(new ButtonGradEventListener());
        buttonRad.addActionListener(new ButtonRadEventListener());

        this.setVisible(true);
        this.pack(); // убирает лишнее пространство */

    }


    class ButtonGradEventListener implements ActionListener {
        /**
         * This method converts radians to degrees
         * @Author Shvingelskiy Evgeniy
         * @since 1.0
         * @version 1.0
         */
        public void actionPerformed(ActionEvent e) {
            double angle = Double.parseDouble(inputRad.getText());  // перевод в дабл радиан
            inputGrad.setText(String.valueOf(angle * 57.2958)); // устанавливаем значение в град
            outputTypeOfAngle(angle * 57.2958);
        }
    }

    class ButtonRadEventListener implements ActionListener {
        /**
         * This method converts degrees to radians
         * @Author Shvingelskiy Evgeniy
         * @since 1.0
         * @version 1.0
         */
        public void actionPerformed(ActionEvent e) {
            double angle = Double.parseDouble(inputGrad.getText());
            inputRad.setText(String.valueOf(angle / 57.2958)); // устанавливаем значение в рад
            outputTypeOfAngle(angle);
        }
    }

    public void outputTypeOfAngle(double ang) {
        /**
         * This method output type of angle
         * @Author Shvingelskiy Evgeniy
         * @since 1.0
         * @version 1.0
         */
        if (ang > 90)
            textAngle.setText("Тупой угол");
        if (ang < 90)
            textAngle.setText("Острый угол");
    }
}











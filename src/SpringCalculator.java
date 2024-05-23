import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpringCalculator {
    private JFrame frame;
    private JTextField speedField;
    private JTextField radiusField;
    private JButton calculateButton;
    private JLabel resultLabel;

    public SpringCalculator() {
        frame = new JFrame("Калькулятор розрахунку умови плаваннмя тіла ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new GridLayout(4, 2));

        JLabel speedLabel = new JLabel("Об'єм в м^3 (V):");
        speedField = new JTextField();
        JLabel radiusLabel = new JLabel("Густина кг/м^3 (p):");
        radiusField = new JTextField();
        calculateButton = new JButton("Розрахувати");
        resultLabel = new JLabel("");

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateForce();
            }
        });

        frame.add(speedLabel);
        frame.add(speedField);
        frame.add(radiusLabel);
        frame.add(radiusField);
        frame.add(calculateButton);
        frame.add(resultLabel);
    }

    public void show() {
        frame.setVisible(true);
    }

    private void calculateForce() {
        try {
            double speed = Double.parseDouble(speedField.getText());
            double radius = Double.parseDouble(radiusField.getText());
            double force = radius * 9.8 * speed ;
            resultLabel.setText("Сила Архімеда (F): "  + force);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Введіть числові значення для густина та об'єм.", "Помилка", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SpringCalculator calculator = new SpringCalculator();
                calculator.show();
            }
        });
    }
}
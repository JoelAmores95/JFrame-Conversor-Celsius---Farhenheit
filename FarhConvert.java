import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FarhConvert extends JFrame implements ActionListener {

    JLabel heading = new JLabel("Conversor de Temperatura");
    JLabel inLabel = new JLabel("Grados Fahrenheit: ");
    JLabel outLabel = new JLabel("Grados Celsius: ");

    // Creamos los tres botones necesarios
    JButton fToCButton = new JButton("Convertir Fahrenheit a Celsius");
    JButton cToFButton = new JButton("Convertir Celsius a Fahrenheit");
    JButton clearButton = new JButton("Limpiar");

    JTextField inField = new JTextField(7);
    JTextField outField = new JTextField(7);

    int fTemp;
    int cTemp;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fToCButton) {
            // Si se ha hecho clic en el botón "Convertir Fahrenheit a Celsius"
            String userIn = inField.getText();
            fTemp = Integer.parseInt(userIn);

            cTemp = (int) ((fTemp - 32) * 5.0 / 9.0); // Convertir Fahrenheit a Celsius
            outField.setText(cTemp + "");
        } else if (e.getSource() == cToFButton) {
            // Si se ha hecho clic en el botón "Convertir Celsius a Fahrenheit"
            String userIn = outField.getText();
            cTemp = Integer.parseInt(userIn);

            fTemp = (int) (cTemp * 9.0 / 5.0 + 32); // Convertir Celsius a Fahrenheit
            inField.setText(fTemp + "");
        } else if (e.getSource() == clearButton) {
            // Si se ha hecho clic en el botón "Limpiar"
            inField.setText("");
            outField.setText("");
        }
    }

    public FarhConvert(String title) {
        super(title);
        setLayout(new FlowLayout());

        inField.addActionListener(this);

        // Añadimos los tres ActionListeners a los botones correspondientes
        fToCButton.addActionListener(this);
        cToFButton.addActionListener(this);
        clearButton.addActionListener(this);

        add(heading);
        add(inLabel);
        add(outLabel);
        add(inField);
        add(outField);

        // Añadimos los tres botones
        add(fToCButton);
        add(cToFButton);
        add(clearButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        FarhConvert temperature = new FarhConvert("Conversor de Temperatura");

        temperature.setSize(250, 200);
        temperature.setVisible(true);
    }
}

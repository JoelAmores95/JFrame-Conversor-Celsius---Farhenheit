import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ConversorTemperatura extends JFrame implements ActionListener {

    // Crear etiquetas
    JLabel titulo = new JLabel("Conversor de Temperatura");
    JLabel etiquetaEntrada = new JLabel("Grados Fahrenheit: ");
    JLabel etiquetaSalida = new JLabel("Grados Celsius: ");

    // Crear botones
    JButton fahrenheitACelsiusButton = new JButton("Convertir Fahrenheit a Celsius");
    JButton celsiusAFahrenheitButton = new JButton("Convertir Celsius a Fahrenheit");
    JButton limpiarButton = new JButton("Limpiar");

    // Crear entradas de texto
    JTextField campoFahrenheit = new JTextField(7);
    JTextField campoCelsius = new JTextField(7);

    int gradosFahrenheit;
    int gradosCelsius;

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == fahrenheitACelsiusButton) {
            // Clic en el botón "Convertir Fahrenheit a Celsius"
            String entradaUsuario = campoFahrenheit.getText();
            gradosFahrenheit = Integer.parseInt(entradaUsuario);

            gradosCelsius = (int) ((gradosFahrenheit - 32) * 5.0 / 9.0); // Convertir Fahrenheit a Celsius
            campoCelsius.setText(gradosCelsius + "");

        } else if (e.getSource() == celsiusAFahrenheitButton) {
            // Clic en el botón "Convertir Celsius a Fahrenheit"
            String entradaUsuario = campoCelsius.getText();
            gradosCelsius = Integer.parseInt(entradaUsuario);

            gradosFahrenheit = (int) (gradosCelsius * 9.0 / 5.0 + 32); // Convertir Celsius a Fahrenheit
            campoFahrenheit.setText(gradosFahrenheit + "");

        } else if (e.getSource() == limpiarButton) {
            // Clic en el botón "Limpiar"
            campoFahrenheit.setText("");
            campoCelsius.setText("");
        }
    }

    public ConversorTemperatura(String tituloVentana) {
        super(tituloVentana);
        setLayout(new FlowLayout());

        campoFahrenheit.addActionListener(this);

        // Los botones escuchan
        fahrenheitACelsiusButton.addActionListener(this);
        celsiusAFahrenheitButton.addActionListener(this);
        limpiarButton.addActionListener(this);

        add(titulo);
        add(etiquetaEntrada);
        add(etiquetaSalida);
        add(campoFahrenheit);
        add(campoCelsius);

        // Añadir los tres botones
        add(fahrenheitACelsiusButton);
        add(celsiusAFahrenheitButton);
        add(limpiarButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        ConversorTemperatura conversor = new ConversorTemperatura("Conversor de Temperatura");

        conversor.setSize(250, 200);
        conversor.setVisible(true);
    }
}

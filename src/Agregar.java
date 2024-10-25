package TP5;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Agregar extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultListModel<Pelicula> listModel;

	public Agregar() {
		setLayout(null);
		JLabel lblid = new JLabel("ID");
		lblid.setFont(new Font("Arial", Font.BOLD, 13));
		lblid.setBounds(103, 39, 46, 14);
		add(lblid);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Arial", Font.BOLD, 13));
		lblNombre.setBounds(103, 78, 62, 14);
		add(lblNombre);

		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setFont(new Font("Arial", Font.BOLD, 13));
		lblGenero.setBounds(103, 121, 73, 14);
		add(lblGenero);

		JTextField txtNombre = new JTextField();
		txtNombre.setBounds(247, 76, 193, 20);
		add(txtNombre);
		txtNombre.setColumns(10);

		JComboBox<Genero> comboBox = new JComboBox<Genero>();
		comboBox.setBounds(247, 119, 193, 20);
		add(comboBox);

		comboBox.addItem(new Genero("- SELECCIONE UN GENERO -"));
		comboBox.addItem(new Genero("Terror"));
		comboBox.addItem(new Genero("Accion"));
		comboBox.addItem(new Genero("Suspenso"));
		comboBox.addItem(new Genero("Romantica"));

		JLabel lblidActual = new JLabel(Pelicula.getProximoIdString());
		lblidActual.setFont(new Font("Arial", Font.BOLD, 13));
		lblidActual.setBounds(247, 40, 86, 14);
		add(lblidActual);

		JButton btnAceptar = new JButton("ACEPTAR");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Obtener el texto del nombre
				String nombre = txtNombre.getText().trim();
				
				// Validación 1: Verificar si el campo está vacío
				if (nombre.isEmpty()) {
					JOptionPane.showMessageDialog(null, "El campo de nombre no puede estar vacío.", 
					"Error", JOptionPane.ERROR_MESSAGE);
					txtNombre.setText("");  // Limpiar el campo
					return;
				}

				// Validación 2: Verificar si el nombre contiene caracteres inválidos (números o símbolos)
				if (!nombre.matches("[a-zA-Z\\s]+")) {  // Aceptar solo letras y espacios
					JOptionPane.showMessageDialog(null, "El nombre solo puede contener letras.", 
					"Error", JOptionPane.ERROR_MESSAGE);
					txtNombre.setText("");  // Limpiar el campo
					return;
				}
				
				// Validación 3: Verificar si se ha seleccionado un género válido
				Genero generoSeleccionado = (Genero) comboBox.getSelectedItem();
				if (generoSeleccionado.getNombre().equals("- SELECCIONE UN GENERO -")) {
					JOptionPane.showMessageDialog(null, "Debe seleccionar un género válido.", 
					"Error", JOptionPane.ERROR_MESSAGE);
					return;  // No se realiza ninguna acción adicional si el género no es válido
				}
				
				// Agrega una pelicula al JList
				Pelicula peli = new Pelicula(nombre, (Genero) comboBox.getSelectedItem());
				listModel.addElement(peli);
				txtNombre.setText("");  // Limpiar el campo después de agregar
				comboBox.setSelectedIndex(0);  // Reiniciar la selección del comboBox al valor no válido

			}
		});
		btnAceptar.setFont(new Font("Arial", Font.PLAIN, 11));
		btnAceptar.setBounds(103, 171, 137, 38);
		add(btnAceptar);
	}

	public void setDefaultListModel(DefaultListModel<Pelicula> listModelRecibido) {
		this.listModel = listModelRecibido;
	}
}

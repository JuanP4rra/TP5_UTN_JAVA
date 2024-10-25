package TP5;

import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JList;

public class Listar extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JList<?> list = new JList();

	public Listar(DefaultListModel<Pelicula> listModel) {
		setLayout(null);
		
		JLabel lblPeliculas = new JLabel("Peliculas");
		lblPeliculas.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPeliculas.setBounds(12, 140, 80, 16);
		add(lblPeliculas);
		
		// Crear un JList para mostrar las películas del DefaultListModel
		list = new JList<>(listModel); // Se pasa el listModel con las películas guardadas
		list.setBounds(90, 30, 323, 230);
		add(list);
		
	}
}

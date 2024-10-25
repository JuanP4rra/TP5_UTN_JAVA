package TP5;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private static DefaultListModel<Pelicula> listModel; // Model de películas

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					// Instanciado de listmodel
					listModel = new DefaultListModel<Pelicula>();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {

		setTitle("Programa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		// Menu
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menu = new JMenu("Peliculas");
		menu.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(menu);

		JMenuItem menuItemAgregar = new JMenuItem("Agregar");
		menuItemAgregar.setFont(new Font("Segoe UI", Font.PLAIN, 18));

		menuItemAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				contentPane.removeAll();
				// Abre el panel Agregar dentro de la ventana principal
				Agregar panel = new Agregar();
				panel.setDefaultListModel(listModel); // Pasar el listModel al panel Agregar
				contentPane.add(panel);
				contentPane.repaint();
				contentPane.revalidate();

			}
		});
		menu.add(menuItemAgregar);

		JMenuItem menuItemListar = new JMenuItem("Listar");
		menuItemListar.setFont(new Font("Segoe UI", Font.PLAIN, 18));

		menuItemListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Abre el panel Listar
				contentPane.removeAll();
				Listar panel = new Listar(listModel);

				contentPane.add(panel);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		menu.add(menuItemListar);
	}

}

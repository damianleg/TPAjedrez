package capaInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultTreeCellEditor.EditorContainer;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;

import java.awt.Choice;

import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextPane;

import capaNegocio.CapaNegocio;
import customException.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JEditorPane;
import javax.swing.JTextArea;

public class CapaInterface extends JFrame {
	
	private CapaNegocio capaNegocio = new CapaNegocio();
	private JPanel contentPane;
	private JTextField txtDni1;
	private JTextField txtDni2;
	private JTextField txtCargarJuego;
	private JTextField txtDesdeColumna;
	private JTextField txtDesdeFila;
	private JTextField txtHaciaColumna;
	private JTextField txtHaciaFila;
	private JTextArea textArea_1;
	private JTextArea textArea_2;
	private JTextField txtTurno;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CapaInterface frame = new CapaInterface();
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
	public CapaInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblJugador1 = new JLabel("Jugador 1");
		
		JLabel lblJugador2 = new JLabel("Jugador 2");
		
		txtDni1 = new JTextField("");
		txtDni1.setColumns(10);
		
		txtDni2 = new JTextField("");
		txtDni2.setColumns(10);
		
		JButton btnJuegoNuevo = new JButton("Juego Nuevo");
		btnJuegoNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nuevoJuego();
				
			}
		});
		
		JButton btnCargarJuego = new JButton("Cargar Juego:");
		btnCargarJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarJuego();
			}
		});
		
		txtCargarJuego = new JTextField("");
		txtCargarJuego.setColumns(10);
		
		JSeparator separator = new JSeparator();
		
		JLabel lblDesde = new JLabel("Desde:");
		
		JLabel lblHacia = new JLabel("Hacia:");
		
		txtDesdeColumna = new JTextField("");
		txtDesdeColumna.setColumns(10);
		
		txtDesdeFila = new JTextField("");
		txtDesdeFila.setColumns(10);
		
		txtHaciaColumna = new JTextField("");
		txtHaciaColumna.setColumns(10);
		
		txtHaciaFila = new JTextField("");
		txtHaciaFila.setColumns(10);
		
		JButton btnGuardarJuego = new JButton("Guardar Juego");
		btnGuardarJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarJuego();
			}
		});
		
		textArea_1 = new JTextArea();
		
		JButton btnMover = new JButton("Mover");
		btnMover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				movimiento();
			}
		});
		
		textArea_2 = new JTextArea();
		
		JLabel lblTurno = new JLabel("Turno");
		
		txtTurno = new JTextField();
		txtTurno.setText("");
		txtTurno.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(separator, GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblJugador1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtDni1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnJuegoNuevo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblJugador2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtDni2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnCargarJuego)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnGuardarJuego, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtCargarJuego, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblDesde)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtDesdeColumna, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtDesdeFila, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblHacia)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtHaciaColumna, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(10)
									.addComponent(textArea_1, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(txtHaciaFila, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnMover)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblTurno)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtTurno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(textArea_2, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblJugador1)
						.addComponent(txtDni1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnJuegoNuevo)
						.addComponent(btnGuardarJuego))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblJugador2)
						.addComponent(txtDni2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCargarJuego)
						.addComponent(txtCargarJuego, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 3, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDesde)
						.addComponent(txtDesdeColumna, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDesdeFila, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHacia)
						.addComponent(txtHaciaColumna, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtHaciaFila, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnMover)
						.addComponent(lblTurno)
						.addComponent(txtTurno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textArea_1, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
						.addComponent(textArea_2, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public void nuevoJuego(){
		try{
			txtCargarJuego.setText(capaNegocio.nuevoJuego(txtDni1.getText(), txtDni2.getText()));
			textArea_2.setText("Juego nuevo");
			confirmarPiezas();
		}
		catch (NumberFormatException e){
			textArea_2.setText("DNI 1 o DNI 2 no es valido");
		}
	}
	
	public void cargarJuego() {
		try{
			int jugadores[] = capaNegocio.cargarJugadores(txtCargarJuego.getText());
			txtDni1.setText(Integer.toString(jugadores[0]));
			txtDni2.setText(Integer.toString(jugadores[1]));
			textArea_2.setText(capaNegocio.cargarJuego(txtCargarJuego.getText()));
			confirmarPiezas();
		}
		catch (NumberFormatException e){
			textArea_2.setText("Numero de juego no se valido");
		} 
		catch (NoGameFoundException e) {
			txtDni1.setText("");
			txtDni2.setText("");
			textArea_1.setText("");
			textArea_2.setText("Juego no encontrado");
		}	
	}
	
	public void guardarJuego(){
		try{
			capaNegocio.guardarJuego();
		}
		catch (NullPointerException e){
			textArea_2.setText(e.getMessage());
		}
	}

	public void movimiento(){
		try{
			textArea_2.setText(capaNegocio.movimiento(txtDesdeColumna.getText(), txtDesdeFila.getText(), txtHaciaColumna.getText(), txtHaciaFila.getText()));
			if(capaNegocio.juegoIniciado()){
				confirmarPiezas();
			}
			else{
				textArea_1.setText("");
			}
		}
		catch (NullPointerException e){
			textArea_2.setText(e.getMessage());
		}
		catch (NumberFormatException e){
			textArea_2.setText("Movimiento no valido");
		}
	}
	
	public void confirmarPiezas(){
		try{
			textArea_1.setText(capaNegocio.confirmarPiezas());
			txtTurno.setText(capaNegocio.getTurno());
		}
		catch (NullPointerException e){
			textArea_2.setText(e.getMessage());
			txtTurno.setText("");
		}
	}
}

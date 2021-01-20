package Presentación;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InfoFichas extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Ayuda frame = new Ayuda();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public InfoFichas() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("Recursos\\iconoRefachero2.png"));
		setResizable(false);
//		setIconImage(Toolkit.getDefaultToolkit().getImage(InfoFichas.class.getResource("/Imagenes/iconoRefachero.png")));
		setTitle("Informaci\u00F3n sobre las fichas");
		setBounds(100, 100, 729, 575);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(new Color(240, 230, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnLaAplicacinPermite = new JTextPane();
		txtpnLaAplicacinPermite.setEditable(false);
		txtpnLaAplicacinPermite.setBackground(Color.LIGHT_GRAY);
		txtpnLaAplicacinPermite.setForeground(Color.BLACK);
		txtpnLaAplicacinPermite.setText("El arquero es una ficha d\u00E9bil, que no destaca ni por su potencia en el combate cuerpo a curerpo ni por su resistencia. De hecho, es con total seguridad la ficha m\u00E1s susceptible a disparos de catapultas y a cargas de caballer\u00EDa, por lo que trata de protegerla cuidadosamente con fichas con mayor resistencia.");
		txtpnLaAplicacinPermite.setBounds(20, 41, 676, 53);
		contentPane.add(txtpnLaAplicacinPermite);
		
		JLabel lblNewLabel = new JLabel("Arquero:");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 17));
		lblNewLabel.setBounds(10, 11, 330, 24);
		contentPane.add(lblNewLabel);
		
		JTextPane txtpnACambioEl = new JTextPane();
		txtpnACambioEl.setText("A cambio, el arquero es la \u00FAnica ficha de Divasonian Crusaders con un efecto pasivo sobre el juego. Al finalizar cada turno, disparar\u00E1 autom\u00E1ticamente a todas las fichas del rival que tenga a rango. Esto es: Dos casillas hacia delante y una hacia detr\u00E1s y los lados.");
		txtpnACambioEl.setForeground(Color.BLACK);
		txtpnACambioEl.setEditable(false);
		txtpnACambioEl.setBackground(Color.LIGHT_GRAY);
		txtpnACambioEl.setBounds(20, 105, 676, 40);
		contentPane.add(txtpnACambioEl);
		
		JLabel lblBrbaro = new JLabel("B\u00E1rbaro:");
		lblBrbaro.setFont(new Font("Arial Black", Font.BOLD, 17));
		lblBrbaro.setBounds(10, 156, 330, 24);
		contentPane.add(lblBrbaro);
		
		JTextPane txtpnElBrbaroEs = new JTextPane();
		txtpnElBrbaroEs.setText("El b\u00E1rbaro es una ficha con una resistencia media y con un da\u00F1o enorme. Es especialmente \u00FAtil para acabar con las fichas enemigas con pocos puntos de vida, en especial los arqueros. Con el hacha divas\u00F3nica se puede convertir en un arma devastadora, pero hay que tener en cuenta que su resistencia es menor que la de otras fichas.");
		txtpnElBrbaroEs.setForeground(Color.BLACK);
		txtpnElBrbaroEs.setEditable(false);
		txtpnElBrbaroEs.setBackground(Color.LIGHT_GRAY);
		txtpnElBrbaroEs.setBounds(20, 191, 676, 53);
		contentPane.add(txtpnElBrbaroEs);
		
		JLabel lblCaballero = new JLabel("Caballero:");
		lblCaballero.setFont(new Font("Arial Black", Font.BOLD, 17));
		lblCaballero.setBounds(10, 255, 330, 24);
		contentPane.add(lblCaballero);
		
		JTextPane txtpnElCaballeroNo = new JTextPane();
		txtpnElCaballeroNo.setText("El caballero no destaca por su da\u00F1o ni por su resistencia, pero es posiblemente la ficha m\u00E1s \u00FAtil del juego. A diferencia del resto, puede mover en un m\u00E1ximo de tres maniobras. Adem\u00E1s, sus cargas son devastadoras, por lo que puede ser una buena t\u00E9cnica emplearlo para acabar con fichas bajas de vida.");
		txtpnElCaballeroNo.setForeground(Color.BLACK);
		txtpnElCaballeroNo.setEditable(false);
		txtpnElCaballeroNo.setBackground(Color.LIGHT_GRAY);
		txtpnElCaballeroNo.setBounds(20, 290, 676, 53);
		contentPane.add(txtpnElCaballeroNo);
		
		JLabel lblLancero = new JLabel("Lancero:");
		lblLancero.setFont(new Font("Arial Black", Font.BOLD, 17));
		lblLancero.setBounds(10, 354, 330, 24);
		contentPane.add(lblLancero);
		
		JTextPane txtpnElLanceroEs = new JTextPane();
		txtpnElLanceroEs.setText("El lancero es la ficha con caracter\u00EDsticas m\u00E1s equilibradas, pero es especialmente fuerte contra la caballer\u00EDa. Conviene mantenerlo cerca del caballero rival, y as\u00ED proteger al resto de tus fichas de sus cargas.");
		txtpnElLanceroEs.setForeground(Color.BLACK);
		txtpnElLanceroEs.setEditable(false);
		txtpnElLanceroEs.setBackground(Color.LIGHT_GRAY);
		txtpnElLanceroEs.setBounds(20, 389, 676, 40);
		contentPane.add(txtpnElLanceroEs);
		
		JLabel lblGuerrero = new JLabel("Guerrero:");
		lblGuerrero.setFont(new Font("Arial Black", Font.BOLD, 17));
		lblGuerrero.setBounds(10, 440, 330, 24);
		contentPane.add(lblGuerrero);
		
		JTextPane txtpnElGuerreroEs = new JTextPane();
		txtpnElGuerreroEs.setText("El guerrero es la ficha con m\u00E1s puntos de vida de todo Divasonian Crusaders. Es el protector por defecto del arquero y la primera l\u00EDnea del ej\u00E9rcito, y suele ser una gran opci\u00F3n para portar el hacha divas\u00F3nica por su alta resistencia ante su corrupci\u00F3n.");
		txtpnElGuerreroEs.setForeground(Color.BLACK);
		txtpnElGuerreroEs.setEditable(false);
		txtpnElGuerreroEs.setBackground(Color.LIGHT_GRAY);
		txtpnElGuerreroEs.setBounds(20, 475, 676, 40);
		contentPane.add(txtpnElGuerreroEs);
	}
}

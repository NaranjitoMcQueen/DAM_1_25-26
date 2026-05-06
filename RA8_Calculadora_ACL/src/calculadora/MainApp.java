package calculadora;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MainApp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApp frame = new MainApp();
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
	public MainApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JTextField operacio1 = new JTextField();
		operacio1.setBounds(100, 60, 114, 19);
		contentPane.add(operacio1);
		operacio1.setColumns(10);

		JTextField operacio2 = new JTextField();
		operacio2.setBounds(240, 60, 114, 19);
		contentPane.add(operacio2);
		operacio2.setColumns(10);

		JLabel lblResultat = new JLabel("");
		lblResultat.setBounds(100, 157, 70, 15);
		contentPane.add(lblResultat);

		JButton btnSuma = new JButton("Suma");
		btnSuma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Operacions op = new Operacions();
				try {
					double n1 = Double.parseDouble(operacio1.getText());
					double n2 = Double.parseDouble(operacio2.getText());
					lblResultat.setText("" + op.suma(n1, n2));
				} catch (NumberFormatException ex) {
					lblResultat.setText("Error: Introdueix algún nombre");
				}
			}
		});
		btnSuma.setBounds(321, 115, 117, 25);
		contentPane.add(btnSuma);

		JButton btnResta = new JButton("Resta");
		btnResta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Operacions op = new Operacions();
				try {
					double n1 = Double.parseDouble(operacio1.getText());
					double n2 = Double.parseDouble(operacio2.getText());
					lblResultat.setText("" + op.resta(n1, n2));
				} catch (NumberFormatException ex) {
					lblResultat.setText("Error: Introdueix algún nombre");
				}
			}
		});
		btnResta.setBounds(321, 152, 117, 25);
		contentPane.add(btnResta);

		JButton btnMultiplicacio = new JButton("Multiplicació");
		btnMultiplicacio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Operacions op = new Operacions();
				try {
					double n1 = Double.parseDouble(operacio1.getText());
					double n2 = Double.parseDouble(operacio2.getText());
					lblResultat.setText("" + op.multiplicacio(n1, n2));
				} catch (NumberFormatException ex) {
					lblResultat.setText("Error: Introdueix algún nombre");
				}
			}
		});
		btnMultiplicacio.setBounds(321, 189, 117, 25);
		contentPane.add(btnMultiplicacio);

		JButton btnDiviso = new JButton("Divisió");
		btnDiviso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Operacions op = new Operacions();
				try {
					double n1 = Double.parseDouble(operacio1.getText());
					double n2 = Double.parseDouble(operacio2.getText());
					lblResultat.setText("" + op.divisio(n1, n2));
				} catch (NumberFormatException ex) {
					lblResultat.setText("Error: Introdueix algún nombre");
				} catch (Exception e0) {
					lblResultat.setText("Error.");
				}
			}
		});
		btnDiviso.setBounds(321, 226, 117, 25);
		contentPane.add(btnDiviso);
	}

}

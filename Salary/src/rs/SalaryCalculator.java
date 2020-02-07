package rs;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SalaryCalculator {

	private JFrame frmSalaryCalculator;
	private JTextField txtsal;
	private JTextField txttax;
	private JTextField txtnetsal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalaryCalculator window = new SalaryCalculator();
					window.frmSalaryCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SalaryCalculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSalaryCalculator = new JFrame();
		frmSalaryCalculator.getContentPane().setBackground(new Color(255, 255, 224));
		frmSalaryCalculator.getContentPane().setForeground(new Color(255, 255, 224));
		frmSalaryCalculator.setFont(new Font("Arial", Font.PLAIN, 12));
		frmSalaryCalculator.setForeground(new Color(135, 206, 235));
		frmSalaryCalculator.setTitle("SALARY CALCULATOR");
		frmSalaryCalculator.setBounds(100, 100, 753, 526);
		frmSalaryCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 224));
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 255, 224), null, null, null));
		panel.setForeground(new Color(255, 255, 224));
		
		JLabel lblEmployeeSalary = new JLabel("Employee Salary");
		lblEmployeeSalary.setFont(new Font("Arial", Font.BOLD, 16));
		
		JLabel lblTax = new JLabel("Tax");
		lblTax.setFont(new Font("Arial", Font.BOLD, 16));
		
		JLabel lblNewSalary = new JLabel("Neto Salary");
		lblNewSalary.setFont(new Font("Arial", Font.BOLD, 16));
		
		txtsal = new JTextField();
		txtsal.setToolTipText("enter salary");
		txtsal.setForeground(new Color(0, 0, 0));
		txtsal.setColumns(10);
		
		txttax = new JTextField();
		txttax.setToolTipText("enter tax");
		txttax.setForeground(new Color(0, 0, 0));
		txttax.setColumns(10);
		
		txtnetsal = new JTextField();
		txtnetsal.setToolTipText("new salary");
		txtnetsal.setForeground(new Color(0, 0, 0));
		txtnetsal.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBackground(new Color(240, 230, 140));
		btnOk.setForeground(new Color(0, 0, 0));
		btnOk.setFont(new Font("Arial", Font.BOLD, 14));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				double salary, tax, netsal;
				salary= Double.parseDouble (txtsal.getText());
				if (salary >50000)
				{
					tax= salary*10/100;
				}
				else if (salary < 35000) {
					tax= salary*5/100;
				}
				else {
					tax=0;
				}
				txttax.setText(String.valueOf(tax));
				netsal=salary-tax;
				txtnetsal.setText(String.valueOf(netsal));
			}
			
		});
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.setBackground(new Color(240, 230, 140));
		btnClear.setFont(new Font("Arial", Font.BOLD, 14));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtsal.setText("");
				txttax.setText("");
				txtnetsal.setText("");
				txtsal.requestFocus();
			}
		});
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setBackground(new Color(240, 230, 140));
		btnExit.setFont(new Font("Arial", Font.BOLD, 14));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmSalaryCalculator.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 737, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(50)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTax, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmployeeSalary)
						.addComponent(lblNewSalary, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
					.addGap(47)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(txtnetsal, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
						.addComponent(txttax, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
						.addComponent(txtsal, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnExit, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnOk, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnClear, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
					.addGap(269))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addGap(78)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmployeeSalary, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtsal, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTax)
						.addComponent(txttax, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtnetsal, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewSalary))
					.addContainerGap(121, Short.MAX_VALUE))
		);
		
		JLabel lblEmployeeSalaryCalculator = new JLabel("EMPLOYEE SALARY CALCULATOR");
		lblEmployeeSalaryCalculator.setForeground(new Color(0, 0, 0));
		lblEmployeeSalaryCalculator.setBackground(new Color(255, 255, 224));
		lblEmployeeSalaryCalculator.setFont(new Font("Arial", Font.PLAIN, 28));
		panel.add(lblEmployeeSalaryCalculator);
		frmSalaryCalculator.getContentPane().setLayout(groupLayout);
	}
}

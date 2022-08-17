package View;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Connect.Connect;
import Model.Employee;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.List;
import java.awt.event.ActionEvent;

public class EmployeeManage extends JFrame {

	private JPanel contentPane;
	private JTextField tfID;
	private JTextField tfName;
	private JTextField tfDOB;
	private JTextField tfGender;
	private JTextField tfPhone;
	private JTextField tfEmail;
	private JTextField tfAddress;
	private JTextField tfPosition;
	private JTextField tfSalary;
	private JTable table;
	
	private List<Employee> empList;
	private DefaultTableModel model;
	int selectedIndex;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login login = new Login();
					//EmployeeManage frame = new EmployeeManage();
					login.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EmployeeManage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 656);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbTitle = new JLabel("E M P L O Y E E      M A N A G E M E N T");
		lbTitle.setBounds(520, 11, 347, 22);
		lbTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(lbTitle);
		
		JPanel p1 = new JPanel();
		p1.setBounds(20, 48, 389, 436);
		contentPane.add(p1);
		p1.setLayout(null);
		
		JLabel lbID = new JLabel("EmployeeID");
		lbID.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbID.setBounds(10, 11, 96, 29);
		p1.add(lbID);
		
		tfID = new JTextField();
		tfID.setBounds(116, 11, 260, 29);
		p1.add(tfID);
		tfID.setColumns(10);
		
		JLabel lbName = new JLabel("Name");
		lbName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbName.setBounds(10, 55, 96, 29);
		p1.add(lbName);
		
		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(116, 55, 260, 29);
		p1.add(tfName);
		
		JLabel lbDOB = new JLabel("Date Of Birth");
		lbDOB.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbDOB.setBounds(10, 102, 96, 29);
		p1.add(lbDOB);
		
		tfDOB = new JTextField();
		tfDOB.setColumns(10);
		tfDOB.setBounds(116, 102, 260, 29);
		p1.add(tfDOB);
		
		JLabel lbGender = new JLabel("Gender");
		lbGender.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbGender.setBounds(10, 152, 96, 29);
		p1.add(lbGender);
		
		JLabel lbPhone = new JLabel("Phone");
		lbPhone.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbPhone.setBounds(10, 202, 96, 29);
		p1.add(lbPhone);
		
		tfPhone = new JTextField();
		tfPhone.setColumns(10);
		tfPhone.setBounds(116, 202, 260, 29);
		p1.add(tfPhone);
		
		JLabel lbEmail = new JLabel("Email");
		lbEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbEmail.setBounds(10, 251, 96, 29);
		p1.add(lbEmail);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(116, 251, 260, 29);
		p1.add(tfEmail);
		
		JLabel lbAddress = new JLabel("Address");
		lbAddress.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbAddress.setBounds(10, 299, 96, 29);
		p1.add(lbAddress);
		
		tfAddress = new JTextField();
		tfAddress.setColumns(10);
		tfAddress.setBounds(116, 300, 260, 29);
		p1.add(tfAddress);
		
		JLabel lbPosition = new JLabel("Position");
		lbPosition.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbPosition.setBounds(10, 347, 96, 29);
		p1.add(lbPosition);
		
		tfPosition = new JTextField();
		tfPosition.setColumns(10);
		tfPosition.setBounds(116, 348, 260, 29);
		p1.add(tfPosition);
		
		JLabel lbSalary = new JLabel("Salary");
		lbSalary.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbSalary.setBounds(10, 396, 96, 29);
		p1.add(lbSalary);
		
		tfSalary = new JTextField();
		tfSalary.setColumns(10);
		tfSalary.setBounds(116, 396, 260, 29);
		p1.add(tfSalary);
		
		tfGender = new JTextField();
		tfGender.setColumns(10);
		tfGender.setBounds(116, 153, 260, 29);
		p1.add(tfGender);
		
		JPanel p2 = new JPanel();
		p2.setBounds(20, 495, 389, 108);
		contentPane.add(p2);
		p2.setLayout(null);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAdd.setBounds(24, 11, 116, 23);
		p2.add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tfID.getText().isEmpty()||tfName.getText().isEmpty()||tfDOB.getText().isEmpty()||tfGender.getText().isEmpty()||tfPhone.getText().isEmpty()
						||tfEmail.getText().isEmpty()||tfAddress.getText().isEmpty()||tfPosition.getText().isEmpty()||tfSalary.getText().isEmpty()) {
					JOptionPane.showMessageDialog(btnAdd, "Fill full the information!");
					return;
				}
				try {
					Employee emp = new Employee();
					emp.setEmployeeID(tfID.getText());
					emp.setName(tfName.getText());
					emp.setDob(new SimpleDateFormat("dd/MM/yyyy").parse(tfDOB.getText()));
					emp.setGender(tfGender.getText());
					emp.setPhone(tfPhone.getText());
					emp.setEmail(tfEmail.getText());
					emp.setAddress(tfAddress.getText());
					emp.setPosition(tfPosition.getText());
					emp.setSalary(Float.parseFloat(tfSalary.getText()));
					
					Connect c = new Connect();
					if(c.findByID(tfID.getText()) != null) {
						JOptionPane.showMessageDialog(btnAdd, "EmployeeID is existed!");
					}
					else {
						c.insert(emp);
						showData();
						JOptionPane.showMessageDialog(btnAdd, "Successfully Added!");
					}
				
				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(btnAdd,"Error: "+ e2.getMessage());
				}
				
			}
		}); 
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnUpdate.setBounds(24, 45, 116, 23);
		p2.add(btnUpdate);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tfID.getText().isEmpty()||tfName.getText().isEmpty()||tfDOB.getText().isEmpty()||tfGender.getText().isEmpty()||tfPhone.getText().isEmpty()
						||tfEmail.getText().isEmpty()||tfAddress.getText().isEmpty()||tfPosition.getText().isEmpty()||tfSalary.getText().isEmpty()) {
					JOptionPane.showMessageDialog(btnAdd, "EmployeeID Not Found to Update!");
					return;
				}
				try {
					Employee emp = new Employee();
					emp.setEmployeeID(tfID.getText());
					emp.setName(tfName.getText());
					emp.setDob(new SimpleDateFormat("dd/MM/yyyy").parse(tfDOB.getText()));
					emp.setGender(tfGender.getText());
					emp.setPhone(tfPhone.getText());
					emp.setEmail(tfEmail.getText());
					emp.setAddress(tfAddress.getText());
					emp.setPosition(tfPosition.getText());
					emp.setSalary(Float.parseFloat(tfSalary.getText()));
					
					Connect c = new Connect();
					if(c.findByID(tfID.getText()) == null) {
						JOptionPane.showMessageDialog(btnUpdate, "EmployeeID is not existed!");
						return;
					}else {
						c.update(emp);
						showData();
						JOptionPane.showMessageDialog(btnUpdate, "Successfully Updated!");
					}
					
				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(btnUpdate, "Error: "+ e2.getMessage());
				}
			}
		});
	
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDelete.setBounds(24, 79, 116, 23);
		p2.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connect c = new Connect();
					if(tfID.getText().isEmpty()) {
						JOptionPane.showMessageDialog(btnDelete, "Enter EmployeeID to delete!!");
					}else if(c.findByID(tfID.getText()) == null) {
						JOptionPane.showMessageDialog(btnDelete, "EmployeeID is not existed or deleted!");
					}else {
						c.deleteByID(tfID.getText());
						showData();
						JOptionPane.showMessageDialog(btnDelete, "Successfully Deleted!");
					}
				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(btnUpdate, "Error: "+ e2.getMessage());
				}
			}
		});
	
		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnReset.setBounds(232, 45, 116, 23);
		p2.add(btnReset);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfID.setText("");
				tfName.setText("");
				tfDOB.setText("");
				tfGender.setText("");
				tfPhone.setText("");
				tfEmail.setText("");
				tfAddress.setText("");
				tfPosition.setText("");
				tfSalary.setText("");
			}
		});
		
		JButton btnFind = new JButton("Find");
		btnFind.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnFind.setBounds(232, 11, 116, 23);
		p2.add(btnFind);
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				if(tfID.getText().equals("")) {
					JOptionPane.showMessageDialog(btnFind, "Enter EmployeeID to find!!");
					return;
				}
				try {
					Connect c = new Connect();
					Employee emp = c.findByID(tfID.getText());
					if(emp != null) {
						tfID.setText(emp.getEmployeeID());
						tfName.setText(emp.getName());
						tfDOB.setText(new SimpleDateFormat("dd/MM/yyyy").format(emp.getDob()));
						tfGender.setText(emp.getGender());
						tfPhone.setText(emp.getPhone());
						tfEmail.setText(emp.getEmail());
						tfAddress.setText(emp.getAddress());
						tfPosition.setText(emp.getPosition());
						tfSalary.setText(""+emp.getSalary());
					}else {
						JOptionPane.showMessageDialog(btnFind, "EmployeeID Not Found!");
					}
				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(btnFind, "Error: "+ e2.getMessage());
				}

			}
		});

		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnExit.setBounds(232, 79, 116, 23);
		p2.add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(419, 60, 831, 543);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedIndex = table.getSelectedRow();
				int row = table.getSelectedRow();
				if(row>=0) {
					Employee emp = empList.get(selectedIndex);
					tfID.setText(emp.getEmployeeID());
					tfName.setText(emp.getName());
					tfDOB.setText(new SimpleDateFormat("dd/MM/yyyy").format(emp.getDob()));
					tfGender.setText(emp.getGender());
					tfPhone.setText(emp.getPhone());
					tfEmail.setText(emp.getEmail());
					tfAddress.setText(emp.getAddress());
					tfPosition.setText(emp.getPosition());
					tfSalary.setText(""+emp.getSalary());
				}
			}
		});

		table.setModel(new DefaultTableModel(
		new Object[][] {
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"EmployeeID", "Name", "DOB", "Gender", "Phone", "Email", "Address", "Position", "Salary"
			}
		));

		scrollPane.setViewportView(table);
		this.setLocationRelativeTo(null);
		showData();
	}
	private void showData() {
	    model=(DefaultTableModel)table.getModel();
	    empList = new Connect().getList();
	    model.setRowCount(0);
	    for(Employee emp:empList) {
	    	model.addRow(new Object[] {
	    			emp.getEmployeeID(),emp.getName(),emp.getDob(),emp.getGender(),emp.getPhone(),emp.getEmail(),emp.getAddress(),emp.getPosition(),emp.getSalary()
	    	});
	    }
	}
}

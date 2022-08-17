package Connect;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Employee;

public class Connect {
	Connection conn; 
	Statement stm;
	public Connection connect() { 
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-C9L4BQL3:1433;databaseName=EmployeeManagement;user=sa;password=116615");			
			System.out.println("Connected");
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public ArrayList<Employee> getList(){
		ArrayList<Employee> list = new ArrayList<>();
		String sql = "SELECT * FROM Employee ORDER BY Salary DESC";
		try {
			conn =connect();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setEmployeeID(rs.getString("EmployeeID"));
				emp.setName(rs.getString("Name"));
				emp.setDob(rs.getDate("DOB"));
				emp.setGender(rs.getString("Gender"));
				emp.setPhone(rs.getString("Phone"));
				emp.setEmail(rs.getString("Email"));
				emp.setAddress(rs.getString("Address"));
				emp.setPosition(rs.getString("Position"));
				emp.setSalary(rs.getFloat("Salary"));
				list.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void insert(Employee emp) {
		try {
			String sql = "INSERT INTO Employee(EmployeeID,Name,DOB,Gender,Phone,Email,Address,Position,Salary) VALUES (?,?,?,?,?,?,?,?,?)";
			Connection conn = connect();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, emp.getEmployeeID());
			ps.setString(2, emp.getName());
			ps.setDate(3, new Date(emp.getDob().getTime()));
			ps.setString(4, emp.getGender());
			ps.setString(5, emp.getPhone());
			ps.setString(6, emp.getEmail());
			ps.setString(7, emp.getAddress());
			ps.setString(8, emp.getPosition());
			ps.setFloat(9, emp.getSalary());
			ps.execute();
						
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteByID(String employeeID) {
		try {
			String sql = "DELETE FROM Employee WHERE EmployeeID = ?";
			Connection conn = connect();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,employeeID);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(Employee emp) {
		try {
			String sql = "UPDATE Employee SET Name =?,DOB =?,Gender =?,Phone =?,Email =?,Address= ?,Position =?,Salary =?"
					+ "  WHERE EmployeeID =?";
			Connection conn = connect();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(9, emp.getEmployeeID());
			ps.setString(1, emp.getName());
			ps.setDate(2, new Date(emp.getDob().getTime()));
			ps.setString(3, emp.getGender());
			ps.setString(4, emp.getPhone());
			ps.setString(5, emp.getEmail());
			ps.setString(6, emp.getAddress());
			ps.setString(7, emp.getPosition());
			ps.setFloat(8, emp.getSalary());
			ps.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Employee findByID(String employeeID) {
		String sql = "SELECT * FROM Employee WHERE EmployeeID = ?";
		try {
			Connection conn = connect();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,employeeID);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setEmployeeID(rs.getString("EmployeeID"));
				emp.setName(rs.getString("Name"));
				emp.setDob(rs.getDate("DOB"));
				emp.setGender(rs.getString("Gender"));
				emp.setPhone(rs.getString("Phone"));
				emp.setEmail(rs.getString("Email"));
				emp.setAddress(rs.getString("Address"));
				emp.setPosition(rs.getString("Position"));
				emp.setSalary(rs.getFloat("Salary"));
				return emp;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

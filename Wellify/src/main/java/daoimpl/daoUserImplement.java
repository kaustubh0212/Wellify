package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//import com.entity.User;

import dao.daoUserInterface;
import domain.doctor;
import domain.patient;
import util.closeDbResources;
import util.dbConnect;

public class daoUserImplement implements daoUserInterface {
	
	dbConnect db = new dbConnect();
	closeDbResources c = new closeDbResources();
	
	public boolean daoRegisterPatient(patient p)
	{
		System.out.println("inside daoRegisterPatient()");
		boolean f = false;
		
		//dbConnect db = new dbConnect();
		Connection con = db.getConn();
		
		
		try {
			String sql = "insert into patient (name, password, email, age, phone) values(?, ?, ?, ?, ?)";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, p.getName());
			ps.setString(2, p.getPassword());
			ps.setString(3, p.getEmail());
			ps.setInt(4, p.getAge());
			ps.setString(5, p.getPhone());
			
			int i = ps.executeUpdate();
			if(i == 1)
			{
				f = true;
			}
			
			c.closeResources(null, con, ps);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	public boolean daoRegisterDoctor(doctor d)
	{
		System.out.println("inside daoRegisterDoctor()");
		boolean f = false;
		
		//dbConnect db = new dbConnect();
		Connection con = db.getConn();
		
		
		try {
			String sql = "insert into doctor (name, email, password, age, qualification, address, fees, specialization, phone) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, d.getName());
			ps.setString(2, d.getEmail());
			ps.setString(3, d.getPassword());
			ps.setInt(4, d.getAge());
			ps.setString(5, d.getQualification());
			ps.setString(6, d.getAddress());
			ps.setInt(7, d.getFees());
			ps.setString(8, d.getSpecialization());
			ps.setString(9, d.getPhone());
			
			
			int i = ps.executeUpdate();
			if(i == 1)
			{
				f = true;
			}
			
			c.closeResources(null, con, ps);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	public patient daoLoginPatient(String email, String password)
	{
		System.out.println("inside daoLoginPatient()");
		boolean f = false;
		
		Connection con = db.getConn();
		patient p = new patient();
		
		try
		{
			String sql = "select * from patient where email = ? and password = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1,  email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				//patient p = new patient();
				
				p.setPatientId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setAge(rs.getInt(3));
				p.setEmail(rs.getString(4));
				p.setPassword(rs.getString(5));
				p.setPhone(rs.getString(6));
			}
			
			System.out.println("patient name: " + p.getName());
			c.closeResources(rs, con, ps);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return p;
		
	}
	
	public doctor daoLoginDoctor(String email, String password)
	{
		System.out.println("inside daoLoginDoctor()");
		boolean f = false;
		
		Connection con = db.getConn();
		doctor d = new doctor();
		
		try
		{
			String sql = "select * from doctor where email = ? and password = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1,  email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
			    // d = new doctor();
				
				d.setDoctorId(rs.getInt(1));
				d.setName(rs.getString(2));
				d.setAge(rs.getInt(3));
				d.setEmail(rs.getString(4));
				d.setPassword(rs.getString(5));
				d.setPhone(rs.getString(6));
				d.setFees(rs.getInt(7));
				d.setSpecialization(rs.getString(8));
				d.setAddress(rs.getString(9));
				d.setQualification(rs.getString(10));
			}
			
			c.closeResources(rs, con, ps);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return d;
	}
}

package daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.tagext.TryCatchFinally;

import domain.docAppoint;
import domain.doctor;
import util.closeDbResources;
import util.dbConnect;

public class daoBookingImplement
{
	dbConnect db = new dbConnect();
	closeDbResources c = new closeDbResources();
	
	public List<docAppoint> daoFetchDoctors(String disease) {
		System.out.println("inside daoFetchDoctors()");
	    List<docAppoint> doctors = new ArrayList<>();
	    Connection con = db.getConn();
	    
	    try {
	    	String sql =
	    			"SELECT d.doctor_id, d.name, d.age, d.email, d.phone, d.fees, d.specialization, d.address, d.qualification, f.disease\r\n"
	    			+ "FROM doctor as d \r\n"
	    			+ "INNER JOIN disease_field as f \r\n"
	    			+ "ON d.specialization = f.field WHERE f.disease = ?";
		
			PreparedStatement ps = con.prepareStatement(sql);
	        
	        ps.setString(1, disease);
	        ResultSet rs = ps.executeQuery();
	        System.out.println("disease: " + disease);
	        
	        while(rs.next())
	        {
	            docAppoint d = new docAppoint();
	            d.setDoctorId(rs.getInt(1));
	            d.setDoctorName(rs.getString(2));
	            d.setSpecialization(rs.getString(7));
	            d.setAddress(rs.getString(8));
	            d.setQualification(rs.getString(9));
	            d.setFees(rs.getInt(6));
	            
	            doctors.add(d);
	        
	        }
	        	c.closeResources(rs, con, ps);
	    }
	        catch (SQLException e) {
	        e.printStackTrace(); // Use proper logging in production
	    }
	    return doctors;
	}
	
	public int daoBookAppointment(String disease, int doctorId, int patientId, String time, String date, String symptom, String history) {
	    System.out.println("inside daoBookAppointment()");
	    Connection con = db.getConn();
	    int rowInserted = 0;

	    try {
	        Time sqlTime = Time.valueOf(time + ":00");  // HH:mm -> HH:mm:ss
	        Date sqlDate = Date.valueOf(date);

	        String checkSql = "SELECT COUNT(*) FROM appointment WHERE appointment_date = ? AND appointment_time = ?";
	        PreparedStatement checkPs = con.prepareStatement(checkSql);
	        checkPs.setDate(1, sqlDate);
	        checkPs.setTime(2, sqlTime);
	        ResultSet rs = checkPs.executeQuery();
	        boolean exists = false;
	        if (rs.next()) {
	            exists = rs.getInt(1) > 0;
	        }
	        rs.close();
	        checkPs.close();

	        if (exists) {
	            c.closeResources(null, con, null);
	            return -2;
	        }

	        String sql = "INSERT INTO appointment (disease, doctor_id, patient_id, appointment_time, appointment_date, status, symptom, history) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	        PreparedStatement ps = con.prepareStatement(sql);

	        ps.setString(1, disease);
	        ps.setInt(2, doctorId);
	        ps.setInt(3, patientId);
	        ps.setTime(4, sqlTime);
	        ps.setDate(5, sqlDate);
	        ps.setString(6, "pending");
	        ps.setString(7, symptom);
	        ps.setString(8, history);

	        rowInserted = ps.executeUpdate();

	        c.closeResources(null, con, ps);

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return (rowInserted == 1) ? 1 : -1;
	}


	public ArrayList<String> daoFetchDisease() {
		
		System.out.println("inside daoFetchDisease()");
	    ArrayList<String> disease = new ArrayList<>();
	    Connection con = db.getConn();
	    
	    try {
	    	String sql = "select disease from disease_field;";
		
			PreparedStatement ps = con.prepareStatement(sql);
	        
	        ResultSet rs = ps.executeQuery();
	        
	        while(rs.next())
	        {
	        	disease.add(rs.getString(1));
	        }
	        	c.closeResources(rs, con, ps);
	    }
	        catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return disease;
		
	}

}

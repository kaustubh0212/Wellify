package daoimpl;

import java.nio.channels.SelectableChannel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

//import com.entity.User;

import dao.daoUserInterface;
import domain.Appointment;
import domain.doctor;
import domain.doctorHistory;
import domain.patient;
import domain.patientHistory;
import util.closeDbResources;
import util.dbConnect;

public class daoUserImplement implements daoUserInterface {
	
	dbConnect db = new dbConnect();
	closeDbResources c = new closeDbResources();
	
	public boolean daoRegisterPatient(patient p)
	{
		System.out.println("inside daoRegisterPatient()");
		boolean f = false;
		
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
	
	public ArrayList<patientHistory> daoViewAppointment(int patientId)
	{
		System.out.println("inside daoViewAppointment()");
		Connection con = db.getConn();
		ArrayList<patientHistory> p = new ArrayList<>();
		
		try
		{
			String sql = "select d.name, d.email, d.phone, d.fees, d.address, "
					+ "d.specialization, d.doctor_id, a.report_id, a.appointment_date, "
					+ "a.appointment_time, a.status, a.disease, a.appointment_id, a.history "
					+ "from doctor as d "
					+ "join appointment as a "
					+ "on d.doctor_id = a.doctor_id "
					+ "where a.patient_id = " + patientId;
			PreparedStatement ps = con.prepareStatement(sql);
			
			//ps.setString(1,  email);
			//ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				patientHistory o = new patientHistory();
				
				o.setName(rs.getString(1));
				o.setEmail(rs.getString(2));
				o.setPhone(rs.getString(3));
				o.setFees(rs.getInt(4));
				o.setAddress(rs.getString(5));
				o.setSpecialization(rs.getString(6));
				o.setDoctorId(rs.getInt(7));
				//o.setReportId(rs.getInt(8));
				o.setAppointmentDate(rs.getDate(9));
				o.setAppointmentTime(rs.getTime(10));
				o.setStatus(rs.getString(11));
				o.setDisease(rs.getString(12));
				o.setAppointmentId(rs.getInt(13));
				o.setHistory(rs.getString(14));
				
				o.setReportId(rs.getInt(8));
				if(rs.wasNull())
				{
					o.setReportId(-1);
				}
				
				p.add(o);
			}
			
			c.closeResources(rs, con, ps);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return p;
	}
	
	public ArrayList<doctorHistory> daoViewPatient(int doctorId)
	{
		System.out.println("inside daoViewPatient()");
		Connection con = db.getConn();
		ArrayList<doctorHistory> d = new ArrayList<>();
		
		try
		{
			String sql = "select p.name, p.email, p.phone, p.patient_id, "
					+ "a.report_id, a.appointment_date, a.appointment_time, a.status, "
					+ "a.disease, a.appointment_id, a.symptom, a.history, p.age "
					+ "from patient as p "
					+ "join appointment as a "
					+ "on p.patient_id = a.patient_id "
					+ "where a.doctor_id = " + doctorId;
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				doctorHistory o = new doctorHistory();
				
				o.setPatientName(rs.getString(1));
				System.out.println(o.getPatientName());
				o.setEmail(rs.getString(2));
				//o.setPhone(rs.getString(3));
				o.setPatientId(rs.getInt(4));
				o.setAppointmentDate(rs.getDate(6));
				o.setAppointmentTime(rs.getTime(7));
				o.setStatus(rs.getString(8));
				o.setDisease(rs.getString(9));
				o.setAppointmentId(rs.getInt(10));
				o.setSymptom(rs.getString(11));
				o.setHistory(rs.getString(12));
				o.setAge(rs.getInt(13));
				
				o.setReportId(rs.getInt(5));
				if(rs.wasNull())
				{
					o.setReportId(-1);
				}
				
				d.add(o);
			}
			
			c.closeResources(rs, con, ps);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return d;
	}

	public boolean daoCreateReport(int appointmentId, int doctorId, String medication) {
		
		System.out.println("inside daoCreateReport()");
		boolean f1 = false;
		boolean f2 = false;
		boolean f3 = false;
		
		//dbConnect db = new dbConnect();
		Connection con = db.getConn();
		int reportId = -1;
		
		try {
			String sql = "insert into report (appointment_id, medication) values(?, ?)";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, appointmentId);
			ps.setString(2, medication);
			
			int i = ps.executeUpdate();
			if(i == 1)
			{
				f1 = true;
			}
			
			//c.closeResources(null, con, ps);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(f1)
		{
			try {
				
				String sql = "select report_id from report where appointment_id = " + appointmentId;
				
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				
				rs.next();
				reportId = rs.getInt(1);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else return false;
		
		if(reportId != -1) f2 = true;
		
		if(f2)
		{
			try {
				
				String sql = "UPDATE appointment SET report_id = ?, status = 'completed' WHERE appointment_id = ?;";
				
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, reportId);
				ps.setInt(2, appointmentId);
				
				int i = ps.executeUpdate();
				if(i == 1)
				{
					f3 = true;
				}
				
				//c.closeResources(null, con, ps);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		if(!f3 || !f2)
		{
			try {
				String sql = "DELETE FROM report WHERE appointment_id = ?";
				
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, appointmentId);
				
				int i = ps.executeUpdate();
				if(i == 1)
				{
					c.closeResources(null, con, ps);
					return false;
				}
			
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return false;
		}
		
		c.closeResources(null, con, null);
		if(f1 && f2 && f3)
		{
			System.out.println("report created using daoCreateReport()");
			return true;
		}
		else return false;
	}

	public String daoGetPrescription(int reportId) {
		
		System.out.println("inside daoGetPrescription()");
		Connection con = db.getConn();
		String medication = "";
		
		try
		{
			/*
			String sql = "select r.medication, a.appointment_date, a.appointment_time,"
					+ "a.status, a.disease, a.appointment_id, a.symptom, a.history "
					+ "from report as r "
					+ "join appointment as a "
					+ "on a.appointment_id = r.appointment_id "
					+ "where a.report_id = " + reportId;"
			*/
			String sql = "select medication from report where report_id = " + reportId;
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			rs.next();
			
			medication = rs.getString(1);
			
			c.closeResources(rs, con, ps);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return medication;
	}
	
	public boolean daoCancelAppointment(int appointmentId)
	{
		System.out.println("inside daoCancelAppointment()");
		Connection con = db.getConn();
		boolean f = false;
		
		try {
			
			String sql = "UPDATE appointment SET status = 'cancelled' WHERE appointment_id = ?;";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, appointmentId);
			
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
}

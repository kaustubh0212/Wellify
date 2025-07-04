package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.eclipse.jdt.internal.compiler.flow.InsideSubRoutineFlowContext;

public class closeDbResources{
	public void closeResources(ResultSet rs, Connection con, PreparedStatement ps)
	{
		System.out.println("inside closeResources()");
		if(rs != null)
		{
			try {
                rs.close();
            } catch (Exception e) {
                System.out.println("Error closing resource: " + e);
            }
		}
			
		if(con != null)
		{
			try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error =" + e);
            }
		}
			
		if(ps != null)
		{
			try {
	            ps.close();
	        } catch (Exception e) {
	            System.out.println("Error =" + e);
	        }
		}
	}
}

package com.jsp.studentmanagmentsystem.customid;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.engine.jdbc.connections.spi.JdbcConnectionAccess;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomPRN implements IdentifierGenerator{

	
	int prefix=0;
	String suffix= "A";
	
	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
		JdbcConnectionAccess access = session.getJdbcConnectionAccess();
		try {
			Connection connection = access.obtainConnection();
			Statement statement = connection.createStatement();
			String sql="SELECT NEXTVAL('prn_seq')";
			
			ResultSet execute = statement.executeQuery(sql);
			if (execute.next()) {
				int i = execute.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prefix+suffix;
	}
}

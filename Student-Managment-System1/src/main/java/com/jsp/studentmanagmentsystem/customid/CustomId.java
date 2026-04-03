package com.jsp.studentmanagmentsystem.customid;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.engine.jdbc.connections.spi.JdbcConnectionAccess;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomId implements IdentifierGenerator{

	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
		String prefix= "SVCET";
		int suffix=0;
		JdbcConnectionAccess access = session.getJdbcConnectionAccess();
		try {
			Connection obtainConnection = access.obtainConnection();
			Statement statement = obtainConnection.createStatement();
			String sql="SELECT NEXTVAL('stu_seq')";
			
			ResultSet executeQuery = statement.executeQuery(sql);
			if (executeQuery.next()) {
				suffix = executeQuery.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prefix+suffix;
	}

}

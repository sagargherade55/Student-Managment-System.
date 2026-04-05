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
		
		Long seq = ((Number) session
	            .createNativeQuery("SELECT NEXTVAL('stu_seq')")
	            .getSingleResult()).longValue();

	    return prefix + seq;
	}

}

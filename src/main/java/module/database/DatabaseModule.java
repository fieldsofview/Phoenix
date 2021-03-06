/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. and 
 * at http://code.fieldsofview.in/phoenix/wiki/FOV-MPL2 */

package module.database;

import module.Module;
import module.database.pooler.DatabasePoolFactory;
import module.database.pooler.DatabasePooler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DatabaseModule implements Module {

	DatabasePooler pooler = null;
	Properties p = null;
	public String updateQuery;
	public String query;

	public DatabaseModule() {
		//First read properties file
		System.out.println("Booting database module.\nLoading properties file.");
		p = new Properties();
		try {
			p.load(new FileInputStream("config/database.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Next call boot
		boot();
	}

	/**
	 * Do boot-time checking of dependencies
	 */
	@Override
	public void boot() {
		System.out.println("Running boot and depdendency check.");
		//Dependency check
		try {
			ClassLoader l = ClassLoader.getSystemClassLoader();
			//Class.forName("com.jdbc.mysql.Driver",false,l);
			//Class.forName("com.jolbox.bonecp.BoneCP",false,l);
			Class.forName("org.slf4j.Logger", false, l);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			//TODO add error log
			//TODO system.exit
		}
		//After successful boot call initialise
		initialise();
	}

	@Override
	public void initialise() {
		System.out.println("Initialising database module and pooler.");
		try {
			pooler = DatabasePoolFactory.getPooler(p.getProperty("pooler").toString(), p);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ResultSet execute() {
		try {
			ResultSet rs;
			try (Connection c = this.pooler.getConnection()) {
				Statement s = c.prepareStatement(query);
				rs = s.executeQuery(query);
				query="";
				c.close();
			}
			return rs;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public Integer executeUpdate() {
		try {
			Connection c = this.pooler.getConnection();
			Integer returnVal= c.prepareStatement(updateQuery).executeUpdate();
			updateQuery="";
			c.close();
			return returnVal;
		} catch (SQLException e) {
			System.out.println(updateQuery + "failed. "+e.getMessage());
		}
		return null;
	}
}
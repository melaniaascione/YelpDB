package it.polito.tdp.yelp.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mariadb.jdbc.Connection;
import it.polito.tdp.yelp.db.*;

import it.polito.tdp.yelp.model.Business;

public class YelpDAO {
	
	//uso l'IdMap creata nel Model all'interno del metodo DAO
	public List<Business> readBusinesses(Map<String, Business> businessIdMap) {

		Connection conn;
		
		try {
			
			conn = (Connection) DBConnect.getConnection();

			String sql = "SELECT * FROM business";

			List<Business> result = new ArrayList<>();

			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();

			while (res.next()) {
				
				String id = res.getString("business_id");
				
				//verifico se la mappa contiene già o meno il business_id e procedo a 
				//aggiungerlo (se già esiste) oppure a crearlo se non esiste ancora
				if (businessIdMap.containsKey(id)) { 
					result.add(businessIdMap.get(id)); //lo aggiungo solo alla lista perchè 
					                                   //nella mappa già c'è
				} else {
					Boolean active = res.getString("active").equals("true");

					Business b = new Business(id, res.getString("full_address"), active, res.getString("categories"),
							res.getString("city"), res.getInt("review_count"), res.getString("business_name"),
							res.getString("neighborhoods"), res.getDouble("latitude"), res.getDouble("Longitude"),
							res.getString("state"), res.getDouble("stars"));
					
					result.add(b); //aggiungo alla lista 
					
					businessIdMap.put(b.getBusinessId(), b); //aggiungo anche alla mappa (poichè
					                                         //non c'era)
				}
			}

			conn.close();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public List<Business> readBusinesses() {

		Connection conn;
		try {
			conn = (Connection) DBConnect.getConnection();

			String sql = "SELECT * FROM business";

			List<Business> result = new ArrayList<>();

			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();

			while (res.next()) {
				String id = res.getString("business_id");
				Boolean active = res.getString("active").equals("true");

				Business b = new Business(id, res.getString("full_address"), active, res.getString("categories"),
						res.getString("city"), res.getInt("review_count"), res.getString("business_name"),
						res.getString("neighborhoods"), res.getDouble("latitude"), res.getDouble("Longitude"),
						res.getString("state"), res.getDouble("stars"));
				result.add(b);
			}

			conn.close();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public Double averageStars(Business b) {
		
		try {
			Connection conn = (Connection) DBConnect.getConnection();
			String sql = "SELECT AVG(stars) AS stelle " + "FROM reviews " + "WHERE business_id=?";

			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, b.getBusinessId());
			ResultSet res = st.executeQuery();
			res.first();
			Double stelle = res.getDouble("stelle");
			conn.close();
			return stelle;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
}

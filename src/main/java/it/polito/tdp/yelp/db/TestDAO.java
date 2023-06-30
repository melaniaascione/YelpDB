package it.polito.tdp.yelp.db;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.yelp.model.Business;

public class TestDAO {

	public static void main(String[] args) {
		YelpDAO dao = new YelpDAO();
		
		List<Business> businesses = dao.readBusinesses() ;
		
		System.out.println(businesses.size()) ;
		System.out.println(businesses.get(0)) ;
		
		List<Double> stelle = new ArrayList<>() ;
		long startTime = System.nanoTime() ;
		for(Business b: businesses) {
			Double num = dao.averageStars(b) ;
			stelle.add(num) ;
		}
		
		long endTime = System.nanoTime() ;
		System.out.println(stelle.size()) ;
		System.out.println(stelle.get(0)) ;
		System.out.println("Time = " + (endTime-startTime)/1e6 + " ms");

	}

}
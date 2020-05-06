package app;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.data.mongodb.core.mapping.Field;

import model.CardUser;
import config.MongoConfig;
import query.IQuery;
import query.UserQuery;
public class Main {
	public static void main(String args[]) {
		
	}
	
	 public static void mainMenu(IQuery query) {
	    	int option;
	    	boolean exit = false;
	    	Scanner scan = new Scanner(System.in);
	    	while(!exit) {
	        	System.out.println("1. Display all entry");
	        	System.out.println("2. Find entry by name");
	        	System.out.println("3. Find entry by location");
	        	System.out.println("4. Add a new entry");
	        	System.out.println("5. Delete an entry");
	        	System.out.println("6. Update an entry");
	        	System.out.println("7. Delete all entry");
	        	System.out.println("8. Exit");
	        	System.out.print("Option : ");
	        	option = scan.nextInt();
	        	switch(option) {
	        		case 1:{
	        			List < CardUser > user = query.findAll();
	        			int n = 1;
	        	        for (CardUser u: user) {
	        	        	System.out.println("Entry : "+n);
	        	            System.out.println("Id : " + u.getID());
	        	            System.out.println("Name : " + u.getNama());
	        	            System.out.println("Location : " + u.getLokasi());
	        	            System.out.println("Family Card Number : " + u.getKK());
	        	            System.out.println("Citizenship Card Number : " + u.getKTP());
	        	            System.out.println("Phone Number : " + u.getTelp());
	        	            System.out.println();
	        	            n++;
	        	        }
	        	        pressAnyKeyToContinue();
	        			break;
	        		}
	        		case 2:{
	        			List <CardUser> users = new ArrayList<>();
	        			String name;
	        			System.out.print("Enter name query : ");
	        			scan.nextLine();
	        			name = scan.nextLine();
	        			users = query.findByname(name);
	        			int n = 1;
	        	        for (CardUser u: users) {
	        	        	System.out.println("Entry : "+n);
	        	        	System.out.println("Id : " + u.getID());
	        	            System.out.println("Name : " + u.getNama());
	        	            System.out.println("Location : " + u.getLokasi());
	        	            System.out.println("Family Card Number : " + u.getKK());
	        	            System.out.println("Citizenship Card Number : " + u.getKTP());
	        	            System.out.println("Phone Number : " + u.getTelp());
	        	            System.out.println();
	        	            n++;
	        	        }
	        	        pressAnyKeyToContinue();
	        			break;
	        		}
	        		case 3:{
	        			List<CardUser> users = new ArrayList<>();
	        			String lokasi;
	        			System.out.print("Enter location : ");
	        			lokasi = scan.nextLine();
	        			users = query.findBylokasi(lokasi);
	        			int n = 1;
	        	        for (CardUser u: users) {
	        	        	System.out.println("Entry : "+n);
	        	        	System.out.println("Id : " + u.getID());
	        	            System.out.println("Name : " + u.getNama());
	        	            System.out.println("Location : " + u.getLokasi());
	        	            System.out.println("Family Card Number : " + u.getKK());
	        	            System.out.println("Citizenship Card Number : " + u.getKTP());
	        	            System.out.println("Phone Number : " + u.getTelp());
	        	            System.out.println();
	        	            n++;
	        	        }
	        	        pressAnyKeyToContinue();
	        			break;
	        		}
	        		case 4:{
	        			List<CardUser> users = new ArrayList<>();
	        			int c;
	        			CardUser user = new CardUser();
	        			String id;
	        			String name;
	        			String lokasi;
	        			String kk;
	        			String ktp;
	        			String telp;;
	        			String str[];
	        			System.out.print("Enter how many entry : ");
	        			c = scan.nextInt();
	        	        for (int n = 1;n<=c;n++) {
	        	        	System.out.println("Entry : "+n);
	        	            System.out.print("Id : ");
	        	            scan.nextLine();
	        	            id = scan.nextLine();
	        	            System.out.print("Name : ");
	        	            name = scan.nextLine();
	        	            System.out.print("Location : ");
	        	            lokasi = scan.nextLine();
	        	            System.out.print("Family Card Number : ");
	        	            kk = scan .nextLine();
	        	            System.out.print("Citizenship Card Number : ");
	        	            ktp = scan.nextLine();
	        	            System.out.print("Phone Number : ");
	        	            telp = scan.nextLine();
	        	            user = new CardUser(id, name, lokasi, kk, ktp, telp);
	        	            query.create(user);
	        	            n++;
	        	        }
	        	        pressAnyKeyToContinue();
	        			break;
	        		}
	        		case 5:{
	        			CardUser user = new CardUser();
	        			String id;
	        			System.out.print("Enter the entry id : ");
	        			scan.nextLine();
	        			id = scan.nextLine();
	        			user = query.findById(id);
	        			if(user==null) {
	        				System.out.println("No entry with such id");
	            	        pressAnyKeyToContinue();
	        			}else {
	        				query.delete(user);
	            	        pressAnyKeyToContinue();
	        			}
	        			
	        			break;
	        		}
	        		case 6:{
	        			CardUser user = new CardUser();
	        			String id;
	        			String nama;
	        			String lokasi;
	        			String kk;
	        			String ktp;
	        			String telp;
	        			System.out.print("Enter the entry id : ");
	        			scan.nextLine();
	        			id = scan.nextLine();
	        			user = query.findById(id);
	        			if(user==null) {
	        				System.out.println("No entry with such id");
	            	        pressAnyKeyToContinue();
	        			}else {
	        				System.out.println("Entry Before");
	        				System.out.println("Id : " + user.getID());
	        	            System.out.println("Name : " + user.getNama());
	        	            System.out.println("Location : " + user.getLokasi());
	        	            System.out.println("Family Card Number : " + user.getKK());
	        	            System.out.println("Citizenship Card Number : " + user.getKTP());
	        	            System.out.println("Phone Number : " + user.getTelp());
	        	            System.out.println();
	        	            System.out.println("Update the Entry");
	        	            System.out.print("Id : ");
	        	            id = scan.nextLine();
	        	            System.out.print("Name : ");
	        	            nama = scan.nextLine();
	        	            System.out.print("Location : ");
	        	            lokasi = scan.nextLine();
	        	            System.out.print("Family Card Number : ");
	        	            kk = scan .nextLine();
	        	            System.out.print("Citizenship Card Number : ");
	        	            ktp = scan.nextLine();
	        	            System.out.print("Phone Number : ");
	        	            telp = scan.nextLine();
	        	            user = new CardUser(id, nama, lokasi, kk, ktp, telp);
	        				query.update(user);
	            	        pressAnyKeyToContinue();
	        			}
	        			
	        			break;
	        		}
	        		case 7:{
	        			query.deleteAll();
	        			pressAnyKeyToContinue();
	        			break;
	        		}
	        		default:{
	        			System.out.println("Thank you!");
	        			exit = true;
	        			break;
	        		}
	        	}
	    	}
	    }
	 
	 private static void pressAnyKeyToContinue()
	    { 
	           System.out.println("Press Enter key to continue...");
	           try
	           {
	               System.in.read();
	           }  
	           catch(Exception e)
	           {}  
	    }
	 
}

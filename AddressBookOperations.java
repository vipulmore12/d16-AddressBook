package AddressBook;
import java.util.*;
import java.io.*;
import java.io.IOException;
import java.io.FileWriter;
import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
public class AddressBookOperations implements AddressBookMethods{
	public static ArrayList<Person> addressbook = new ArrayList<Person>();
	private Scanner inp;
	 public void addPerson() {
	        inp = new Scanner(System.in);
		System.out.println("Enter the firstName:");
		String firstName = inp.nextLine();
		System.out.println("Enter the LastName:");
		String lastName = inp.nextLine();
		System.out.println("Enter the phone:");
		String phonenum = inp.nextLine();
		System.out.println("Enter the city:");
		String city = inp.nextLine();
		System.out.println("Enter the state:");
		String state = inp.nextLine();
		System.out.println("Enter the zipcode:");
		String zipcode = inp.nextLine();
		Person p = new Person(firstName, lastName, phonenum, city, state, zipcode);
		addressbook.add(p);
	    }

	    
	    public void editPerson() {
	        inp = new Scanner(System.in); int cond=1;
		System.out.println("Enter firstname to update details");
		String name = inp.nextLine();
		for (Person person : addressbook) {
	            if (name.equals(person.firstname)) { 
	                while (cond==1)  {
	                    System.out.println("\"Select an option to edit:\n"
						+ "1) Phonenumber\n"
						+ "2) Address\n"						
						+ "3) Quit");
			int numb = inp.nextInt();
			inp = new Scanner(System.in);
			switch (numb) {
			case 1:
				System.out.println("Enter new value:");
				String phn = inp.nextLine();
				person.setPhonenumber(phn);
				break;
			case 2:
				System.out.println("Enter new city:");
				String city = inp.nextLine();
				System.out.println("Enter new state:");
				String state = inp.nextLine();
				System.out.println("Enter new zipcode:");
				String zipcode = inp.nextLine();
				person.setCity(city);
				person.setState(state);
				person.setZipcode(zipcode);
				break;
			case 3:
				cond = 0;
				break;
			default:
				System.out.println("Wrong choice");
				break;
	                }
	                }
	            }
	            else { 
	                    System.out.println("Name not found"); }
	        }
	    }

	    
	    public void deletePerson() {
	        inp = new Scanner(System.in);
		System.out.println("Enter firstname to delete its entries");
		String name = inp.nextLine();
		for (int i=0; i<addressbook.size(); i++) {
	            String personName = addressbook.get(i).firstname;
	            if (name.equals(personName)) {
			addressbook.remove(i);
			System.out.println("Entry deleted");
	            }
		else  {
			System.out.println("Name not found");
	            }
	        }
	    }

	    
	    public void sortbyName() {
	        Collections.sort(addressbook, new NameComparator());
		System.out.println("Sorted by Name");
		for (Person p : addressbook) 
	            System.out.println(p.toString());
	    }

	   
	    public void sortbyZip() {
	       Collections.sort(addressbook, new ZipComparator());
	        System.out.println("Sorted by Zipcode:\n");
	            for (Person p : addressbook) 
			System.out.println(p.toString());
	    }

	    
	    public void searchPerson() {
	       inp = new Scanner(System.in);
	       System.out.println("Enter firstname to search the details");
	       String name = inp.nextLine();
	       for (Person person : addressbook) {
	           if(name.equals(person.firstname)) {
	               System.out.println(person.toString());
	           }
	           else {
	                    System.out.println("Name not found");
	           }
	       }
	    }

	    
	    public void searchPhonenumber() {
	        inp = new Scanner(System.in);
		System.out.println("Enter phonenumber to search the details");
		String phone = inp.nextLine();
		for (Person person : addressbook) {
	            if(phone.equals(person.phonenumber)) {
	                System.out.println(person.toString());
	            }	
	            else {
	                    System.out.println("Phonenumber not found");
	            }
	        }
	    }

	    
	    public void display() {
	        System.out.println("Getting info");	
			for (Person person : addressbook) {
				System.out.println(person.toString());
				}
			
			Iterator i =addressbook.iterator();
		      System.out.println("The ArrayList elements are:");
		      while (i.hasNext()) {
		         System.out.println(i.next());
		      }
			
		}


		@Override
		public void sortByName() {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void sortByZipcode() {
			// TODO Auto-generated method stub
			
		}

}

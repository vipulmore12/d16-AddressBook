package AddressBook;
import java.util.*;
import java.io.*;

class AddressBookManagerOperations implements AddressBookManager {
	 Scanner n = new Scanner(System.in);
	    private Scanner input;
	    static String cap;
	    private static final String CSV_HEADER = "firstname,lastname,phonenumber,city,state,zipcode";

	    @Override
	    public void newAddressBook() {
	        System.out.println("Enter new addressbook name:");
		String nam = n.nextLine();
			
		try {
	            File obj = new File(nam+".csv");
	            if (obj.createNewFile()) {
	                System.out.println("New Addressbook created: " + obj.getName()); 
	            } else {
	                System.out.println("Addressbook already exists."); 
	            }
	        } catch (IOException e) {
	            System.out.println("An error occurred.");
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void openAddressBook() {
	    File dirpath = new File(".");	//current directory
			System.out.println("All addressbooks files");
		 	File[] files = dirpath.listFiles(new FilenameFilter() {
		 			public boolean accept(File dirpath, String name) {
					return name.endsWith(".csv");
				}
			});	
			for (File file : files) {
		System.out.println(file.getName());
			}
			System.out.println("Enter the addressbook to open:");
			cap = n.nextLine();
			boolean filefound = false;
			for (File file :files) {
				if(file.getName().equals(cap)) {
					int cond=1; filefound = true;
					while (cond == 1) {
						AddressBookOperations menu = new AddressBookOperations();
						System.out.println("Address Book:"+cap+"\n"
								+ "1) Add Person\n"
								+ "2) Edit Person\n"
								+ "3) Delete Person\n"
								+ "4) Sort by name\n"
								+ "5) Sort by zip\n"
								+ "6) Search Person\n"
								+ "7)Search Phonenumber\n" 
								+ "8)display\n"
								+ "9)quit");
						System.out.println("Select an option from menu: ");
						input = new Scanner(System.in);
						int num = input.nextInt();
						switch (num) {
						case 1:
							menu.addPerson();
							break;
						case 2:
							menu.editPerson();
							break;
						case 3:
							menu.deletePerson();
							break;
						case 4:
							menu.sortByName();
							break;
						case 5:
							menu.sortbyZip();
							break;
						case 6:
							menu.searchPerson();
							break;
						case 7:
							menu.searchPhonenumber();
							break;
						case 8:
							menu.display();
							break;
						case 9:
							cond =0;
							break;
						default:
							System.out.println("Incorrect Choice");
						}
					}
			}	 
					
			
			}
			 if(filefound == false)
			 System.out.println("Addressbook not found");
	    }

	    @Override
	    public void saveAddressBook() {
	    FileWriter writer = null;
			 System.out.println(cap);
			try {
				
				writer = new FileWriter(cap);
				writer.append(CSV_HEADER);
				writer.append("\n");
				for (Person p : AddressBookOperations.addressbook) {
					writer.append(p.getFirstname());
					writer.append(",");
					writer.append(p.getLastname());
					writer.append(",");
					writer.append(p.getPhonenumber());
					writer.append(",");
					writer.append(p.getCity());
					writer.append(",");
					writer.append(p.getState());
					writer.append(",");
					writer.append(p.getZipcode());
					writer.append("\n");
				}
				System.out.println("data saved.");
		}	 
			catch (IOException e) {
				System.out.println("Writing CSV error!");
				e.printStackTrace();
			} finally {
				try {
			    writer.flush();
			    writer.close();
				} catch (IOException e) {
			        System.out.println("Flushing/closing error!");
			        e.printStackTrace();
			      }
			}
	    }

	    @Override
	    public void saveasAddressBook() {
	    System.out.println("SaveAs:\nEnter AddressBook Name:\n");
			String newname = n.nextLine();
			
			 FileWriter writer = null;
				try {
					
					writer = new FileWriter(newname+".csv");
					writer.append(CSV_HEADER);
					writer.append("\n");
					for (Person p : AddressBookOperations.addressbook) {
						writer.append(p.getFirstname());
						writer.append(",");
						writer.append(p.getLastname());
						writer.append(",");
						writer.append(p.getPhonenumber());
						writer.append(",");
						writer.append(p.getCity());
						writer.append(",");
						writer.append(p.getState());
						writer.append(",");
						writer.append(p.getZipcode());
						writer.append("\n");
					}
					System.out.println("data saved.");
			}	 
				catch (IOException e) {
					System.out.println("Writing CSV error!");
					e.printStackTrace();
				} finally {
					try {
				    writer.flush();
				    writer.close();
					} catch (IOException e) {
				        System.out.println("Flushing/closing error!");
				        e.printStackTrace();
				      }
				}
	    }

	    @Override
	    public void closeAddressBook() {
	        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	    }

	    @Override
	    public void quit() {
	        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	    }

}

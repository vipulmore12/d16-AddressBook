package AddressBook;
import java.util.Scanner;
public class AddressBookMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cond=1;
		
		while (cond == 1) {
			AddressBookManagerOperations addressbookmanager = new AddressBookManagerOperations();
			System.out.println("Address Book:\n"
					+ "1) Create new Addressbook\n"
					+ "2) Open Addressbook\n"
					+ "3) Save Addressbook\n"
					+ "4) Saveas Addressbook\n"
					+ "5) Close Addressbook\n"
					+ "6) Quit");
			System.out.println("Select an option: ");
			Scanner input = new Scanner(System.in);
			int num = input.nextInt();
			
			switch (num) {
			case 1:
				addressbookmanager.newAddressBook();
				break;
			case 2:
				addressbookmanager.openAddressBook();
				break;
			case 3:
				addressbookmanager.saveAddressBook();
				break;
			case 4:
				addressbookmanager.saveasAddressBook();
				break;
			case 5:
				addressbookmanager.closeAddressBook();
				break;
			case 6:
				cond=0;
				break;
			default:
				System.out.println("Incorrect Choice");
			}
		}

	}

}

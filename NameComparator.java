package AddressBook;
import java.util.Comparator;

public class NameComparator implements Comparator<Person>{
	public int compare(Person p1, Person p2) {
		return p1.firstname.compareTo(p2.firstname);
	}

}

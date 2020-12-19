package AddressBook;
import java.util.Comparator;

public class ZipComparator implements Comparator<Person>{
	public int compare(Person p1, Person p2) {
		return p1.zipcode.compareTo(p2.zipcode);
	}

}

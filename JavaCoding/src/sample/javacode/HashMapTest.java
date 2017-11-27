package sample.javacode;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Example ex= new Example("Prabhu", "Mr");
		Example ex2= new Example("Prabhu", "Mr");
		
		
		Map<Example, String> map= new HashMap<Example, String>();
		map.put(ex, "1");
		System.out.println(map.toString());
		map.put(ex2, "2");
		System.out.println(map.toString());
		
		
	}

}

class Example{
	
	String name;
	String title;
	public Example(String string, String string2) {
		this.name=string;
		this.title=string2;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Example other = (Example) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
}
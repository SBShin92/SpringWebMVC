package himedia.springcontainer;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
	private Integer no;
	private String name;
	private Friend friend;
	
	private List<String> friends;
	private Set<String> hobbies;
	private Map<String, String> address;
	

	public User() { System.out.println("기본생성자");}

	public User(String name) {
		this.name = name;
		System.out.println("이몸, 생성: " + name);
	}	
	
	public User(Integer no, String name) {
		this.no = no;
		this.name = name;
		System.out.println("이몸, 생성: " + no + ", " + name);
	}

	public Integer getNo() {return no;}
	public void setNo(Integer no) {this.no = no;}

	public String getName() {return name;}
	public void setName(String name) {this.name = name;}

	
	
	public Friend getFriend() {
		return friend;
	}

	public void setFriend(Friend friend) {
		this.friend = friend;
	}

	
	
	public List<String> getFriends() {
		return friends;
	}

	public void setFriends(List<String> friends) {
		this.friends = friends;
	}

	public Set<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(Set<String> hobbies) {
		this.hobbies = hobbies;
	}

	public Map<String, String> getAddress() {
		return address;
	}

	public void setAddress(Map<String, String> address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [no=" + no + ", name=" + name + ", friend=" + friend + ", friends=" + friends + ", hobbies="
				+ hobbies + ", address=" + address + "]";
	}

	

	
}

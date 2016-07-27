package cc.zhanyun.service.model.location;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

public class Location {
	@Id
	private String oid;
	private String name;
	private String address;

	private String contacts;
	private String introduction;
	private List<Houses> houses = new ArrayList<Houses>();

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public List<Houses> getHouses() {
		return houses;
	}

	public void setHouses(List<Houses> houses) {
		this.houses = houses;
	}

}

package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {
	private String Name;
	private String email;
	private Date birthday;
	
	public Client() {}

	public Client(String name, String email, Date birthday) {
		super();
		Name = name;
		this.email = email;
		this.birthday = birthday;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

}

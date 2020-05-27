package hjh.Class;

import java.io.Serializable;

public class Student  implements Serializable{
private int id;
private String sno , sname , gender , phone , password ;
public Student() {
	super();
	// TODO Auto-generated constructor stub
}
public Student(int id, String sno, String sname, String gender, String phone, String password) {
	super();
	this.id = id;
	this.sno = sno;
	this.sname = sname;
	this.gender = gender;
	this.phone = phone;
	this.password = password;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getSno() {
	return sno;
}
public void setSno(String sno) {
	this.sno = sno;
}
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "Studen [id=" + id + ", sno=" + sno + ", sname=" + sname + ", gender=" + gender + ", phone=" + phone
			+ ", password=" + password + "]";
}

}


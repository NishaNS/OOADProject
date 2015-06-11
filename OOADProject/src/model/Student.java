package model;

public class Student {

private String firstname;
private String lastname;


/**
 * 
 * @return
 */
public String getFirstName(){
	return firstname;
}


/**
 * 
 * @param name
 */
public void setFirstName(String name){
	this.firstname=name;
}

/**
 * 
 * @return
 */
public String getLastName(){
	return lastname;
}

/**
 * 
 * @param str
 */
public void setLastName(String str){
	this.lastname=str;
}

}

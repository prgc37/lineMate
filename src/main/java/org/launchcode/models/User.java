package org.launchcode.models;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name = "user")
public class User extends AbstractEntity {

	private String username;
	private String pwHash;
	private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	private String email;
	private String mobileNumber; 
	private HashMap<Integer, Order> items;
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	public static final Pattern phoneValRegex = Pattern.compile("^[1-9][0-9]{9}");
	
	public User() {}
	
	public User(String username, String password, String email, String mobileNumber) {
		
		super();
		
		if (!isValidUsername(username)) {
			throw new IllegalArgumentException("Invalid username");
		}
		
		this.username = username;
		this.pwHash = hashPassword(password);
		this.email = email;
		this.mobileNumber = mobileNumber;
		
	}
	
	@NotNull
    @Column(name = "pwhash")
	public String getPwHash() {
		return pwHash;
	}
	
	@SuppressWarnings("unused")
	private void setPwHash(String pwHash) {
		this.pwHash = pwHash;
	}
	
	@NotNull
    @Column(name = "username", unique = true)
	public String getUsername() {
		return username;
	}
	
	private static String hashPassword(String password) {		
		return encoder.encode(password);
	}
	
	@SuppressWarnings("unused")
	private void setUsername(String username) {
		this.username = username;
	}
	
	@NotNull
	@Column(name = "email", unique = true)
	public String getEmail(){
		return this.email;
	}
	
	@SuppressWarnings("unused")
	private void setEmail(String newEmail){
		this.email = newEmail;
	} 
	
	@NotNull
	@Column(name = "number", unique = true)
	public String getNumber(){
		return this.mobileNumber;
	}
	
	@SuppressWarnings("unused")
	private void setNumber(String newNumber){
		this.mobileNumber = newNumber;
	}
	
	// given password is correct for the user (instance, non-static)
	public boolean isMatchingPassword(String password) {
		return encoder.matches(password, pwHash);
	}
	
	// checks that password meets minimum standards(any non-whitespace characters, 6-20)
	public static boolean isValidPassword(String password) {
		Pattern validUsernamePattern = Pattern.compile("(\\S){6,20}");
		Matcher matcher = validUsernamePattern.matcher(password);
		return matcher.matches();
	}
	
	// checks that username meets minimum standards
	public static boolean isValidUsername(String username) {
		Pattern validUsernamePattern = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]{4,11}");
		Matcher matcher = validUsernamePattern.matcher(username);
		return matcher.matches();
	}
	
	//http://stackoverflow.com/questions/8204680/java-regex-email
	public static boolean validateEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
        return matcher.find();
	}
	
	//http://stackoverflow.com/questions/19410950/regex-to-match-10-15-digit-number
	public static boolean validatePhone(String phone){
		Matcher matcher = phoneValRegex.matcher(phone);
		return matcher.matches();
	}
	
//	protected void addOrder(Order order) {
//		((Object) orders).add(order);
//	}

	@OneToMany
    @JoinColumn(name = "customer_uid")
    public Map<Integer, Order> getItems() {
        return items;
    }
	
	public void setItems(HashMap<Integer, Order> items) {
		this.items = items;
	}
	
}
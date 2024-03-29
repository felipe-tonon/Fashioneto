/**
 * 
 */
package com.fashioneto.ws.entities;

/**
 * @author felipe
 *
 */
public class UserSignupWrapper {

    private String username;
    private String email;
    private String password;
    private String displayName; 
    
    public UserSignupWrapper(){
	
    }

    public UserSignupWrapper(String username, String email, String password, String displayName) {
	super();
	this.username = username;
	this.email = email;
	this.password = password;
	this.displayName = displayName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
	return "UserSignupWrapper [username=" + username + ", email=" + email + ", password=" + password
		+ ", displayName=" + displayName + "]";
    }
    
}

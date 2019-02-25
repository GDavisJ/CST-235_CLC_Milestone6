package beans;

public class RegisterBean {

 /** Applying all variables from registration.*/
 private String nickname;
 private String emailaddress;
 private String password;
 private String firstname;
 private String lastname;
 private String phone;
 
 /** Getters which are public strings and setters which are public voids. */
 public String getNickname() {
 return nickname;
 }
 public void setNickname(String nickname) {
 this.nickname = nickname;
 }
 public String getEmailAddress() {
 return emailaddress;
 }
 public void setEmailAddress(String emailaddress) {
 this.emailaddress = emailaddress;
 }
 public String getPassword() {
 return password;
 }
 public void setPassword(String password) {
 this.password = password;
 }
 public String getFirstName() {
 return firstname;
 }
 public void setFirstName(String firstname) {
 this.firstname = firstname;
 }
 public String getLastName() {
 return lastname;
 }
 public void setLastName(String lastname) {
 this.lastname = lastname;
 }
 public String getPhone() {
 return phone;
 }
 public void setPhone(String phone) {
 this.phone = phone;
 }
}
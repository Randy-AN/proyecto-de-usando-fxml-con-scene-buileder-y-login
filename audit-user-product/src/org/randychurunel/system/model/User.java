
package org.randychurunel.system.model;

public class User {
  private String name ;
  private String lastName;
  private String email;
  private String pass;
  private String user;
  private String iduser
          ;

  public User()
  {
      
  }
  
    public User(String name, String lastname, String email, String pass, String user, String iduser) {
        this.name = name;
        this.lastName = lastname;
        this.email = email;
        this.pass = pass;
        this.user = user;
        this.iduser = iduser;
    }

    public User(String name, String lastname, String email, String user , String pass) {
        this.name = name;
        this.lastName = lastname;
        this.email = email;
        this.user = user;
        this.pass = pass;
    }

  
    
  
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastName;
    }

    public void setLastname(String lastname) {
        this.lastName = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getIduser() {
        return iduser;
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }
  
  
}

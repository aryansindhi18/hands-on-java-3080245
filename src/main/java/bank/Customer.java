package bank;

public class Customer {
  private int id;
  private String username;
  private String name;
  private String password;
  private int accountId;
  private boolean isAuthenticated;

  public boolean isAuthenticated() {
    return this.isAuthenticated;
  }

  public void setIsAuthenticated(boolean isAuthenticated) {
    this.isAuthenticated = isAuthenticated;
  }

  public Customer(int id, String username, String name, String password, int accountId) {
    setId(id);
    setUsername(username);
    setName(name);
    setPassword(password);
    setAccountId(accountId);
    setIsAuthenticated(false);
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public int getAccountId() {
    return this.accountId;
  }

  public void setAccountId(int accountId) {
    this.accountId = accountId;
  }
}

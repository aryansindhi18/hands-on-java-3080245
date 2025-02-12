package bank;

import javax.security.auth.login.LoginException;

public class Authenticate {
  public static Customer login(String username, String password) throws LoginException {
    Customer customer = DataSource.getCustomer(username);
    System.out.println("inside authenticate.login");
    if (customer == null) {
      throw new LoginException("username not found");
    }
    if (password.equals(customer.getPassword())) {
      System.out.println("password matched.");
      customer.setIsAuthenticated(true);
      return customer;
    } else
      throw new LoginException("Incorrect password");

  }

  public static void logout(Customer customer) {
    customer.setIsAuthenticated(false);
  }
}

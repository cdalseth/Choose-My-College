package Project.tests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import Project.*;

public class AccountControllerTest {

 private AccountController aController;
 private DBController dbController;
 @Before
 public void init(){
  aController = new AccountController();
  dbController = new DBController();
  dbController.editAccount("Nathan", "Hansen", "nhansen", "password", 'a', 'Y');
  dbController.editAccount("Colton", "Alseth", "calseth", "password", 'U', 'N');
 }

 @Test
 public void testLogin() {
  Assert.assertTrue(aController.login("zakluetmer","password"));
 }
 
 @Test(expected=IllegalArgumentException.class)
 public void testLoginWrongInfo() {
  aController.login("wrong","info");
 }
 
 @Test(expected=IllegalArgumentException.class)
 public void testLoginDeactivated() {
  aController.login("calseth", "password");
 }

 @Test
 public void testLogout() {
  aController.login("zakluetmer","password");
  Assert.assertTrue(aController.logout().equals(""));
 }
 
 @Test(expected=NullPointerException.class)
 public void testLogoutNull() {
  aController.logout();
 }

 @Test
 public void testSetLoggedIn() {
  aController.setLoggedIn("zakluetmer");
  Assert.assertTrue(aController.getLoggedIn().equals("zakluetmer"));
 }

 //@Test
 //public void testEditUser() {
 // fail("Not yet implemented");
 //}

 //@Test
 //public void testEditAccount() {
 // fail("Not yet implemented");
 //}

 @Test
 public void testDeactivateUser(){
  Assert.assertTrue(aController.deactivateUser("nhansen"));
 }
 
 @Test(expected=IllegalArgumentException.class)
 public void testDeactivateUserAlreadyDeactivated() {
  aController.deactivateUser("calseth");
 }
 
 @Test(expected=IllegalArgumentException.class)
 public void testDeactivateUserDoesntExist() {
  aController.deactivateUser("NA");
 }

 @Test
 public void testGetLoggedIn() {
  aController.login("zakluetmer","password");
  Assert.assertTrue(aController.getLoggedIn().equals("zakluetmer"));
 }

}

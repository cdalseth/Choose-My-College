package Project.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import Project.*;


public class UserFuncControllerTest {
 private UserUI userUI;
 private AdminUI adminUI;
 private LoginUI loginUI;
 private DBController dbcontroller;
  private UserFuncController uFuncController;
 private ArrayList<String> temp;
   
 @Before
 public void init(){
    userUI = new UserUI();
    adminUI = new AdminUI();
    loginUI = new LoginUI();
    dbcontroller = new DBController();
    uFuncController = new UserFuncController();
    //adminUI.addAccount("Bill",  "Smith", "bsmith", "1234567890", 'u');
    dbcontroller.editAccount("Zak","Luetmer","zakluetmer","password",'u','Y');
    dbcontroller.removeSchool("zakluetmer", "QUEENS");
    ArrayList<String> temp = new ArrayList<String>();
 }
 
 //@Test
 //public void testUserFuncController() {
 // fail("Not yet implemented");
 //}

 @Test (expected=IllegalArgumentException.class)
 public void testEditUserEmptyUsernameFail()
 {
   uFuncController.editUser("Zak", "Luetmer", "","password",'u','Y');
 }
 
 @Test (expected=IllegalArgumentException.class)
 public void testEditUserEmptyPasswordFail()
 {
   uFuncController.editUser("Zak", "Luetmer", "zakluetmer","",'u','Y');
 }
 
  @Test (expected=IllegalArgumentException.class)
 public void testEditUserEmptyTypeFail()
  {
    uFuncController.editUser("Zak", "Luetmer", "zakluetmer","password",' ','Y');
  }
  
  @Test (expected=IllegalArgumentException.class)
  public void testEditUserEmptyStatusFail()
  {
    uFuncController.editUser("Zak", "Luetmer", "zakluetmer","password",'u',' ');
  }
  
  @Test
  public void testEditUserFirstName()
 {
   Account account = dbcontroller.getAccount("zakluetmer");
   assertFalse("Accounts first name is not 'David'", account.getFirstName().equals("David"));
   assertTrue("Accounts last name was changed succesfully", 
              uFuncController.editUser("David", "Luetmer", "zakluetmer","password",'u','Y'));
   account = dbcontroller.getAccount("zakluetmer");
   assertTrue("Accounts first name has been changed to 'David'", account.getFirstName().equals("David"));
 }
 
 @Test
 public void testEditUserPassword()
 {
   Account account = dbcontroller.getAccount("zakluetmer");
   assertFalse("Accounts password is not 'password1'", account.getPassword().equals("password1"));
   assertTrue("Accounts password was changed succesfully", 
              uFuncController.editUser("David", "Allen", "zakluetmer","password1",'u','Y'));
   account = dbcontroller.getAccount("zakluetmer");
   assertTrue("Accounts password has been changed to 'password1'", account.getPassword().equals("password1"));
 }
 
 @Test
 public void testEditUserLastName()
 {
   Account account = dbcontroller.getAccount("zakluetmer");
   assertFalse("Accounts last name is not 'Allen'", account.getLastName().equals("Allen"));
   assertTrue("Accounts last name was changed succesfully", 
              uFuncController.editUser("David", "Allen", "zakluetmer","password",'u','Y'));
   account = dbcontroller.getAccount("zakluetmer");
   assertTrue("Accounts last name has been changed to 'Allen'", account.getLastName().equals("Allen"));
 }
 
 @Test
 public void testRemoveSchool() {
  dbcontroller.saveSchool("zakluetmer", "QUEENS");
  dbcontroller.removeSchool("zakluetmer", "QUEENS");
  ArrayList<String> temp = dbcontroller.getUserSavedSchools("zakluetmer");
  assertFalse(temp.contains("QUEENS"));
 }

 @Test
 public void testSaveSchool() {	 
		   assertTrue("The school was successfully saved to the user's list of saved schools.", 
		              dbcontroller.saveSchool("zakluetmer","_TESTSCHOOL"));
 }

}

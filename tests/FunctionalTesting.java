package Project.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.*;

import Project.*;
import dblibrary.project.csci230.UniversityDBLibrary;

public class FunctionalTesting {

	private UserUI userUI;
	private AdminUI adminUI;
	private LoginUI loginUI;
	private HashSet<String> searchResult;
	private DBController dbcontroller;
	private UniversityDBLibrary dataBase;
	
	@Before
	public void init(){
		userUI = new UserUI();
		adminUI = new AdminUI();
		loginUI = new LoginUI();
		dbcontroller = new DBController();
		dataBase = new UniversityDBLibrary("andyic","andyic","csci230");
		HashSet<String> searchResult = new HashSet<String>();
		userUI.editAccount("Zak", "Luetmer", "zakluetmer", "password", 'U', 'Y');
		userUI.removeSchool("zakluetmer", "AUBURN");
	}
	@Test
	public void testLogin() {
		Assert.assertTrue(loginUI.Login("zakluetmer","password"));
	}
	@Test(expected=IllegalArgumentException.class)
	public void testLoginWrongUsername(){
		loginUI.Login("asdf", "password");
	}
	@Test(expected=IllegalArgumentException.class)
	public void testLoginWrongPassword(){
		loginUI.Login("zakluetmer", "asdf");
	}
	@Test(expected=IllegalArgumentException.class)
	public void testLoginDeactivated(){
		dataBase.user_editUser("calseth", "Colton", "Alseth", "password", 'u', 'n');
		loginUI.Login("calseth", "password");
	}
	
	@Test
	public void testSearch(){
		searchResult = userUI.search("colorado college", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
		assertTrue(searchResult.contains("COLORADO COLLEGE"));
		  assertTrue(searchResult.size()==1);
	}
	
	@Test
	 public void testGetUserSavedSchools() {
	  userUI.saveSchool("zakluetmer", "AUBURN");
	  assertTrue(userUI.viewSavedSchools("zakluetmer").contains("AUBURN"));
	 }
	
	@Test
	public void testEditProfile(){
		assertTrue(userUI.editAccount("Zakary", "Luetmer", "zakluetmer", "password", 'U', 'Y'));
	}
	@Test(expected=IllegalArgumentException.class)
	public void testEditProfileBadType(){
		userUI.editAccount("Zakary", "Luetmer", "zakluetmer", "password", 'F', 'Y');
	}
	@Test(expected=IllegalArgumentException.class)
	public void testEditProfileBadStatus(){
		userUI.editAccount("Zakary", "Luetmer", "zakluetmer", "password", 'U', 'F');
	}
	@Test(expected=IllegalArgumentException.class)
	public void testEditProfileEmptyPassword(){
		userUI.editAccount("Zakary", "Luetmer", "zakluetmer", "", 'U', 'F');
	}

	@Test
	public void testViewSavedSchools(){
		userUI.saveSchool("zakluetmer", "AUBURN");
		assertTrue(userUI.viewSavedSchools("zakluetmer").contains("AUBURN"));
	}
	@Test(expected=IllegalArgumentException.class)
	public void testViewSchoolsWrongSchool(){
		userUI.viewSchoolInfo("ASDF");
	}
	
	@Test
	public void testSaveSchool(){
		assertTrue(userUI.saveSchool("zakluetmer", "AUBURN"));
	}
	@Test(expected=IllegalArgumentException.class)
	public void testSaveSchoolWrongUsername(){
		userUI.saveSchool("asdf", "AUBURN");
	}
	@Test(expected=IllegalArgumentException.class)
	public void testSaveSchoolWrongSchool(){
		userUI.saveSchool("zakluetmer", "asdf");
	}
	@Test(expected=IllegalArgumentException.class)
	public void testSaveSchoolAlreadySaved(){
		userUI.saveSchool("zakluetmer", "AUGSBURG");
	}
	
	@Test
	public void testViewDetails(){
		assertTrue(userUI.viewSchoolInfo("AUBURN").getState().equals("ALABAMA"));
	}
	@Test(expected=IllegalArgumentException.class)
	public void testViewDetailsBadSchoolName(){
		userUI.viewSchoolInfo("asdf");
	}
	
	@Test
	public void testRemoveSchools(){
		userUI.saveSchool("zakluetmer", "CSB");
		assertTrue(userUI.removeSchool("zakluetmer", "CSB"));
	}
	@Test(expected=IllegalArgumentException.class)
	public void testRemoveSchoolsBadUsername(){
		userUI.removeSchool("asdf", "AUBURN");
	}
	//use case 10
	@Test 
	public void testViewUsers(){
		assertArrayEquals(adminUI.viewUsers(), dataBase.user_getUsers());
	}
	
	// use case 11
	@Test
	public void testAddNewUser(){
		assertFalse(dbcontroller.isUsernameTaken("jkapahala"));
		assertTrue(adminUI.addAccount("Johnny", "Kapahala", "jkapahala", "password", 'u').equals("Addition Successful!"));
		assertTrue(dbcontroller.isUsernameTaken("jkapahala"));
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testAddNewUserUsernameTakenFail(){
		adminUI.addAccount("Zal","Luetmer","zakluetmer","password",'u');
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testAddNewUserUsernameEmptyFail(){
		adminUI.addAccount("Zal","Luetmer","","password",'u');
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testAddNewUserPasswordEmptyFail(){
		adminUI.addAccount("Zal","Luetmer","zakluetmer","",'u');
	}
	
	// use case 12
	@Test
	public void testEditUser(){
		assertFalse(dbcontroller.getAccount("calseth").getFirstName().equals("Mike"));
		assertTrue(adminUI.editAccount("Mike", "Alseth", "calseth", "password", 'u', 'Y'));
		assertTrue(dbcontroller.getAccount("calseth").getFirstName().equals("Mike"));
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testEditUserUsernameEmptyFail(){
		adminUI.editAccount("Colton", "Alseth", "", "password", 'u', 'Y');
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testEditUserPasswordEmptyFail(){
		adminUI.editAccount("Colton", "Alseth", "calseth", "", 'u', 'Y');
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testEditUserTypeEmptyFail(){
		adminUI.editAccount("Colton", "Alseth", "calseth", "password", ' ', 'Y');
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testEditUserStatusEmptyFail(){
		adminUI.editAccount("Colton", "Alseth", "", "password", 'u', ' ');
	}
	
	//use case 13
	@Test
	public void testDeactivateUser(){
		assertFalse(dbcontroller.isDeactivated("zakluetmer"));
		assertTrue(adminUI.deactivateUser("zakluetmer"));
		assertTrue(dbcontroller.isDeactivated("zakluetmer"));
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testDeactivateUserAlreadyDeactivatedFail(){
		adminUI.deactivateUser("zakluetmer");
		adminUI.deactivateUser("zakluetmer");
	}
	
	// use case 14
	@Test
	public void testViewSchools(){
		assertTrue(adminUI.viewUniversities().contains("SJU"));
		assertTrue(adminUI.viewUniversities().contains("AUGSBURG"));
		assertTrue(adminUI.viewUniversities().contains("AUBURN"));
		assertTrue(adminUI.viewUniversities().contains("CSB"));
	}
	
	//use case 15
	@Test
	public void testAddUniversity(){
		assertFalse(dbcontroller.isSchoolSaved("_TESTTHISSCHOOL"));
		ArrayList<String> emp = new ArrayList<String>();
		adminUI.addUniversity("_TESTTHISSCHOOL", "MINNESOTA", "URBAN", "STATE", 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, emp);
		assertTrue(dbcontroller.isSchoolSaved("_TESTTHISSCHOOL"));
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testAddUniversityEmptyNameFail(){
		adminUI.addUniversity("", "", "", "", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testAddUniversityNameTakenFail(){
		adminUI.addUniversity("SJU", "", "", "", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	}
	
	//use case 16... finally done dawg
	@Test
	public void testEditUniversity(){
		ArrayList<String> emp = new ArrayList<String>();
		adminUI.addUniversity("_TESTTHISSCHOOL", "MINNESOTA", "URBAN", "STATE", 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, emp);
		assertFalse(dbcontroller.getUniversity("_TESTTHISSCHOOL").getExpenses() == 5000);
		assertFalse(dbcontroller.getUniversity("_TESTTHISSCHOOL").getState().equals("TEXAS"));
		assertTrue(adminUI.editUniversity("_TESTTHISSCHOOL", "TEXAS", "URBAN", "-1", 0, 0, 1, 1, 5000, 0, 0, 0, 0, 1, 1, 1, emp));
		assertTrue(dbcontroller.getUniversity("_TESTTHISSCHOOL").getExpenses() == 5000);
		assertTrue(dbcontroller.getUniversity("_TESTTHISSCHOOL").getState().equals("TEXAS"));
	}
	
	@Test
	public void testEditUniversityNotASchoolFail(){
		ArrayList<String> emp = new ArrayList<String>();
		assertFalse(adminUI.editUniversity("_DOESNTEXIST", "MINNESOTA", "URBAN", "STATE", 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, emp));
	}
	
	@After
	public void after(){
		//removes after testAddNewUser
		dataBase.user_deleteUser("jkapahala");
		
		//reset after testEditUser
		dataBase.user_editUser("calseth", "Colton", "Alseth", "password", 'u', 'Y');
		
		//reactivating Zak after testDeactivateUser + testDeactivateUserAlreadyDeactivatedFail
		dataBase.user_editUser("zakluetmer", "Zak", "Luetmer", "password", 'u', 'Y');
		
		//deletes the test school from the database after testAddUniversity + testEditSchool
		dataBase.university_deleteUniversity("_TESTTHISSCHOOL");
	}
}

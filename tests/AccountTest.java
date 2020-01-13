package Project.tests;

import static org.junit.Assert.*;

import org.junit.*;

import Project.*;

import org.junit.Test;

public class AccountTest {

	private Account account;
	private Account account2;
	private Account account3;
	private DBController dbController;
	
	@Before
	public void init(){
		account = new Account("Zak","Luetmer","zakluetmer","password",'u','Y');
		dbController = new DBController();
		dbController.editAccount("Zak", "Luetmer", "zakluetmer", "password", 'u', 'Y');
	}
	
	@Test
	public void testAccount(){
		assertTrue(account!=null);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testAccountWrongType(){
		account2 = new Account("Zak","Luetmer","zakluetmer","password",'F','Y');
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAccountWrongStatus(){
		account3 = new Account("Zak","Luetmer","zakluetmer","password",'u','S');
	}
	
	@Test
	public void testGetFirstName() {
		Assert.assertTrue(account.getFirstName().equals("Zak"));
	}

	@Test
	public void testSetFirstName() {
		account.setFirstName("zak");
		Assert.assertTrue(account.getFirstName().equals("zak"));
	}

	@Test
	public void testGetLastName() {
		Assert.assertTrue(account.getLastName().equals("Luetmer"));
	}

	@Test
	public void testSetLastName() {
		account.setFirstName("luetmer");
		Assert.assertTrue(account.getFirstName().equals("luetmer"));
	}

	@Test
	public void testGetPassword() {
		Assert.assertTrue(account.getPassword().equals("password"));
	}

	@Test
	public void testSetPassword() {
		account.setPassword("newPass");
		Assert.assertTrue(account.getPassword().equals("newPass"));
	}

	@Test
	public void testGetUsername() {
		Assert.assertTrue(account.getUsername().equals("zakluetmer"));
	}

	@Test
	public void testGetType() {
		Assert.assertTrue(account.getType()==('u'));
	}

	@Test
	public void testSetType() {
		account.setType('a');
		Assert.assertTrue(account.getType()==('a'));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetTypeWrongInput() {
		account.setType('v');
	}

	@Test
	public void testGetStatus() {
		Assert.assertTrue(account.getStatus()==('Y'));
	}

	@Test
	public void testSetStatus() {
		account.setStatus('Y');
		Assert.assertTrue(account.getStatus()==('Y'));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetStatusWrongInput() {
		account.setStatus('G');
	}

}

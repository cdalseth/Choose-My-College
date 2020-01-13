package Project.tests;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

import Project.*;


public class AdminFuncControllerTest {

	private AdminFuncController aFuncController;
	@Before
	public void init(){
		aFuncController = new AdminFuncController();
	}

	//@Test
	//public void testAddAccount() {
	//	fail("Not yet implemented");
	//}

	//@Test
	//public void testEditUniversity() {
	//	fail("Not yet implemented");
	//}

	@Test
	public void testViewUsers() {
		String[][] list = aFuncController.viewUsers();
		int counter=0;
		for(int i = 0;i<list.length;i++){
			counter++;
		}
		Assert.assertTrue(counter>=5);
	}

	@Test
	public void testDisplayInfo() {
		ArrayList<String> newList = aFuncController.displayInfo("nhansen");
		int counter = 0;
		for(int i = 0;i<newList.size();i++){
			counter++;
		}
		Assert.assertTrue(counter==6);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testDisplayInfoWrongUsername() {
		aFuncController.displayInfo("NotAUsername");
	}

	//@Test
	//public void testEditAccount() {
	//	fail("Not yet implemented");
	//}


	@Test
	public void testViewUniversities() {
		ArrayList<String> univList = aFuncController.viewUniversities();
		int counter = 0;
		for(int i = 0;i<univList.size();i++){
			counter++;
		}
		Assert.assertTrue(counter>=100);
	}

}

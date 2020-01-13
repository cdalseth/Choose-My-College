package Project.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.*;


import Project.SearchController;

public class SearchControllerTest {

	SearchController sController;
	
	@Before
	public void init()
	{
		sController = new SearchController();
	}
	
	/* still need to do this
	@Test
	public void testSearch()
	{
		fail("Not yet implemented");
	}
	*/
	
	@Test (expected = IllegalArgumentException.class)
	public void testFindReccomendationsFail()
	{
		sController.findReccomendations("South Harmon Institute of Technology");
	}
	
	@Test
	public void testFindReccomendations()
	{
		ArrayList<String> listRecs = sController.findReccomendations("_TESTSCHOOL");
		
		assertTrue("The first reccomended school for _TESTSCHOOL is '_TESTSCHOOLMATCH1'",  listRecs.get(0).equals("_TESTSCHOOLMATCH1"));
		assertTrue("The second reccomended school for _TESTSCHOOL is '_TESTSCHOOLMATCH2'", listRecs.get(1).equals("_TESTSCHOOLMATCH2"));
		assertTrue("The third reccomended school for _TESTSCHOOL is '_TESTSCHOOLMATCH3'",  listRecs.get(2).equals("_TESTSCHOOLMATCH3"));
		assertTrue("The fourth reccomended school for _TESTSCHOOL is '_TESTSCHOOLMATCH4'", listRecs.get(3).equals("_TESTSCHOOLMATCH4"));
		assertTrue("The fifth reccomended school for _TESTSCHOOL is '_TESTSCHOOLMATCH5'",  listRecs.get(4).equals("_TESTSCHOOLMATCH5"));
	}
}

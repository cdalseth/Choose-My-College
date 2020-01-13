package Project.tests;

import java.util.*;
import static org.junit.Assert.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Project.*;
import dblibrary.project.csci230.UniversityDBLibrary;

public class DBControllerTest {

 private UserUI userUI;
 private AdminUI adminUI;
 private LoginUI loginUI;
 private DBController dbcontroller;

 private UniversityDBLibrary dataBase = new UniversityDBLibrary("andyic", "andyic", "csci230");

 private SearchController sController;
 private HashSet<String> searchResult;

 @Before
 public void init() {
  userUI = new UserUI();
  adminUI = new AdminUI();
  loginUI = new LoginUI();
  dbcontroller = new DBController();
  sController = new SearchController();

  ArrayList<String> emphasis = new ArrayList<String>();
  searchResult = new HashSet<String>();
  searchResult.clear();

  // need to remove the school from the user's list of schools before
  // testing saveSchool
  dbcontroller.removeSchool("zakluetmer", "_TESTSCHOOL");
  dataBase.university_deleteUniversity("DUMMYSCHOOL");

  // reseting the info for test purposes
  dbcontroller.editAccount("Zak", "Luetmer", "zakluetmer", "password", 'u', 'Y');
  dataBase.university_deleteUniversity("SEXTON");

  // Must remove temporary user
  dataBase.user_deleteUser("Person");

  dataBase.university_deleteUniversity("SEXTON2");

  dataBase.university_removeUniversityEmphasis ("SEXTON2", "College");
 }

 @Test(expected = IllegalArgumentException.class)
 public void testGetAccountError() {
  dbcontroller.getAccount("SomethingThatWillNotbeAUserName");
 }

 @Test(expected = IllegalArgumentException.class)
 public void testGetUniversityError() {
  dbcontroller.getUniversity("ANameOfAUniversityThatWillNotBeInTheDatabase");
 }

 @Test(expected = IllegalArgumentException.class)
 public void testGetUserSavedSchoolsError() {
  dbcontroller.getUserSavedSchools("calseth");
 }

 @Test(expected = IllegalArgumentException.class)
 public void testDeactivateUserAlreadyDeactivated() {
  dbcontroller.deactivateUser("luser");
 }

 @Test(expected = IllegalArgumentException.class)
 public void testDeactivateUserErrorWrongUser() {
  dbcontroller.deactivateUser("asdfasdfasdfasdf");
 }

 @Test
 public void testGetAccount() {
  Account something = dbcontroller.getAccount("zakluetmer");
  String name = something.getFirstName();
  assertTrue(name.equals("Zak"));
 }

 @Test
 public void testGetUniversity() {
  assertTrue(dbcontroller.getUniversity("_TESTSCHOOL").getLocation().equals("URBAN"));
 }

 @Test
 public void testDisplayUniversity() {
  int something = 0;
  for (int i = 0; i <= dbcontroller.displayUniversity("ADELPHI").size(); i++) {
   something++;
  }
  assertTrue(something > 6);
  assertTrue(dbcontroller.displayUniversity("ADELPHI").get(3).equals("PRIVATE"));
  assertTrue(dbcontroller.displayUniversity("ADELPHI").get(2).equals("-1"));
 }

 @Test(expected = IllegalArgumentException.class)
 public void testAddUniversityError() {
  ArrayList<String> emphasis = new ArrayList<String>();
  // invalid name//
  dbcontroller.addUniversity("", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90, 15000, 20, 50, 5,
    5, 5, emphasis);

 }

 @Test(expected = IllegalArgumentException.class)
 public void testAddUniversitySameName() {
  ArrayList<String> emphasis = new ArrayList<String>();
  dbcontroller.addUniversity("ADELPHI", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90, 15000, 20,
    50, 5, 5, 5, emphasis);
 }

 @Test(expected = IllegalArgumentException.class)
 public void testAddUniversityIllegalArgument() {
  ArrayList<String> emphasis = new ArrayList<String>();
  // invalid location
  dbcontroller.addUniversity("SEXTON", "MINNESOTA", "EARTH", "PRIVATE", 100, 90, 750, 750, 10000, 90, 15000, 20,
    50, 5, 5, 5, emphasis);
 }

 @Test(expected = IllegalArgumentException.class)
 public void testAddUniversityIllegalArgument2() {
  // invalid control
  ArrayList<String> emphasis = new ArrayList<String>();
  dbcontroller.addUniversity("SEXTON", "MINNESOTA", "URBAN", "ONLINE", 100, 90, 750, 750, 10000, 90, 15000, 20,
    50, 5, 5, 5, emphasis);
  }

 @Test
 public void testEditUniversity() {
  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));

  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "SUBURBAN", "PRIVATE", 100, 90, 750, 750, 10000,
    90, 15000, 20, 50, 5, 5, 5, null));

  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "SMALL-CITY", "PRIVATE", 100, 90, 750, 750, 10000,
    90, 15000, 20, 50, 5, 5, 5, null));

  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "-1", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));
 }
 
 
 @Test
 public void testAddUniversityEmp(){
  ArrayList<String> addEmp = new ArrayList<String>();
  addEmp.add("College");
 assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", -1, 50.0, 750, 750, 10000, 90,
   15000, 20, 50, 5, 5, 5, addEmp));

 dataBase.university_removeUniversityEmphasis ("SEXTON2", "College");
 }

 @Test
 public void testEditUniversityWithValidLocations() {
  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));

  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "SUBURBAN", "PRIVATE", 100, 90, 750, 750, 10000,
    90, 15000, 20, 50, 5, 5, 5, null));

  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "SMALL-CITY", "PRIVATE", 100, 90, 750, 750, 10000,
    90, 15000, 20, 50, 5, 5, 5, null));

  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "-1", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));
 }

 @Test
 public void testEditUniversityWithValidControl() {
  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));

  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "STATE", 100, 90, 750, 750, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));

  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "CITY", 100, 90, 750, 750, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));

  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "-1", 100, 90, 750, 750, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));
 }

 @Test
 public void testEditUniversityWithValidNumberOfStudents() {
  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", -1, 90, 750, 750, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));

  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 0, 90, 750, 750, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));

  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 1, 90, 750, 750, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));

  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));
 }

 @Test
 public void testEditUniversityWithValidPercentFemale() {
  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", -1, 50, 750, 750, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));

  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", -1, -1, 750, 750, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));

  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", -1, 0, 750, 750, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));

  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", -1, 1, 750, 750, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));

  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", -1, 99, 750, 750, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));

  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", -1, 100, 750, 750, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));
 }

 @Test
 public void testEditUniversityWithValidSatVerbal() {
  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", -1, 100, 300, 750, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));

  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", -1, 100, -1, 750, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));

  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", -1, 100, 0, 750, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));

  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", -1, 100, 1, 750, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));

  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", -1, 100, 799, 750, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));

  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", -1, 100, 800, 750, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));
 }

 @Test
 public void testEditUniversityWithValidSatMath() {
  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", -1, 100, 800, 300, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));
  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", -1, 100, 800, -1, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));
  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", -1, 100, 800, 0, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));
  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", -1, 100, 800, 1, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));
  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", -1, 100, 800, 799, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));
  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", -1, 100, 800, 800, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));
 }

 @Test
 public void testEditUniversityWithValidExpense() {
  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));
  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, -1, 90,
    15000, 20, 50, 5, 5, 5, null));
  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 0, 90,
    15000, 20, 50, 5, 5, 5, null));

 }

 @Test
 public void testEditUniversityWithValidPercentFA() {
  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 80,
    15000, 20, 50, 5, 5, 5, null));
  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, -1,
    15000, 20, 50, 5, 5, 5, null));
  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 0,
    15000, 20, 50, 5, 5, 5, null));
  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 1,
    15000, 20, 50, 5, 5, 5, null));
  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 99,
    15000, 20, 50, 5, 5, 5, null));
  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 100,
    15000, 20, 50, 5, 5, 5, null));
 }

 @Test
 public void testEditUniversityWithValidNumberOfApplicants() {
  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    0, 20, 50, 5, 5, 5, null));
  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    -1, 20, 50, 5, 5, 5, null));
  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));
 }

 @Test
 public void testEditUniversityWithValidPercentAdmitted() {
  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));
  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, -1, 50, 5, 5, 5, null));
  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 0, 50, 5, 5, 5, null));
  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 1, 50, 5, 5, 5, null));
  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 99, 50, 5, 5, 5, null));
  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 100, 50, 5, 5, 5, null));
 }

 @Test
 public void testEditUniversityWithValidPercentEnrolled() {
  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));
  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 20, -1, 5, 5, 5, null));
  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 20, 0, 5, 5, 5, null));
  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 20, 1, 5, 5, 5, null));
  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 20, 99, 5, 5, 5, null));
  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 20, 100, 5, 5, 5, null));
 }

 @Test
 public void testEditUniversityWithValidAcademicScale() {
  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 20, 50, 3, 5, 5, null));
  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 20, 50, -1, 5, 5, null));
  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 20, 50, 1, 5, 5, null));
  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 20, 50, 2, 5, 5, null));
  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 20, 50, 4, 5, 5, null));
  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));
 }

 @Test
 public void testEditUniversityWithValidSocialScale() {
  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 20, 50, 5, 3, 3, null));
  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 20, 50, 5, -1, -1, null));
  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 20, 50, 5, 1, 1, null));
  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 20, 50, 5, 2, 2, null));
  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 20, 50, 5, 4, 4, null));
  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));
 }

 @Test
 public void testEditUniversityWithValidLifeScale() {
  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 20, 50, 5, 5, 3, null));
  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 20, 50, 5, 5, -1, null));
  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 20, 50, 5, 5, 1, null));
  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 20, 50, 5, 5, 2, null));
  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 20, 50, 5, 5, 4, null));
  assertTrue(dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));
 }

 // invalid location
 @Test(expected = IllegalArgumentException.class)
 public void testEditUniversityInvalidLocation() {

  dbcontroller.editUniversity("SEXTON", "MINNESOTA", "EARTH", "PRIVATE", 100, 90, 750, 750, 10000, 90, 15000, 20,
    50, 5, 5, 5, null);
 }

 // invalid control
 @Test(expected = IllegalArgumentException.class)
 public void testEditUniversityInvalidControl() {
  dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "ONLINE", 100, 90, 750, 750, 10000, 90, 15000, 20,
    50, 5, 5, 5, null);
 }

 // invalid number of students
 @Test(expected = IllegalArgumentException.class)
 public void testEditUniversityInvalidNumberOfStudents() {
  dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", (-5000), 90, 750, 750, 10000, 90, 15000,
    20, 50, 5, 5, 5, null);
 }

 @Test(expected = IllegalArgumentException.class)
 public void testEditUniversityInvalidNumberOfStudents2() {
  dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", -2, 90, 750, 750, 10000, 90, 15000, 20,
    50, 5, 5, 5, null);
 }

 // invalid percent female
 @Test(expected = IllegalArgumentException.class)
 public void testEditUniversityInvalidPercentFemale() {
  dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, -30, 750, 750, 10000, 90, 15000, 20,
    50, 5, 5, 5, null);
 }

 @Test(expected = IllegalArgumentException.class)
 public void testEditUniversityInvalidPercentFemale2() {
  dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 150, 750, 750, 10000, 90, 15000, 20,
    50, 5, 5, 5, null);
 }

 @Test(expected = IllegalArgumentException.class)
 public void testEditUniversityInvalidPercentFemale3() {
  dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, -2, 750, 750, 10000, 90, 15000, 20,
    50, 5, 5, 5, null);
 }

 @Test(expected = IllegalArgumentException.class)
 public void testEditUniversityInvalidPercentFemale4() {
  dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 101, 750, 750, 10000, 90, 15000, 20,
    50, 5, 5, 5, null);
 }

 @Test(expected = IllegalArgumentException.class)
 public void testEditUniversityInvalidPercentFemale5() {
  dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, -.05, 750, 750, 10000, 90, 15000,
    20, 50, 5, 5, 5, null);
 }

 // invalid satVerbal
 @Test(expected = IllegalArgumentException.class)
 public void testEditUniversityInvalidSatVerbal() {
  dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 850, 750, 10000, 90, 15000, 20,
    50, 5, 5, 5, null);
 }

 // invalid satVerbal
 @Test(expected = IllegalArgumentException.class)
 public void testEditUniversityInvalidSatVerbal2() {
  dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, -50, 750, 10000, 90, 15000, 20,
    50, 5, 5, 5, null);
 }

 // invalid satVerbal
 @Test(expected = IllegalArgumentException.class)
 public void testEditUniversityInvalidSatVerbal3() {
  dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, -2, 750, 10000, 90, 15000, 20,
    50, 5, 5, 5, null);
 }

 // invalid satVerbal
 @Test(expected = IllegalArgumentException.class)
 public void testEditUniversityInvalidSatVerbal4() {
  dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 801, 750, 10000, 90, 15000, 20,
    50, 5, 5, 5, null);
 }

 // invalid satMath
 @Test(expected = IllegalArgumentException.class)
 public void testEditUniversityInvalidSatMath() {
  dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, -50, 10000, 90, 15000, 20,
    50, 5, 5, 5, null);
 }

 // invalid satMath
 @Test(expected = IllegalArgumentException.class)
 public void testEditUniversityInvalidSatMath2() {
  dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, -2, 10000, 90, 15000, 20,
    50, 5, 5, 5, null);
 }

 // invalid satMath
 @Test(expected = IllegalArgumentException.class)
 public void testEditUniversityInvalidSatMath3() {
  dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, -801, 10000, 90, 15000, 20,
    50, 5, 5, 5, null);
 }

 // invalid satMath
 @Test(expected = IllegalArgumentException.class)
 public void testEditUniversityInvalidSatMath4() {
  dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, -950, 10000, 90, 15000, 20,
    50, 5, 5, 5, null);
 }

 // invalid exp
 @Test(expected = IllegalArgumentException.class)
 public void testEditUniversityInvalidExp() {
  dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, -10000, 90, 15000, 20,
    50, 5, 5, 5, null);
 }

 // invalid exp
 @Test(expected = IllegalArgumentException.class)
 public void testEditUniversityInvalidExp2() {
  dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, -2, 90, 15000, 20, 50,
    5, 5, 5, null);
 }

 // invalid percent FA
 @Test(expected = IllegalArgumentException.class)
 public void testEditUniversityInvalidPercentFA() {
  dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, 1000, -30, 15000, 20,
    50, 5, 5, 5, null);
 }

 // invalid percent FA
 @Test(expected = IllegalArgumentException.class)
 public void testEditUniversityInvalidPercentFA2() {
  dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, 1000, 150, 15000, 20,
    50, 5, 5, 5, null);
 }

 // invalid percent FA
 @Test(expected = IllegalArgumentException.class)
 public void testEditUniversityInvalidPercentFA3() {
  dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, 1000, -2, 15000, 20,
    50, 5, 5, 5, null);
 }

 // invalid percent FA
 @Test(expected = IllegalArgumentException.class)
 public void testEditUniversityInvalidPercentFA4() {
  dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, 1000, 101, 15000, 20,
    50, 5, 5, 5, null);
 }

 // invalid percent FA
 @Test(expected = IllegalArgumentException.class)
 public void testEditUniversityInvalidPercentFA5() {
  dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, 1000, -.05, 15000, 20,
    50, 5, 5, 5, null);
 }

 // invalid percent numApplicants
 @Test(expected = IllegalArgumentException.class)
 public void testEditUniversityInvalidNumApplicants() {
  dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, 1000, 20, -1000, 20,
    50, 5, 5, 5, null);
 }

 // invalid percent numApplicants
 @Test(expected = IllegalArgumentException.class)
 public void testEditUniversityInvalidNumApplicants2() {
  dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, 1000, 20, -2, 20, 50,
    5, 5, 5, null);
 }

 // invalid PercentAdmitted
 @Test(expected = IllegalArgumentException.class)
 public void testEditUniversityInvalidPercentAdmitted() {
  dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, 1000, 20, 15000, -30,
    50, 5, 5, 5, null);
 }

 // invalid PercentAdmitted
 @Test(expected = IllegalArgumentException.class)
 public void testEditUniversityInvalidPercentAdmitted2() {
  dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, 1000, 20, 15000, 150,
    50, 5, 5, 5, null);
 }

 // invalid PercentAdmitted
 @Test(expected = IllegalArgumentException.class)
 public void testEditUniversityInvalidPercentAdmitted3() {
  dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, 1000, 20, 15000, -2,
    50, 5, 5, 5, null);
 }

 // invalid PercentAdmitted
 @Test(expected = IllegalArgumentException.class)
 public void testEditUniversityInvalidPercentAdmitted4() {
  dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, 1000, 20, 15000, 101,
    50, 5, 5, 5, null);
 }

 // invalid PercentAdmitted
 @Test(expected = IllegalArgumentException.class)
 public void testEditUniversityInvalidPercentAdmitted5() {
  dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, 1000, 20, 15000, -.5,
    50, 5, 5, 5, null);
 }

 // invalid PercentEnrolled
 @Test(expected = IllegalArgumentException.class)
 public void testEditUniversityInvalidPercentEnrolled() {
  dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, 1000, 20, 15000, 50,
    -30, 5, 5, 5, null);
 }

 // invalid PercentEnrolled
 @Test(expected = IllegalArgumentException.class)
 public void testEditUniversityInvalidPercentEnrolled2() {
  dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, 1000, 20, 15000, 50,
    150, 5, 5, 5, null);
 }

 // invalid PercentEnrolled
 @Test(expected = IllegalArgumentException.class)
 public void testEditUniversityInvalidPercentEnrolled3() {
  dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, 1000, 20, 15000, 50,
    -2, 5, 5, 5, null);
 }

 // invalid PercentEnrolled
 @Test(expected = IllegalArgumentException.class)
 public void testEditUniversityInvalidPercentEnrolled4() {
  dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, 1000, 20, 15000, 50,
    101, 5, 5, 5, null);
 }

 // invalid PercentEnrolled
 @Test(expected = IllegalArgumentException.class)
 public void testEditUniversityInvalidPercentEnrolled5() {
  dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, 1000, 20, 15000, 50,
    -.5, 5, 5, 5, null);
 }

 // invalid AcademicScale
 @Test(expected = IllegalArgumentException.class)
 public void testEditUniversityInvalidAcademicScale() {
  dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, 1000, 20, 15000, 50,
    50, -6, 5, 5, null);
 }

 // invalid AcademicScale
 @Test(expected = IllegalArgumentException.class)
 public void testEditUniversityInvalidAcademicScale2() {
  dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, 1000, 20, 15000, 50,
    50, 8, 5, 5, null);
 }

 // invalid AcademicScale
 @Test(expected = IllegalArgumentException.class)
 public void testEditUniversityInvalidAcademicScale3() {
  dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, 1000, 20, 15000, 50,
    50, -2, 5, 5, null);
 }

 // invalid AcademicScale
 @Test(expected = IllegalArgumentException.class)
 public void testEditUniversityInvalidAcademicScale4() {
  dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, 1000, 20, 15000, 50,
    50, 0, 5, 5, null);
 }

 // invalid AcademicScale
 @Test(expected = IllegalArgumentException.class)
 public void testEditUniversityInvalidAcademicScale5() {
  dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, 1000, 20, 15000, 50,
    50, 6, 5, 5, null);
 }

 // invalid AcademicScale
 @Test(expected = IllegalArgumentException.class)
 public void testEditUniversityInvalidSocialScale() {
  dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, 1000, 20, 15000, 50,
    50, 5, -6, 5, null);
 }

 // invalid AcademicScale
 @Test(expected = IllegalArgumentException.class)
 public void testEditUniversityInvalidSocialScale2() {
  dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, 1000, 20, 15000, 50,
    50, 5, 8, 5, null);
 }

 // invalid AcademicScale
 @Test(expected = IllegalArgumentException.class)
 public void testEditUniversityInvalidSocialScale3() {
  dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, 1000, 20, 15000, 50,
    50, 5, -2, 5, null);
 }

 // invalid AcademicScale
 @Test(expected = IllegalArgumentException.class)
 public void testEditUniversityInvalidSocialScale4() {
  dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, 1000, 20, 15000, 50,
    50, 5, 0, 5, null);
 }

 // invalid SocialScale
 @Test(expected = IllegalArgumentException.class)
 public void testEditUniversityInvalidSocialScale5() {
  dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, 1000, 20, 15000, 50,
    50, 5, 6, 5, null);
 }

 // invalid LifeScale
 @Test(expected = IllegalArgumentException.class)
 public void testEditUniversityInvalidLifeScale() {
  dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, 1000, 20, 15000, 50,
    50, 5, 5, -6, null);
 }

 // invalid AcademicScale
 @Test(expected = IllegalArgumentException.class)
 public void testEditUniversityInvalidLifeScale2() {
  dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, 1000, 20, 15000, 50,
    50, 5, 5, 8, null);
 }

 // invalid AcademicScale
 @Test(expected = IllegalArgumentException.class)
 public void testEditUniversityInvalidLifeScale3() {
  dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, 1000, 20, 15000, 50,
    50, 5, 5, -2, null);
 }

 // invalid AcademicScale
 @Test(expected = IllegalArgumentException.class)
 public void testEditUniversityInvalidLifeScale4() {
  dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, 1000, 20, 15000, 50,
    50, 5, 5, 0, null);
 }

 // invalid LifeScale
 @Test(expected = IllegalArgumentException.class)
 public void testEditUniversityInvalidLifeScale5() {
  dbcontroller.editUniversity("SEXTON", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, 1000, 20, 15000, 50,
    50, 5, 5, 6, null);
 }

 @Test
 public void testAddUniversity() {
  ArrayList<String> emphasis = new ArrayList<String>();
  // reseting the info for test purposes
  dbcontroller.editAccount("Zak", "Luetmer", "zakluetmer", "password", 'u', 'Y');
  dataBase.university_deleteUniversity("SEXTON");
 }
 
 @Test(expected = IllegalArgumentException.class)
 public void testAddUniversitySchoolAlreadySaved(){
 assertTrue(dbcontroller.addUniversity("ADELPHI", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
   15000, 20, 50, 5, 5, 5, null));
 }


 @Test
 public void testAddUniversityWithValidLocations() {
  ArrayList<String> emp = new ArrayList<String>();
  emp.add("Science");
  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));
  dataBase.university_deleteUniversity("SEXTON2");

  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "SUBURBAN", "PRIVATE", 100, 90, 750, 750, 10000,
    90, 15000, 20, 50, 5, 5, 5, null));
  dataBase.university_deleteUniversity("SEXTON2");

  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "SMALL-CITY", "PRIVATE", 100, 90, 750, 750, 10000,
    90, 15000, 20, 50, 5, 5, 5, null));
  dataBase.university_deleteUniversity("SEXTON2");

  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "-1", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));
  dataBase.university_deleteUniversity("SEXTON2");
 }

 @Test(expected = IllegalArgumentException.class)
 public void testAddUniversityIllegalName() {
  ArrayList<String> emphasis = new ArrayList<String>();
  // invalid name//
  dbcontroller.addUniversity("", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90, 15000, 20, 50, 5,
    5, 5, emphasis);

 }

 @Test
 public void testAddUniversityWithValidControl() {
  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));
  dataBase.university_deleteUniversity("SEXTON2");

  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "STATE", 100, 90, 750, 750, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));
  dataBase.university_deleteUniversity("SEXTON2");

  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "CITY", 100, 90, 750, 750, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));
  dataBase.university_deleteUniversity("SEXTON2");

  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "-1", 100, 90, 750, 750, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));
  dataBase.university_deleteUniversity("SEXTON2");
 }

 @Test
 public void testAddUniversityWithValidNumberOfStudents() {
  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", -1, 90, 750, 750, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));
  dataBase.university_deleteUniversity("SEXTON2");

  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 0, 90, 750, 750, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));
  dataBase.university_deleteUniversity("SEXTON2");

  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 1, 90, 750, 750, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));
  dataBase.university_deleteUniversity("SEXTON2");

  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));
  dataBase.university_deleteUniversity("SEXTON2");
 }

 @Test
 public void testAddUniversityWithValidPercentFemale() {
  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", -1, 50.0, 750, 750, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));
  dataBase.university_deleteUniversity("SEXTON2");

  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", -1, -1.0, 750, 750, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));
  dataBase.university_deleteUniversity("SEXTON2");

  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", -1, 0.0, 750, 750, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));
  dataBase.university_deleteUniversity("SEXTON2");

  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", -1, 1.0, 750, 750, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));
  dataBase.university_deleteUniversity("SEXTON2");

  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", -1, 99.0, 750, 750, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));
  dataBase.university_deleteUniversity("SEXTON2");

  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", -1, 100.0, 750, 750, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));
  dataBase.university_deleteUniversity("SEXTON2");
 }

 @Test
 public void testAddUniversityWithValidSatVerbal() {
  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", -1, 100, 300, 750, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));
  dataBase.university_deleteUniversity("SEXTON2");

  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", -1, 100, -1, 750, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));
  dataBase.university_deleteUniversity("SEXTON2");

  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", -1, 100, 0, 750, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));
  dataBase.university_deleteUniversity("SEXTON2");

  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", -1, 100, 1, 750, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));
  dataBase.university_deleteUniversity("SEXTON2");

  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", -1, 100, 799, 750, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));
  dataBase.university_deleteUniversity("SEXTON2");

  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", -1, 100, 800, 750, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));
  dataBase.university_deleteUniversity("SEXTON2");
 }

 @Test
 public void testAddUniversityWithValidSatMath() {
  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", -1, 100, 800, 300, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));
  dataBase.university_deleteUniversity("SEXTON2");
  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", -1, 100, 800, -1, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));
  dataBase.university_deleteUniversity("SEXTON2");
  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", -1, 100, 800, 0, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));
  dataBase.university_deleteUniversity("SEXTON2");
  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", -1, 100, 800, 1, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));
  dataBase.university_deleteUniversity("SEXTON2");
  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", -1, 100, 800, 799, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));
  dataBase.university_deleteUniversity("SEXTON2");
  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", -1, 100, 800, 800, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));
  dataBase.university_deleteUniversity("SEXTON2");
 }

 @Test
 public void testAddUniversityWithValidExpense() {
  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));
  dataBase.university_deleteUniversity("SEXTON2");
  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, -1, 90,
    15000, 20, 50, 5, 5, 5, null));
  dataBase.university_deleteUniversity("SEXTON2");
  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 0, 90,
    15000, 20, 50, 5, 5, 5, null));
  dataBase.university_deleteUniversity("SEXTON2");

 }

 @Test
 public void testAddUniversityWithValidPercentFA() {
  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 80,
    15000, 20, 50, 5, 5, 5, null));
  dataBase.university_deleteUniversity("SEXTON2");
  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, -1,
    15000, 20, 50, 5, 5, 5, null));
  dataBase.university_deleteUniversity("SEXTON2");
  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 0,
    15000, 20, 50, 5, 5, 5, null));
  dataBase.university_deleteUniversity("SEXTON2");
  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 1,
    15000, 20, 50, 5, 5, 5, null));
  dataBase.university_deleteUniversity("SEXTON2");
  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 99,
    15000, 20, 50, 5, 5, 5, null));
  dataBase.university_deleteUniversity("SEXTON2");
  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 100,
    15000, 20, 50, 5, 5, 5, null));
  dataBase.university_deleteUniversity("SEXTON2");
 }

 @Test
 public void testAddUniversityWithValidNumberOfApplicants() {
  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    0, 20, 50, 5, 5, 5, null));
  dataBase.university_deleteUniversity("SEXTON2");
  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    -1, 20, 50, 5, 5, 5, null));
  dataBase.university_deleteUniversity("SEXTON2");
  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));
  dataBase.university_deleteUniversity("SEXTON2");
 }

 @Test
 public void testAddUniversityWithValidPercentAdmitted() {
  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));
  dataBase.university_deleteUniversity("SEXTON2");
  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, -1, 50, 5, 5, 5, null));
  dataBase.university_deleteUniversity("SEXTON2");
  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 0, 50, 5, 5, 5, null));
  dataBase.university_deleteUniversity("SEXTON2");
  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 1, 50, 5, 5, 5, null));
  dataBase.university_deleteUniversity("SEXTON2");
  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 99, 50, 5, 5, 5, null));
  dataBase.university_deleteUniversity("SEXTON2");
  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 100, 50, 5, 5, 5, null));
  dataBase.university_deleteUniversity("SEXTON2");
 }

 @Test
 public void testAddUniversityWithValidPercentEnrolled() {
  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));
  dataBase.university_deleteUniversity("SEXTON2");
  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 20, -1, 5, 5, 5, null));
  dataBase.university_deleteUniversity("SEXTON2");
  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 20, 0, 5, 5, 5, null));
  dataBase.university_deleteUniversity("SEXTON2");
  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 20, 1, 5, 5, 5, null));
  dataBase.university_deleteUniversity("SEXTON2");
  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 20, 99, 5, 5, 5, null));
  dataBase.university_deleteUniversity("SEXTON2");
  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 20, 100, 5, 5, 5, null));
  dataBase.university_deleteUniversity("SEXTON2");
 }

 @Test
 public void testAddUniversityWithValidAcademicScale() {
  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 20, 50, 3, 5, 5, null));
  dataBase.university_deleteUniversity("SEXTON2");
  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 20, 50, -1, 5, 5, null));
  dataBase.university_deleteUniversity("SEXTON2");
  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 20, 50, 1, 5, 5, null));
  dataBase.university_deleteUniversity("SEXTON2");
  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 20, 50, 2, 5, 5, null));
  dataBase.university_deleteUniversity("SEXTON2");
  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 20, 50, 4, 5, 5, null));
  dataBase.university_deleteUniversity("SEXTON2");
  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));
  dataBase.university_deleteUniversity("SEXTON2");
 }

 @Test
  public void testAddUniversityWithValidSocialScale() {
  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN",
  "PRIVATE", 100, 90, 750, 750, 10000, 90,
  15000, 20, 50, 5, 3, 3, null));
  dataBase.university_deleteUniversity("SEXTON2");
  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN",
  "PRIVATE", 100, 90, 750, 750, 10000, 90,
  15000, 20, 50, 5, -1, -1, null));
  dataBase.university_deleteUniversity("SEXTON2");
  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN",
  "PRIVATE", 100, 90, 750, 750, 10000, 90,
  15000, 20, 50, 5, 1, 1, null));
  dataBase.university_deleteUniversity("SEXTON2");
  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN",
  "PRIVATE", 100, 90, 750, 750, 10000, 90,
  15000, 20, 50, 5, 2, 2, null));
  dataBase.university_deleteUniversity("SEXTON2");
  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN",
  "PRIVATE", 100, 90, 750, 750, 10000, 90,
  15000, 20, 50, 5, 4, 4, null));
  dataBase.university_deleteUniversity("SEXTON2");
  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN",
  "PRIVATE", 100, 90, 750, 750, 10000, 90,
  15000, 20, 50, 5, 5, 5, null));
  dataBase.university_deleteUniversity("SEXTON2");
  }

 @Test
 public void testAddUniversityWithValidLifeScale() {
  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 20, 50, 5, 5, 3, null));
  dataBase.university_deleteUniversity("SEXTON2");
  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 20, 50, 5, 5, -1, null));
  dataBase.university_deleteUniversity("SEXTON2");
  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 20, 50, 5, 5, 1, null));
  dataBase.university_deleteUniversity("SEXTON2");
  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 20, 50, 5, 5, 2, null));
  dataBase.university_deleteUniversity("SEXTON2");
  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 20, 50, 5, 5, 4, null));
  dataBase.university_deleteUniversity("SEXTON2");
  assertTrue(dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 750, 750, 10000, 90,
    15000, 20, 50, 5, 5, 5, null));
  dataBase.university_deleteUniversity("SEXTON2");
 }

 // invalid location
 @Test(expected = IllegalArgumentException.class)
 public void testAddUniversityInvalidLocation() {

  dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "EARTH", "PRIVATE", 100, 90, 750, 750, 10000, 90, 15000, 20,
    50, 5, 5, 5, null);
 }

 // invalid control
 @Test(expected = IllegalArgumentException.class)
 public void testAddUniversityInvalidControl() {
  dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "ONLINE", 100, 90, 750, 750, 10000, 90, 15000, 20,
    50, 5, 5, 5, null);
 }

 // invalid number of students
 @Test(expected = IllegalArgumentException.class)
 public void testAddUniversityInvalidNumberOfStudents() {
  dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", (-5000), 90, 750, 750, 10000, 90, 15000,
    20, 50, 5, 5, 5, null);
 }

 @Test(expected = IllegalArgumentException.class)
 public void testAddUniversityInvalidNumberOfStudents2() {
  dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", -2, 90, 750, 750, 10000, 90, 15000, 20,
    50, 5, 5, 5, null);
 }

 // invalid percent female
 @Test(expected = IllegalArgumentException.class)
 public void testAddUniversityInvalidPercentFemale() {
  dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, -30, 750, 750, 10000, 90, 15000, 20,
    50, 5, 5, 5, null);
 }

 @Test(expected = IllegalArgumentException.class)
 public void testAddUniversityInvalidPercentFemale2() {
  dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 150, 750, 750, 10000, 90, 15000, 20,
    50, 5, 5, 5, null);
 }

 @Test(expected = IllegalArgumentException.class)
 public void testAddUniversityInvalidPercentFemale3() {
  dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, -2, 750, 750, 10000, 90, 15000, 20,
    50, 5, 5, 5, null);
 }

 @Test(expected = IllegalArgumentException.class)
 public void testAddUniversityInvalidPercentFemale4() {
  dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 101, 750, 750, 10000, 90, 15000, 20,
    50, 5, 5, 5, null);
 }

 @Test(expected = IllegalArgumentException.class)
 public void testAddUniversityInvalidPercentFemale5() {
  dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, -.05, 750, 750, 10000, 90, 15000,
    20, 50, 5, 5, 5, null);
 }

 // invalid satVerbal
 @Test(expected = IllegalArgumentException.class)
 public void testAddUniversityInvalidSatVerbal() {
  dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 850, 750, 10000, 90, 15000, 20,
    50, 5, 5, 5, null);
 }

 // invalid satVerbal
 @Test(expected = IllegalArgumentException.class)
 public void testAddUniversityInvalidSatVerbal2() {
  dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, -50, 750, 10000, 90, 15000, 20,
    50, 5, 5, 5, null);
 }

 // invalid satVerbal
 @Test(expected = IllegalArgumentException.class)
 public void testAddUniversityInvalidSatVerbal3() {
  dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, -2, 750, 10000, 90, 15000, 20,
    50, 5, 5, 5, null);
 }

 // invalid satVerbal
 @Test(expected = IllegalArgumentException.class)
 public void testAddUniversityInvalidSatVerbal4() {
  dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 801, 750, 10000, 90, 15000, 20,
    50, 5, 5, 5, null);
 }

 // invalid satMath
 @Test(expected = IllegalArgumentException.class)
 public void testAddUniversityInvalidSatMath() {
  dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, -50, 10000, 90, 15000, 20,
    50, 5, 5, 5, null);
 }

 // invalid satMath
 @Test(expected = IllegalArgumentException.class)
 public void testAddUniversityInvalidSatMath2() {
  dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, -2, 10000, 90, 15000, 20,
    50, 5, 5, 5, null);
 }

 // invalid satMath
 @Test(expected = IllegalArgumentException.class)
 public void testAddUniversityInvalidSatMath3() {
  dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, -801, 10000, 90, 15000, 20,
    50, 5, 5, 5, null);
 }

 // invalid satMath
 @Test(expected = IllegalArgumentException.class)
 public void testAddUniversityInvalidSatMath4() {
  dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, -950, 10000, 90, 15000, 20,
    50, 5, 5, 5, null);
 }

 // invalid exp
 @Test(expected = IllegalArgumentException.class)
 public void testAddUniversityInvalidExp() {
  dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, -10000, 90, 15000, 20,
    50, 5, 5, 5, null);
 }

 // invalid exp
 @Test(expected = IllegalArgumentException.class)
 public void testAddUniversityInvalidExp2() {
  dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, -2, 90, 15000, 20, 50,
    5, 5, 5, null);
 }

 // invalid percent FA
 @Test(expected = IllegalArgumentException.class)
 public void testAddUniversityInvalidPercentFA() {
  dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, 1000, -30, 15000, 20,
    50, 5, 5, 5, null);
 }

 // invalid percent FA
 @Test(expected = IllegalArgumentException.class)
 public void testAddUniversityInvalidPercentFA2() {
  dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, 1000, 150, 15000, 20,
    50, 5, 5, 5, null);
 }

 // invalid percent FA
 @Test(expected = IllegalArgumentException.class)
 public void testAddUniversityInvalidPercentFA3() {
  dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, 1000, -2, 15000, 20,
    50, 5, 5, 5, null);
 }

 // invalid percent FA
 @Test(expected = IllegalArgumentException.class)
 public void testAddUniversityInvalidPercentFA4() {
  dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, 1000, 101, 15000, 20,
    50, 5, 5, 5, null);
 }

 // invalid percent FA
 @Test(expected = IllegalArgumentException.class)
 public void testAddUniversityInvalidPercentFA5() {
  dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, 1000, -.05, 15000, 20,
    50, 5, 5, 5, null);
 }

 // invalid percent numApplicants
 @Test(expected = IllegalArgumentException.class)
 public void testAddUniversityInvalidNumApplicants() {
  dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, 1000, 20, -1000, 20,
    50, 5, 5, 5, null);
 }

 // invalid percent numApplicants
 @Test(expected = IllegalArgumentException.class)
 public void testAddUniversityInvalidNumApplicants2() {
  dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, 1000, 20, -2, 20, 50,
    5, 5, 5, null);
 }

 // invalid PercentAdmitted
 @Test(expected = IllegalArgumentException.class)
 public void testAddUniversityInvalidPercentAdmitted() {
  dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, 1000, 20, 15000, -30,
    50, 5, 5, 5, null);
 }

 // invalid PercentAdmitted
 @Test(expected = IllegalArgumentException.class)
 public void testAddUniversityInvalidPercentAdmitted2() {
  dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, 1000, 20, 15000, 150,
    50, 5, 5, 5, null);
 }

 // invalid PercentAdmitted
 @Test(expected = IllegalArgumentException.class)
 public void testAddUniversityInvalidPercentAdmitted3() {
  dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, 1000, 20, 15000, -2,
    50, 5, 5, 5, null);
 }

 // invalid PercentAdmitted
 @Test(expected = IllegalArgumentException.class)
 public void testAddUniversityInvalidPercentAdmitted4() {
  dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, 1000, 20, 15000, 101,
    50, 5, 5, 5, null);
 }

 // invalid PercentAdmitted
 @Test(expected = IllegalArgumentException.class)
 public void testAddUniversityInvalidPercentAdmitted5() {
  dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, 1000, 20, 15000, -0.5,
    50, 5, 5, 5, null);
 }

 // invalid PercentEnrolled
 @Test(expected = IllegalArgumentException.class)
 public void testAddUniversityInvalidPercentEnrolled() {
  dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, 1000, 20, 15000, 50,
    -30, 5, 5, 5, null);
 }

 // invalid PercentEnrolled
 @Test(expected = IllegalArgumentException.class)
 public void testAddUniversityInvalidPercentEnrolled2() {
  dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, 1000, 20, 15000, 50,
    150, 5, 5, 5, null);
 }

 // invalid PercentEnrolled
 @Test(expected = IllegalArgumentException.class)
 public void testAddUniversityInvalidPercentEnrolled3() {
  dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, 1000, 20, 15000, 50,
    -2, 5, 5, 5, null);
 }

 // invalid PercentEnrolled
 @Test(expected = IllegalArgumentException.class)
 public void testAddUniversityInvalidPercentEnrolled4() {
  dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, 1000, 20, 15000, 50,
    101, 5, 5, 5, null);
 }

 // invalid PercentEnrolled
 @Test(expected = IllegalArgumentException.class)
 public void testAddUniversityInvalidPercentEnrolled5() {
  dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, 1000, 20, 15000, 50,
    -.5, 5, 5, 5, null);
 }

 // invalid AcademicScale
 @Test(expected = IllegalArgumentException.class)
 public void testAddUniversityInvalidAcademicScale() {
  dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, 1000, 20, 15000, 50,
    50, -6, 5, 5, null);
 }

 // invalid AcademicScale
 @Test(expected = IllegalArgumentException.class)
 public void testAddUniversityInvalidAcademicScale2() {
  dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, 1000, 20, 15000, 50,
    50, 8, 5, 5, null);
 }

 // invalid AcademicScale
 @Test(expected = IllegalArgumentException.class)
 public void testAddUniversityInvalidAcademicScale3() {
  dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, 1000, 20, 15000, 50,
    50, -2, 5, 5, null);
 }

 // invalid AcademicScale
 @Test(expected = IllegalArgumentException.class)
 public void testAddUniversityInvalidAcademicScale4() {
  dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, 1000, 20, 15000, 50,
    50, 0, 5, 5, null);
 }

 // invalid AcademicScale
 @Test(expected = IllegalArgumentException.class)
 public void testAddUniversityInvalidAcademicScale5() {
  dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, 1000, 20, 15000, 50,
    50, 6, 5, 5, null);
 }

 // invalid AcademicScale
 @Test(expected = IllegalArgumentException.class)
 public void testAddUniversityInvalidSocialScale() {
  dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, 1000, 20, 15000, 50,
    50, 5, -6, 5, null);
 }

 // invalid AcademicScale
 @Test(expected = IllegalArgumentException.class)
 public void testAddUniversityInvalidSocialScale2() {
  dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, 1000, 20, 15000, 50,
    50, 5, 8, 5, null);
 }

 // invalid AcademicScale
 @Test(expected = IllegalArgumentException.class)
 public void testAddUniversityInvalidSocialScale3() {
  dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, 1000, 20, 15000, 50,
    50, 5, -2, 5, null);
 }

 // invalid AcademicScale
 @Test(expected = IllegalArgumentException.class)
 public void testAddUniversityInvalidSocialScale4() {
  dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, 1000, 20, 15000, 50,
    50, 5, 0, 5, null);
 }

 // invalid SocialScale
 @Test(expected = IllegalArgumentException.class)
 public void testAddUniversityInvalidSocialScale5() {
  dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, 1000, 20, 15000, 50,
    50, 5, 6, 5, null);
 }

 // invalid LifeScale
 @Test(expected = IllegalArgumentException.class)
 public void testAddUniversityInvalidLifeScale() {
  dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, 1000, 20, 15000, 50,
    50, 5, 5, -6, null);
 }

 // invalid AcademicScale
 @Test(expected = IllegalArgumentException.class)
 public void testAddUniversityInvalidLifeScale2() {
  dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, 1000, 20, 15000, 50,
    50, 5, 5, 8, null);
 }

 // invalid AcademicScale
 @Test(expected = IllegalArgumentException.class)
 public void testAddUniversityInvalidLifeScale3() {
  dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, 1000, 20, 15000, 50,
    50, 5, 5, -2, null);
 }

 // invalid AcademicScale
 @Test(expected = IllegalArgumentException.class)
 public void testAddUniversityInvalidLifeScale4() {
  dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, 1000, 20, 15000, 50,
    50, 5, 5, 0, null);
 }

 // invalid LifeScale
 @Test(expected = IllegalArgumentException.class)
 public void testAddUniversityInvalidLifeScale5() {
  dbcontroller.addUniversity("SEXTON2", "MINNESOTA", "URBAN", "PRIVATE", 100, 90, 600, 600, 1000, 20, 15000, 50,
    50, 5, 5, 6, null);
 }

 public void testSaveSchool() {

  assertTrue("The school was successfully saved to the user's list of saved schools.",
    dbcontroller.saveSchool("zakluetmer", "_TESTSCHOOL"));
 }

 @Test(expected = IllegalArgumentException.class)
 public void testSaveSchoolAlreadySavedFail() {
  dbcontroller.saveSchool("zakluetmer", "_TESTSCHOOL");
  dbcontroller.saveSchool("zakluetmer", "_TESTSCHOOL");
 }

 @Test(expected = IllegalArgumentException.class)
 public void testSaveSchoolInvalidSchoolFail() {
  dbcontroller.saveSchool("zakluetmer", "NotASchool");
 }

 @Test(expected = IllegalArgumentException.class)
 public void testSaveSchoolInvalidUserFail() {
  dbcontroller.saveSchool("LakZuetmer", "_TESTSCHOOL");
 }

 @Test
 public void testGetUserSavedSchools() {
  dbcontroller.saveSchool("zakluetmer", "_TESTSCHOOL");
  assertTrue(dbcontroller.getUserSavedSchools("zakluetmer").contains("_TESTSCHOOL"));
 }

 @Test
 public void testGetAllUniversities() {
  ArrayList<String> testingSize = new ArrayList<String>();
  testingSize = dbcontroller.getAllUniversities();
  assertTrue(testingSize.size() > 50);
 }



 @Test
 public void testRemoveSchool() {
  dbcontroller.saveSchool("zakluetmer", "QUEENS");
  dbcontroller.removeSchool("zakluetmer", "QUEENS");
  ArrayList<String> temp = dbcontroller.getUserSavedSchools("zakluetmer");
  assertTrue(!temp.contains("QUEENS"));
 }

 @Test(expected = IllegalArgumentException.class)
 public void testRemoveSchoolFail() {
  dbcontroller.removeSchool("Not a user", "School");
 }

 @Test
 public void testIsSchoolSaved() {
  assertTrue(dbcontroller.isSchoolSaved("ADELPHI"));
  assertTrue(dbcontroller.isSchoolSaved("asdfasdfsfasfasd") == false);
 }

 @Test
 public void testGetAllUsers() {
  String[][] testing = dbcontroller.getAllUsers();
  assertTrue(testing.length >= 6);
 }

 @Test
 public void testAddAccountSuccess() {
  dbcontroller.addAccount("John", "Temporary", "Person", "asdf123", 'A');
  assertTrue(dbcontroller.isUsernameTaken("Person"));
 }

 @Test(expected = IllegalArgumentException.class)
 public void testAddAccountUsernameTaken() {
  dbcontroller.addAccount("John", "Temporary", "zakluetmer", "asdf123", 'A');
 }

 @Test(expected = IllegalArgumentException.class)
 public void testAddAccountNoUsername() {
  dbcontroller.addAccount("John", "Temporary", "", "asdf123", 'A');
 }

 @Test(expected = IllegalArgumentException.class)
 public void testAddAccountNoPassword() {
  dbcontroller.addAccount("John", "Temporary", "zakluetmer", "", 'A');
 }

 @Test
 public void testIsUsernameTaken() {
  assertTrue(dbcontroller.isUsernameTaken("zakluetmer") == true);
  assertTrue(dbcontroller.isUsernameTaken("AUserNameThatNoOneWillHave") == false);
 }

 @Test(expected = IllegalArgumentException.class)
 public void testEditAccountEmptyUsernameFail() {
  dbcontroller.editAccount("Zak", "Luetmer", "", "password", 'u', 'Y');
 }

 @Test(expected = IllegalArgumentException.class)
 public void testEditAccountEmptyPasswordFail() {
  dbcontroller.editAccount("Zak", "Luetmer", "zakluetmer", "", 'u', 'Y');
 }

 @Test(expected = IllegalArgumentException.class)
 public void testEditAccountEmptyTypeFail() {
  dbcontroller.editAccount("Zak", "Luetmer", "zakluetmer", "password", ' ', 'Y');
 }

 @Test(expected = IllegalArgumentException.class)
 public void testEditAccountEmptyStatusFail() {
  dbcontroller.editAccount("Zak", "Luetmer", "zakluetmer", "password", 'u', ' ');
 }

 @Test
 public void testEditAccountPassword() {
  Account account = dbcontroller.getAccount("zakluetmer");

  assertFalse("Account's password is not 'hello'", account.getPassword().equals("hello"));
  assertTrue("Accounts password was successfully changed",
    dbcontroller.editAccount("Zak", "Luetmer", "zakluetmer", "hello", 'u', 'Y'));
  account = dbcontroller.getAccount("zakluetmer");
  assertTrue("Account's password is 'hello'", account.getPassword().equals("hello"));
 }

 @Test
 public void testEditAccountFirstName() {
  Account account = dbcontroller.getAccount("zakluetmer");

  assertFalse("Account's first name is not 'Virgil'", account.getFirstName().equals("Virgil"));
  assertTrue("Accounts last name was successfully changed",
    dbcontroller.editAccount("Virgil", "Luetmer", "zakluetmer", "password", 'u', 'Y'));
  account = dbcontroller.getAccount("zakluetmer");
  assertTrue("Account's first name is 'Virgil'", account.getFirstName().equals("Virgil"));
 }

 @Test
 public void testEditAccountLastName() {
  Account account = dbcontroller.getAccount("zakluetmer");

  assertFalse("Account's last name is not 'Michael-House'", account.getLastName().equals("Michael-House"));
  assertTrue("Accounts last name was successfully changed",
    dbcontroller.editAccount("Zak", "Michael-House", "zakluetmer", "password", 'u', 'Y'));
  account = dbcontroller.getAccount("zakluetmer");
  assertTrue("Account's password is 'Michael-House'", account.getLastName().equals("Michael-House"));
 }

 @Test
 public void testEditAccountType() {
  Account account = dbcontroller.getAccount("zakluetmer");

  assertFalse("Account's type is not 'a'", account.getType() == ('a'));
  assertTrue("Accounts last name was successfully changed",
    dbcontroller.editAccount("Zak", "Luetmer", "zakluetmer", "password", 'a', 'Y'));
  account = dbcontroller.getAccount("zakluetmer");
  assertTrue("Account's type is 'a'", account.getType() == ('a'));
 }

 @Test
 public void testIsDeactivated() {
  assertTrue(dbcontroller.isDeactivated("zakluetmer") == false);
  assertTrue(dbcontroller.isDeactivated("luser"));
 }

 @Test
 public void testDeactivateUser() {
  dbcontroller.editAccount("Lynn", "User", "luser", "user", 'u', 'Y');
  dbcontroller.deactivateUser("luser");
  assertTrue(dbcontroller.isDeactivated("luser"));

 }

 @Test // get from search controller
 public void testFindRecommendations() {

  ArrayList<String> listRecs = dbcontroller.findRecommendations("_TESTSCHOOL");

  assertTrue("The first reccomended school for _TESTSCHOOL is '_TESTSCHOOL1'",
    listRecs.get(0).equals("_TESTSCHOOL1"));
  assertTrue("The second reccomended school for _TESTSCHOOL is '_TESTSCHOOL2'",
    listRecs.get(1).equals("_TESTSCHOOL2"));
  assertTrue("The third reccomended school for _TESTSCHOOL is '_TESTSCHOOL3'",
    listRecs.get(2).equals("_TESTSCHOOL3"));
  assertTrue("The fourth reccomended school for _TESTSCHOOL is '_TESTSCHOOL4'",
    listRecs.get(3).equals("_TESTSCHOOL4"));
  assertTrue("The fifth reccomended school for _TESTSCHOOL is '_TESTSCHOOL5'",
    listRecs.get(4).equals("_TESTSCHOOL5"));
 }


}

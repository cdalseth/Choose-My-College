package Project.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.*;


import Project.SearchController;

public class SearchControllerTest {

 private SearchController sController;
 private HashSet<String> searchResult;
 private ArrayList<String> oneEmphases;
 private ArrayList<String> manyEmphasis;
 
 @Before
 public void init()
 {
  sController = new SearchController();
  searchResult = new HashSet<String>();
  oneEmphases = new ArrayList<String>();
  manyEmphasis = new ArrayList<String>();
  oneEmphases.add("AGRICULTURE");
  manyEmphasis.add("ACCOUNTING");
  manyEmphasis.add("ADMINISTRATIVE-SCIENCE");
  manyEmphasis.add("AEROSPACE");
 }
 
 @Test (expected = IllegalArgumentException.class)
 public void testFindReccomendationsFail()
 {
  sController.findRecommendations("South Harmon Institute of Technology");
 }
 
// @Test
// public void testFindRecommendations()
// {
//ArrayList<String> listRecs = sController.findRecommendations("_TESTSCHOOL");
//   
//   assertTrue("The first reccomended school for _TESTSCHOOL is '_TESTSCHOOL1'",  listRecs.get(0).equals("_TESTSCHOOL1"));
//   assertTrue("The second reccomended school for _TESTSCHOOL is '_TESTSCHOOL2'", listRecs.get(1).equals("_TESTSCHOOL2"));
//   assertTrue("The third reccomended school for _TESTSCHOOL is '_TESTSCHOOL3'",  listRecs.get(2).equals("_TESTSCHOOL3"));
//   assertTrue("The fourth reccomended school for _TESTSCHOOL is '_TESTSCHOOL4'", listRecs.get(3).equals("_TESTSCHOOL4"));
//   assertTrue("The fifth reccomended school for _TESTSCHOOL is '_TESTSCHOOL5'",  listRecs.get(4).equals("_TESTSCHOOL5"));
// }
 
 @Test
 public void testSearchFullNameCaps() {
  searchResult = sController.search("COLORADO COLLEGE", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
  assertTrue(searchResult.contains("COLORADO COLLEGE"));
  assertTrue(searchResult.size()==1);
 }
 
 @Test
 public void testSearchFullName() {
	 searchResult = sController.search("colorado college", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.contains("COLORADO COLLEGE"));
  assertTrue(searchResult.size()==1);
 }
 
 @Test
 public void testSearchPartialNameCaps() {
	 searchResult = sController.search("ARIZONA ST", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.contains("ARIZONA STATE"));
  assertTrue(searchResult.size()==1);
 }
 
 @Test
 public void testSearchPartialName() {
	 searchResult = sController.search("arizona st", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.contains("ARIZONA STATE"));
  assertTrue(searchResult.size()==1);
 }
 
 @Test
 public void testSearchNoneExistantName() {
	 searchResult = sController.search("ZJ", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.isEmpty());
 }
 
 @Test
 public void testSearchNameEmpty() {
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==189);
 }
 
 @Test
 public void testStateFullCaps() {
  searchResult = sController.search("-1", "COLLEGEVILLE", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
  assertTrue(searchResult.contains("STATE DUMMY"));
  assertTrue(searchResult.size()==1);
 }
 
 @Test
 public void testStateFull() {
	 searchResult = sController.search("-1", "collegeville", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.contains("STATE DUMMY"));
  assertTrue(searchResult.size()==1);
 }
 
 @Test
 public void testStatePart() {
	 searchResult = sController.search("-1", "college", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.contains("STATE DUMMY"));
  assertTrue(searchResult.size()==1);
 }
 
 @Test
 public void testStatePartCaps() {
	 searchResult = sController.search("-1", "COLLEGE", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.contains("STATE DUMMY"));
  assertTrue(searchResult.size()==1);
 }
 
 @Test
 public void testStateEmpty() {
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==189);
 }
 
 @Test
 public void testLocationSuburbanCaps() {
	 searchResult = sController.search("-1", "-1", "SUBURBAN", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==44);
 }
 
 @Test
 public void testLocationSuburban() {
	 searchResult = sController.search("-1", "-1", "suburban", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==44);
 }
 
 @Test
 public void testLocationUrbanCaps() {
	 searchResult = sController.search("-1", "-1", "URBAN", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()>=82);
 }
 
 @Test
 public void testLocationUrban() {
	 searchResult = sController.search("-1", "-1", "urban", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()>=82);
 }
 
 @Test
 public void testLocationSmallCityCaps() {
	 searchResult = sController.search("-1", "-1", "SMALL-CITY", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==57);
 }
 
 @Test
 public void testLocationSmallCity() {
	 searchResult = sController.search("-1", "-1", "small-city", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);  
	 assertTrue(searchResult.size()==57);
 }
 
 @Test
 public void testLocationEmpty() {
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==189);
 }
 
 @Test
 public void testControlPrivateCaps() {
	 searchResult = sController.search("-1", "-1", "-1", "PRIVATE", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==116);
 }
 
 @Test
 public void testControlPrivate() {
	 searchResult = sController.search("-1", "-1", "-1", "private", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==116);
 }
 
 @Test
 public void testControlCityCaps() {
	 searchResult = sController.search("-1", "-1", "-1", "CITY", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==1);
 }
 
 @Test
 public void testControlCity() {
	 searchResult = sController.search("-1", "-1", "-1", "city", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==1);
 }
 
 @Test
 public void testControlStateCaps() {
	 searchResult = sController.search("-1", "-1", "-1", "STATE", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==72);
 }
 
 @Test
 public void testControlstate() {
	 searchResult = sController.search("-1", "-1", "-1", "state", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==72);
 }
 
 @Test
 public void testNumStudentsNegativeLowBigHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", -100, 999999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==189);
 }
 
 @Test
 public void testNumStudentsZeroLowBigHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 99999999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==189 || searchResult.size()==188);
 }
 
 @Test
 public void testNumStudentsLowBiggerThanHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 10000, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==0);
 }
 
 @Test
 public void testNumStudentsSmallLowSmallHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 9999, 10001, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==87);
 }
 
 @Test
 public void testNumStudentsMediumLowMediumHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 14999, 15001, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==34);
 }
 
 @Test
 public void testNumStudentsNoEntry(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==189);
 }
 
 @Test
 public void testPerFemaleNegativeLowBigHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, -20.0, 110.0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==189);
 }
 
 @Test
 public void testPerFemaleZeroLowBigHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 110.0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==189);
 }
 
 @Test
 public void testPerFemaleBigLowBigHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 89.0, 99.0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==5 || searchResult.size()==4);
	 assertTrue(searchResult.contains("COLORADO COLLEGE"));
 }
 
 @Test
 public void testPerFemaleLowBiggerThanHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 80.0, 20.0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==0);
 }
 
 @Test
 public void testPerFemaleSmallLowSmallHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 1.0, 11.0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==6);
	 assertTrue(searchResult.contains("NEWENGLAND COLLEGE"));
 }
 
 @Test
 public void testPerFemaleMediumLowMediumHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 56.0, 59.0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==3);
	 assertTrue(searchResult.contains("WAYNE STATE COLLEGE"));
 }
 
 @Test
 public void testPerFemaleNoEntry(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==189);
 }
 
 @Test
 public void testSatVerbalNegativeLowBigHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, -20, 850, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==189);
 }
 
 @Test
 public void testSatVerbalZeroLowBigHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 850, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==167);
 }
 
 @Test
 public void testSatVerbalBigLowBigHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 670, 725, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==2);
	 assertTrue(searchResult.contains("YALE"));
	 assertTrue(searchResult.contains("HARVARD"));
 }
 
 @Test
 public void testSatVerbalLowBiggerThanHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 500, 250, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==0);
 }
 
 @Test
 public void testSatVerbalSmallLowSmallHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 200, 350, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==3);
	 assertTrue(searchResult.contains("CORPUS CHRISTI STATE U"));
	 assertTrue(searchResult.contains("MORGAN STATE"));
	 assertTrue(searchResult.contains("UNIVERSITY OF TEXAS"));
 }
 
 @Test
 public void testSatVerbalMediumLowMediumHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 435, 449, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==2);
	 assertTrue(searchResult.contains("GLASSBORO STATE COLLEGE"));
	 assertTrue(searchResult.contains("UNIVERSITY OF HARTFORD"));
 }
 
 @Test
 public void testSatVerbalNoEntry(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==189);
 }
 
 @Test
 public void testSatMathNegativeLowBigHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, -20, 850, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==189);
 }
 
 @Test
 public void testSatMathZeroLowBigHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 850, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==167);
 }
 
 @Test
 public void testSatMathBigLowBigHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 690, 790, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==4);
	 assertTrue(searchResult.contains("RENSSELAER"));
	 assertTrue(searchResult.contains("MASSACHUSETTS INSTITUTE OF TECHNOLOGY"));
	 assertTrue(searchResult.contains("CAL TECH"));
 }
 
 @Test
 public void testSatMathLowBiggerThanHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 550, 200, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==0);
 }
 
 @Test
 public void testSatMathSmallLowSmallHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 200, 350, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==3);
	 assertTrue(searchResult.contains("CORPUS CHRISTI STATE U"));
	 assertTrue(searchResult.contains("MORGAN STATE"));
	 assertTrue(searchResult.contains("UNIVERSITY OF TEXAS"));
 }
 
 @Test
 public void testSatMathMediumLowMediumHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 450, 460, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==4);
	 assertTrue(searchResult.contains("QUEENS"));
	 assertTrue(searchResult.contains("SETON HALL"));
 }
 
 @Test
 public void testSatMathNoEntry(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==189);
 }
 
 @Test
 public void testExpensesNegativeLowBigHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, -100, 10000000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==189);
 }
 
 @Test
 public void testExpensesZeroLowBigHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 10000000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==189);
 }
 
 @Test
 public void testExpensesBigLowBigHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 55000, 65000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==2);
	 assertTrue(searchResult.contains("PRINCETON"));
	 assertTrue(searchResult.contains("STANFORD"));
 }
 
 @Test
 public void testExpensesLowBiggerThanHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 65000, 5000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==0);
 }
 
 @Test
 public void testExpensesSmallLowSmallHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 10000, 11000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==6);
	 assertTrue(searchResult.contains("MESA"));
	 assertTrue(searchResult.contains("GOTHENBURG UNIVERSITY"));
 }
 
 @Test
 public void testExpensesMediumLowMediumHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 25000, 26000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==6);
	 assertTrue(searchResult.contains("BRYN MAWR"));
	 assertTrue(searchResult.contains("UNIVERSITY OF THE SOUTH"));
 }
 
 @Test
 public void testExpensesNoEntry(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==189);
 }
 
 @Test
 public void testPerFANegativeLowBigHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -20, 110, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==189);
 }
 
 @Test
 public void testPerFAZeroLowBigHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 110, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==181);
 }
 
 @Test
 public void testPerFABigLowBigHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 91.0, 99.0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==3);
	 assertTrue(searchResult.contains("CSB"));
	 assertTrue(searchResult.contains("SJU"));
	 assertTrue(searchResult.contains("YANKTOWN COLLEGE"));
 }
 
 @Test
 public void testPerFALowBiggerThanHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 90, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==0);
 }
 
 @Test
 public void testPerFASmallLowSmallHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==2);
	 assertTrue(searchResult.contains("SUNY PURCHASE"));
	 assertTrue(searchResult.contains("WAYNE STATE COLLEGE"));
 }
 
 @Test
 public void testPerFAMediumLowMediumHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 42, 47, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==5);
	 assertTrue(searchResult.contains("GEORGE WASHINGTON"));
	 assertTrue(searchResult.contains("STANFORD"));
 }
 
 @Test
 public void testPerFANoEntry(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==189);
 }
 
 @Test
 public void testNumAppicantsNegativeLowBigHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -100, 2000000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==189);
 }
 
 @Test
 public void testNumAppicantsZeroLowBigHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 20000000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==186);
 }
 
 @Test
 public void testNumAppicantsBigLowBigHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 14500, 15500, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==11);
 }
 
 @Test
 public void testNumAppicantsLowBiggerThanHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2000, 200, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==0);
 }
 
 @Test
 public void testNumAppicantsSmallLowSmallHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1000, 3000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==2);
	 assertTrue(searchResult.contains("SJU"));
	 assertTrue(searchResult.contains("CSB"));
 }
 
 @Test
 public void testNumAppicantsMediumLowMediumHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8000, 9000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==15);
 }
 
 @Test
 public void testNumAppicantsNoEntry(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==189);
 }
 
 @Test
 public void testPerAdmittedNegativeLowBigHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -20, 110, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==189);
 }
 
 @Test
 public void testPerAdmittedZeroLowBigHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 110, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==186);
 }
 
 @Test
 public void testPerAdmittedBigLowBigHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 88, 92, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==13);
 }
 
 @Test
 public void testPerAdmittedLowBiggerThanHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 90, 20, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==0);
 }
 
 @Test
 public void testPerAdmittedSmallLowSmallHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 13, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==3);
	 assertTrue(searchResult.contains("STATE DUMMY"));
	 assertTrue(searchResult.contains("ECOLE POLYTECHNIQUE"));
 }
 
 @Test
 public void testPerAdmittedMediumLowMediumHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 46, 59, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==24);
 }
 
 @Test
 public void testPerAdmittedNoEntry(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==189);
 }
 
 @Test
 public void testPerEnrolledNegativeLowBigHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -20, 110, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==189);
 }
 
 @Test
 public void testPerEnrolledZeroLowBigHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 110, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==186);
 }
 
 @Test
 public void testPerEnrolledBigLowBigHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 91, 97, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==3);
	 assertTrue(searchResult.contains("NEWENGLAND COLLEGE"));
	 assertTrue(searchResult.contains("ECOLE POLYTECHNIQUE"));
 }
 
 @Test
 public void testPerEnrolledLowBiggerThanHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 90, 20, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==0);
 }
 
 @Test
 public void testPerEnrolledSmallLowSmallHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 17, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==3);
	 assertTrue(searchResult.contains("GEORGETOWN"));
	 assertTrue(searchResult.contains("BUCKNELL"));
 }
 
 @Test
 public void testPerEnrolledMediumLowMediumHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 46, 52, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==52);
 }
 
 @Test
 public void testPerEnrolledNoEntry(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==189);
 }
 
 @Test
 public void testAcademicScaleNegativeLowBigHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -5, 6, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==189);
 }
 
 @Test
 public void testAcademicScaleZeroLowBigHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==184);
 }
 
 @Test
 public void testAcademicScaleBigLowBigHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 5, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==83);
 }
 
 @Test
 public void testAcademicScaleLowBiggerThanHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 3, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==0);
 }
 
 @Test
 public void testAcademicScaleSmallLowSmallHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==39);
 }
 
 @Test
 public void testAcademicScaleMediumLowMediumHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 3, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==89);
 }
 
 @Test
 public void testAcademicScaleNoEntry(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==189);
 }
 
 @Test
 public void testSocialScaleNegativeLowBigHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -5, 6, 0, 0, null);
	 assertTrue(searchResult.size()==189);
 }
 
 @Test
 public void testSocialScaleZeroLowBigHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, null);
	 assertTrue(searchResult.size()==184);
 }
 
 @Test
 public void testSocialScaleBigLowBigHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 5, 0, 0, null);
	 assertTrue(searchResult.size()==61);
 }
 
 @Test
 public void testSocialScaleLowBiggerThanHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 1, 0, 0, null);
	 assertTrue(searchResult.size()==0);
 }
 
 @Test
 public void testSocialScaleMediumLowMediumHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 3, 0, 0, null);
	 assertTrue(searchResult.size()==110);
 }
 
 @Test
 public void testSocialScaleNoEntry(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==189);
 }
 
 @Test
 public void testLifeScaleNegativeLowBigHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -5, 6, null);
	 assertTrue(searchResult.size()==189);
 }
 
 @Test
 public void testLifeScaleZeroLowBigHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, null);
	 assertTrue(searchResult.size()==183);
 }
 
 @Test
 public void testLifeScaleBigLowBigHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 5, null);
	 assertTrue(searchResult.size()==74);
 }
 
 @Test
 public void testLifeScaleLowBiggerThanHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 1, null);
	 assertTrue(searchResult.size()==0);
 }
 
 @Test
 public void testLifeScaleMediumLowMediumHigh(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 3, null);
	 assertTrue(searchResult.size()==100);
 }
 
 @Test
 public void testLifeScaleNoEntry(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==189);
 }
 
 @Test
 public void testOneEmphasis(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, oneEmphases);
	 assertTrue(searchResult.size()==6);
 }
 
 @Test
 public void testMultipleEmphases(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, manyEmphasis);
	 assertTrue(searchResult.size()>=11);
 }
 
 @Test
 public void testNoEmphases(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==189);
 }
 
 @Test
 public void testCombination1(){
	 searchResult = sController.search("BOSTON", "-1", "SUBURBAN", "-1", 0, 16000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==1);
	 assertTrue(searchResult.contains("BOSTON COLLEGE"));
 }
 
 @Test
 public void testCombination2(){
	 searchResult = sController.search("-1", "-1", "-1", "PRIVATE", 0, 9999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==4);
	 assertTrue(searchResult.contains("CSB"));
	 assertTrue(searchResult.contains("SJU"));
 }
 
 @Test
 public void testCombination3(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 5, 15, 400, 500, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==3);
	 assertTrue(searchResult.contains("ILLINOIS TECH"));
	 assertTrue(searchResult.contains("NEW JERSEY TECH"));
 }
 
 @Test
 public void testCombination4(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 5, 15, 400, 500, 0, 0, 10000, 19500, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==2);
	 assertTrue(searchResult.contains("ILLINOIS TECH"));
	 assertTrue(searchResult.contains("NEWJERSEY TECH"));
 }
 
 @Test
 public void testCombination5(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 10000, 11300, 80, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==4);
	 assertTrue(searchResult.contains("SUNY BINGHAMTON"));
	 assertTrue(searchResult.contains("GOTHENBURG UNIVERSITY"));
 }
 
 @Test
 public void testCombination6(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 60, 100, 16500, 17000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==2);
	 assertTrue(searchResult.contains("SETON HALL"));
	 assertTrue(searchResult.contains("WESLEYAN"));
 }
 
 @Test
 public void testCombination7(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5000, 10000, 14, 15, 70, 80, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==2);
	 assertTrue(searchResult.contains("JUILLIARD"));
	 assertTrue(searchResult.contains("EASTMAN SCHOOL OF MUSIC"));
 }
 
 @Test
 public void testCombination8(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 15, 0, 0, 5, 5, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==2);
	 assertTrue(searchResult.contains("CAL TECH"));
	 assertTrue(searchResult.contains("ECOLE POLYTECHNIQUE"));
 }
 
 @Test
 public void testCombination9(){
	 searchResult = sController.search("-1", "-1", "-1", "-1", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 5, 5, 5, 5, null);
	 assertTrue(searchResult.size()==4);
	 assertTrue(searchResult.contains("UNIVERSITY OF MICHIGAN"));
	 assertTrue(searchResult.contains("ECOLE POLYTECHNIQUE"));
 }
 
 @Test
 public void testCombination10(){
	 searchResult = sController.search("UNIVERSITY", "TEXAS", "SUBURBAN", "PRIVATE", 7500, 10250, 25, 75, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
	 assertTrue(searchResult.size()==1);
	 assertTrue(searchResult.contains("ABILENE CHRISTIAN UNIVERSITY"));
 }
 
 
}

import java.util.*;
import java.io.*;

public class UniversityDBLibrary{
  public String[][] user_getUsers(){

    File folder = new File(".DB/Users/");
    File[] listOfFiles = folder.listFiles();
    String[][] users = new String[listOfFiles.length][6];

    int count = 0;
    try{
      for (File file : listOfFiles) {
        if (file.isFile()) {
          Scanner scnr = new Scanner(file);
          int line = 0;
          while(scnr.hasNextLine()) {
              users[count][line] = scnr.nextLine();
              line++;
          }
          scnr.close();
        }
        count++;
      }
    }
    catch(FileNotFoundException e){
      //Do Nothing
    }

    return users;
  }

  public int user_addUser(String first, String last, String username, String password, char type){
    File inputFile = new File(".DB/Users/" + username);
    try{
      BufferedWriter writer = new BufferedWriter(new FileWriter(".DB/Users/SavedSchools/" + username, true));
      writer.write(first);
      writer.newLine();   //Add new line
      writer.write(last);
      writer.newLine();   //Add new line
      writer.write(username);
      writer.newLine();   //Add new line
      writer.write(password);
      writer.newLine();   //Add new line
      writer.write(type);
      writer.newLine();   //Add new line
      writer.write('Y');
      writer.close();
    }
    catch(IOException e){
      //Do Nothing
    }

    return 0;
  }

  public int user_editUser(String username, String first, String last, String password, char type, char status){
    try{
      BufferedWriter writer = new BufferedWriter(new FileWriter(".DB/Users/SavedSchools/" + username, true));
      writer.write(first);
      writer.newLine();   //Add new line
      writer.write(last);
      writer.newLine();   //Add new line
      writer.write(username);
      writer.newLine();   //Add new line
      writer.write(password);
      writer.newLine();   //Add new line
      writer.write(type);
      writer.newLine();   //Add new line
      writer.write(status);
      writer.close();
    }
    catch(IOException e){
      //Do Nothing
    }

    return 0;
  }

  public int user_saveSchool(String user, String school){
    try{
      BufferedWriter writer = new BufferedWriter(new FileWriter(".DB/Users/SavedSchools/" + user, true));
      writer.newLine();   //Add new line
      writer.write(school);
      writer.close();
    }
    catch(IOException e){
      //Do Nothing
    }

    return 0;
  }

  public int user_removeSchool(String user, String school){

    File inputFile = new File(".DB/Users/SavedSchools/" + user);
    File tempFile = new File(".DB/Users/SavedSchools/" + user + "_temp");
    try{
      BufferedReader reader = new BufferedReader(new FileReader(inputFile));
      BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

      String lineToRemove = school;
      String currentLine;

      while((currentLine = reader.readLine()) != null) {
        // trim newline when comparing with lineToRemove
        String trimmedLine = currentLine.trim();
        if(trimmedLine.equals(lineToRemove)){
          writer.write(currentLine + System.getProperty("line.separator"));
        }
      }

      writer.close();
      reader.close();

      tempFile.renameTo(inputFile);
    }
    catch(FileNotFoundException e){
      //Do Nothing
    }
    catch(IOException e){
      //Do Nothing
    }
    return 0;
  }

  public String[][] user_getUsernamesWithSavedSchools(){

      File folder = new File(".DB/Users/SavedSchools/");
      File[] listOfFiles = folder.listFiles();
      String[][] usersSavedSchools = new String[listOfFiles.length][100];
    try{
      int count = 0;
      for (File file : listOfFiles) {
        if (file.isFile()) {
          Scanner scnr = new Scanner(file);
          int line = 0;
          while(scnr.hasNextLine()) {
              usersSavedSchools[count][line] = scnr.nextLine();
              line++;
          }

          scnr.close();
        }
        count++;
      }
    }
    catch(FileNotFoundException e){
      //Do Nothing
    }

    return usersSavedSchools;
  }

  public String[][] university_getUniversities(){
    File folder = new File(".DB/Schools/");
    File[] listOfFiles = folder.listFiles();
    String[][] schools = new String[listOfFiles.length][16];
    try{
      int count = 0;
      for (File file : listOfFiles) {
        if (file.isFile()) {
          Scanner scnr = new Scanner(file);
          int line = 0;
          while(scnr.hasNextLine()) {
            schools[count][line] = scnr.nextLine();
            System.out.println(schools[count][line] + "1");
            line++;
          }
          scnr.close();
          count++;
        }
      }
    }
    catch(FileNotFoundException e){
      //Do Nothing
    }

    return schools;
  }

  public String[][] university_getNamesWithEmphases(){
    File folder = new File(".DB/Schools/Emphasis/");
    File[] listOfFiles = folder.listFiles();
    String[][] schoolsEmphasis = new String[listOfFiles.length][100];
    try{
      int count = 0;
      for (File file : listOfFiles) {
        if (file.isFile()) {
          Scanner scnr = new Scanner(file);
          int line = 0;
          while(scnr.hasNextLine()) {
              schoolsEmphasis[count][line] = scnr.nextLine();
              System.out.println(schoolsEmphasis[count][line] + "2");
              line++;
          }
          scnr.close();
          count++;
        }

      }
    }
    catch(FileNotFoundException e){
      //Do Nothing
    }

    return schoolsEmphasis;
  }

  public int university_editUniversity(String name, String state, String location, String control, int numStudents,
    double perFemale, int satVerbal, int satMath, int expenses, double perFA, int numApplicants,
    double perAdmitted, double perEnrolled, int academicScale, int socialScale, int lifeScale){
    try{
      BufferedWriter writer = new BufferedWriter(new FileWriter(".DB/Schools/" + name, true));
      writer.write(name);
       writer.newLine();   //Add new line
       writer.write(state);
       writer.newLine();   //Add new line
       writer.write(location);
       writer.newLine();   //Add new line
       writer.write(control);
       writer.newLine();   //Add new line
       writer.write(numStudents);
       writer.newLine();   //Add new line
       writer.write(Double.toString(perFemale));
       writer.newLine();
       writer.write(satVerbal);
       writer.newLine();   //Add new line
       writer.write(satMath);
       writer.newLine();   //Add new line
       writer.write(expenses);
       writer.newLine();   //Add new line
       writer.write(Double.toString(perFA));
       writer.newLine();   //Add new line
       writer.write(numApplicants);
       writer.newLine();   //Add new line
       writer.write(Double.toString(perAdmitted));
       writer.newLine();
       writer.write(Double.toString(perEnrolled));
       writer.newLine();   //Add new line
       writer.write(academicScale);
       writer.newLine();   //Add new line
       writer.write(socialScale);
       writer.newLine();   //Add new line
       writer.write(lifeScale);

       writer.close();
     }
   catch (IOException e){
     return -1;
   }

   return 0;
  }

  public int university_addUniversity(String name, String state, String location, String control, int numStudents,
                                double perFemale, int satVerbal, int satMath, int expenses, double perFA, int numApplicants,
                                double perAdmitted, double perEnrolled, int academicScale, int socialScale, int lifeScale){
   File inputFile = new File(".DB/Schools/" + name);
   try{
     BufferedWriter writer = new BufferedWriter(new FileWriter(".DB/Schools/" + name, true));
     writer.write(name);
     writer.newLine();   //Add new line
     writer.write(state);
     writer.newLine();   //Add new line
     writer.write(location);
     writer.newLine();   //Add new line
     writer.write(control);
     writer.newLine();   //Add new line
     writer.write(numStudents);
     writer.newLine();   //Add new line
     writer.write(Double.toString(perFemale));
     writer.newLine();
     writer.write(satVerbal);
     writer.newLine();   //Add new line
     writer.write(satMath);
     writer.newLine();   //Add new line
     writer.write(expenses);
     writer.newLine();   //Add new line
     writer.write(Double.toString(perFA));
     writer.newLine();   //Add new line
     writer.write(numApplicants);
     writer.newLine();   //Add new line
     writer.write(Double.toString(perAdmitted));
     writer.newLine();
     writer.write(Double.toString(perEnrolled));
     writer.newLine();   //Add new line
     writer.write(academicScale);
     writer.newLine();   //Add new line
     writer.write(socialScale);
     writer.newLine();   //Add new line
     writer.write(lifeScale);

     writer.close();
   }
   catch (IOException e){
     return -1;
   }

   return 0;

  }

  public int university_addUniversityEmphasis(String name, String emphasis){
    try{
      BufferedWriter writer = new BufferedWriter(new FileWriter(".DB/Schools/Emphasis/" + name, true));
      writer.newLine();   //Add new line
      writer.write(emphasis);
      writer.close();
    }
    catch(IOException e){
      //Do Nothing
    }

    return 0;

  }

  public int university_removeUniversityEmphasis(String school, String emphasis){
    File inputFile = new File(".DB/Users/SavedSchools/" + school);
    File tempFile = new File(".DB/Users/SavedSchools/" + school + "_temp");
    try{
      BufferedReader reader = new BufferedReader(new FileReader(inputFile));
      BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

      String lineToRemove = emphasis;
      String currentLine;

      while((currentLine = reader.readLine()) != null) {
        // trim newline when comparing with lineToRemove
        String trimmedLine = currentLine.trim();
        if(trimmedLine.equals(lineToRemove)){
          writer.write(currentLine + System.getProperty("line.separator"));
        }
      }

      writer.close();
      reader.close();

      tempFile.renameTo(inputFile);
    }
    catch(FileNotFoundException e){
      //Do Nothing
    }
    catch(IOException e){
      //Do Nothing
    }

    return 0;
  }
}

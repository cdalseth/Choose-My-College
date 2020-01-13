import java.util.*;

public class ProjectDriver {
	private UserUI userUI;
	private AdminUI adminUI;
	private LoginUI loginUI;
	private DBController dbController;

	public ProjectDriver() {
		userUI = new UserUI();
		adminUI = new AdminUI();
		loginUI = new LoginUI();
		dbController = new DBController();
	}

	public void run() {
		ArrayList<University> allU = dbController.getUniversityObjects();
		//System.out.println(allU.get(0).getName());
		ArrayList<String> emphases = allU.get(0).getEmphases();
		//System.out.println(emphases.get(1));
		//System.out.println(emphases.get(2));
	}

	public static void main(String args[]) {
		ProjectDriver driver = new ProjectDriver();
		driver.run();
	}
}

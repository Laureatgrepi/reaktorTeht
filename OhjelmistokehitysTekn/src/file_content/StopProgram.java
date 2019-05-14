package file_content;

public class StopProgram {
	
	public static boolean stopProgram(String text) {
		if(text.equalsIgnoreCase("stop")) {
			System.out.println("The application has been stopped");
			return true;
		}else {
			return false;
		}
			
	}

}

package sample.javacode;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class BatchProcessingWithParameter {

  public static void main(final String[] args) throws Exception {
    
    //performProcessBuilder();
    
	performProcessBuilder2();
    //performAction();
    
  }
  
  
  
  private static void performProcessBuilder() throws IOException, InterruptedException {
	// TODO Auto-generated method stub
	// The batch file to execute
	    final File batchFile = new File("C:\\Users\\prabhun\\Desktop\\test2.bat");

	    // The output file. All activity is written to this file
	    final File outputFile = new File(String.format("C:\\Users\\prabhun\\Desktop\\output_%tY%<tm%<td_%<tH%<tM%<tS.txt",
	        System.currentTimeMillis()));

	    // The argument to the batch file. 
	    final String argument = "Prabhu Narayan Jaiswal";

	    // Create the process
	    final ProcessBuilder processBuilder = new ProcessBuilder(batchFile.getAbsolutePath(), argument);
	    // Redirect any output (including error) to a file. This avoids deadlocks
	    // when the buffers get full. 
	    processBuilder.redirectErrorStream(true);
	    //processBuilder.redirectOutput(outputFile);

	    // Add a new environment variable
	    //processBuilder.environment().put("message", "Example of process builder");

	    // Set the working directory. The batch file will run as if you are in this
	    // directory.
	    //processBuilder.directory(new File("C:\\Users\\prabhun\\Desktop"));

	    // Start the process and wait for it to finish. 
	    final Process process = processBuilder.start();
	    final int exitStatus = process.waitFor();
	    System.out.println("Processed finished with status: " + exitStatus);
}

  private static void performProcessBuilder2() throws IOException, InterruptedException {
		
		    final File batchFile = new File("C:\\Users\\prabhun\\Desktop\\test2.bat");	
		    final File outputFile = new File(String.format("C:\\Users\\prabhun\\Desktop\\output_%tY%<tm%<td_%<tH%<tM%<tS.txt",
			        System.currentTimeMillis()));
		    final String argument = "Prabhu Narayan Jaiswal rsdfsdfsdf";
		    final ProcessBuilder processBuilder = new ProcessBuilder(batchFile.getAbsolutePath(), argument);
		    processBuilder.redirectErrorStream(true);
		    processBuilder.redirectOutput(outputFile);
		    final Process process = processBuilder.start();
		    final int exitStatus = process.waitFor();
		    System.out.println("Processed finished with status: " + exitStatus);
	}



public static void performAction() {

		String command = "C:\\Users\\prabhun\\Desktop\\test2.bat";

		try {
			//log.info("Executing  task  " + new Date() + "  id = " + this.id + "\n path =" + this.migrationBatchFile);

			Runtime runtime = Runtime.getRuntime();
			//Runtime.getRuntime().exec(); 

			//Process p1 = runtime.exec(new String[]{"cmd.exe", "/c", "start C:\\Users\\prabhun\\Desktop\\test2.bat", "Prabhu"});
			Process p1 = runtime.exec(new String[]{"cmd", "/c", "start C:\\Users\\prabhun\\Desktop\\test2.bat", "Prabhu"});
			p1.waitFor();
			InputStream in = p1.getInputStream();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();

			int c = -1;
			while ((c = in.read()) != -1) {
				baos.write(c);
			}

			String response = new String(baos.toByteArray());
			//log.info("Response From Exe ***: " + response);

		} catch (IOException ioException) {
			ioException.printStackTrace();
			//log.error("Failed to execute command" + command + " Error: " + ioException.getMessage());
		} catch (Exception e) {
			//log.error("Failed to execute command" + command + " Error: " + e.getMessage());
			e.printStackTrace();
		} finally {
			// to stop time thread
			//log.info("Command  executed" + command);
		}
	}
}
package sample.javacode;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
//from  w w  w .  ja v  a  2  s. c  om
public class Main {
  public static void main(String[] argv) throws IOException, InterruptedException  {
    /*InetAddress address = InetAddress.getByName("migdemotest");
    System.out.println("Name: " + address.getHostName());
    System.out.println("Addr: " + address.getHostAddress());
    System.out.println("NetworkInterface " + NetworkInterface.getByIndex(0));
    System.out.println("Reach: " + address.isReachable(NetworkInterface.getByIndex(0),0,3000));
    
    
    
    
    
    
    
    
    Process p1 = java.lang.Runtime.getRuntime().exec("ping -n 5 migdemotest");
    int returnVal = p1.waitFor();
    boolean reachable = (returnVal==0);
    System.out.println("reachable: " + reachable);
    */
    
    String hostName="migdemotest";
    
    
    final ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c", "ping -n 5",hostName);
	//processBuilder.redirectErrorStream(true);
	final Process process = processBuilder.start();
	final int exitStatus = process.waitFor();
	 boolean reachable = (exitStatus==0);
	 System.out.println("exitStatus: " + reachable);
  }
}
import java.io.*;

/**
 *
 * @author pau
 */
public class TerminalSize {
    
    public void getCols() {
        String[] cmd = {"/bin/sh", "-c", "stty size < /dev/tty"}; //tput cols
        try {
            Process pr = Runtime.getRuntime().exec(cmd);
            pr.waitFor();
            BufferedReader br = new BufferedReader(new InputStreamReader(pr.getInputStream()));
            String line;
            while((line=br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        TerminalSize t = new TerminalSize();
        t.getCols();
    }
}

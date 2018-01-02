import java.io.*;

public class Nuke2 {
    public static void main (String[] args) throws Exception{
        BufferedReader keyboard =  new BufferedReader(new InputStreamReader(System.in));
        String input = keyboard.readLine();
        String output = input.substring(0, 1) + input.substring(2);
        System.out.println(output);
        keyboard.close();
    }
}
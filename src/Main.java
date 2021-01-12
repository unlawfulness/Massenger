import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {

        Main client = new Main();
        client.go();


    }
    public  void go(){

        try {
            Socket s = new Socket("127.0.0.1", 4242);
            InputStreamReader streamReader = new InputStreamReader(s.getInputStream());
            BufferedReader reader = new BufferedReader(streamReader);

            String advice = reader.readLine();
            System.out.printf("Сегодня ты должен:" + advice);

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}

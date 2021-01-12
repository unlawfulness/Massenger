import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    String[] adviceList = {
            "Кушай много",
            "Работать больше",
            "Побрейся урод",
            "Погладь кота"
    };

    public static void main(String[] args) {
        Server server = new Server();
        server.go();
    }

    public void go(){
        try {
            ServerSocket serverSocket = new ServerSocket(4242);

            while (true) {

                Socket sock = serverSocket.accept();

                PrintWriter writer = new PrintWriter(sock.getOutputStream());
                String advice = getAdvice();
                writer.println(advice);
                writer.close();
                System.out.println(advice);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getAdvice() {
        int random = (int) (Math.random() * adviceList.length);
        return adviceList[random];
    }

}

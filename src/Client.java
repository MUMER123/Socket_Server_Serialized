import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class Client {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Socket socket = new Socket("localhost",1234);

        ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

        String message = "Hello ,Ali! How are you ?";
        Request messageToServer = new Request(message);

        output.writeObject(messageToServer);
        List<Response> char_count = (List<Response>) input.readObject();
        System.out.println(char_count);
        socket.close();
    }
}

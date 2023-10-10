import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ServerSocket serversocket = new ServerSocket(1234);
        Socket socket = serversocket.accept();

        ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());

        Request messageFromClient = (Request) input.readObject();
        List<Response> char_count = getCharCount(messageFromClient.getData());
        output.writeObject(char_count);
        socket.close();
    }

    private static List<Response> getCharCount(String message) {
        Map<Character,Integer> chars = new HashMap<>();
        for(char ch : message.toLowerCase().toCharArray()){
            if(ch>='a' && ch<='z'){
                chars.put(ch,chars.getOrDefault(ch,0)+1);
            }
        }
        int max = 0;
        for(char ch : chars.keySet()){
            if(chars.get(ch)>max){
                max = chars.get(ch);
            }
        }
        List<Response> list = new ArrayList<>();
        for(char ch : chars.keySet()){
            if(chars.get(ch)==max){
                list.add(new Response(ch,chars.get(ch)));
            }
        }
        return list;
    }
}
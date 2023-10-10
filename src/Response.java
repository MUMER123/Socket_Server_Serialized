import java.io.Serializable;
public class Response implements Serializable{
    private char alphabet;
    private int count;

    public Response(char alphabet, int count) {
        this.alphabet = alphabet;
        this.count = count;
    }

    public char getAlphabet() {
        return alphabet;
    }



    public int getCount() {
        return count;
    }
    @Override
    public String toString() {
        return alphabet + " : " + count;
    }
}

import java.io.Serializable;

public class Request implements Serializable {
    private String data;

    public Request(String data) {
        this.data = data;
    }

    public String getData() {
        return this.data;
    }
}
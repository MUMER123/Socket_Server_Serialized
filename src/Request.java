import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SerializableString implements Serializable {
    private String data;

    public SerializableString(String data) {
        this.data = data;
    }

    public String getData() {
        return this.data;
    }
}
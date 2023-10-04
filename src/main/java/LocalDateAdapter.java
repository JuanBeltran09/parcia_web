import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.time.LocalDate;

public class LocalDateAdapter extends TypeAdapter<LocalDate> {

    @Override
    public void write(JsonWriter out, LocalDate localDate) throws IOException {
        if (localDate == null) {
            out.nullValue();
        } else {
            out.value(localDate.toString());
        }
    }

    @Override
    public LocalDate read(JsonReader in) throws IOException {
        String dateString = in.nextString();
        if (dateString == null || dateString.isEmpty()) {
            return null;
        }
        return LocalDate.parse(dateString);
}
}
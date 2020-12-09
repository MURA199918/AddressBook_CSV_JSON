import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVWriter {
    private static final String OBJECT_LIST_SAMPLE = "C:\\Users\\mural\\IdeaProjects\\AddressBook_CSV_JSON\\src\\main\\resources\\Sample.csv";

    public static void main(String[] args) throws IOException,
            CsvDataTypeMismatchException,
            CsvRequiredFieldEmptyException {
        try(
                Writer writer = Files.newBufferedWriter(Paths.get(OBJECT_LIST_SAMPLE));
        )
        {
            StatefulBeanToCsv<contact> beanToCsv = new StatefulBeanToCsvBuilder(writer)
                    .withQuotechar(com.opencsv.CSVWriter.NO_QUOTE_CHARACTER)
                    .build();

            List<contact> myusers = new ArrayList<>();
            myusers = bookdetails.readData();
            myusers.add(new contact("Rajeev","Kumar","gdbhbs","mumbai","kerela",446,3643778,"rajeev@example.com"));
            myusers.add(new contact("Sachin","yadav","dhhddfh","mumbai","kerela",356,364747,"sachin@example.com"));

            beanToCsv.write(myusers);
        }
    }

}

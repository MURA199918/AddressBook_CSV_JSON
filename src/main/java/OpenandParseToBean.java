import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class OpenandParseToBean {
    private static final String SAMPLE_CSV_FILE_PATH = "C:\\Users\\mural\\IdeaProjects\\DemoCSV\\src\\main\\resources\\Users.csv";

    public static void main(String[] args) throws IOException {
        try(
                Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
        ){
            CsvToBean<contact> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(contact.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            Iterator<contact> csvUserIterator = csvToBean.iterator();

            while (csvUserIterator.hasNext()){
                contact contact = csvUserIterator.next();
                System.out.println("FirstName : "+contact.getFirstname());
                System.out.println("LastName : "+contact.getLastname());
                System.out.println("Address : "+contact.getAddress());
                System.out.println("City : "+contact.getCity());
                System.out.println("State : "+contact.getState());
                System.out.println("Zip : "+contact.getZip());
                System.out.println("Phone : "+contact.getPhoneno());
                System.out.println("Email : "+contact.getEmail());
                System.out.println("=====================");
            }
        }
    }

}

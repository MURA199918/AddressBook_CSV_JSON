import com.opencsv.CSVReader;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class bookdetails {
    public static final String SAMPLE_CSV_FILE_PATH = "C:\\Users\\mural\\IdeaProjects\\AddressBook_CSV_JSON\\src\\main\\resources\\Users.csv";
    ArrayList<contact> contactDetails = new ArrayList<>();
    public void addcontact(contact obj) {
        contactDetails.add(obj);
    }
    public ArrayList<contact> viewcontact(){
        return contactDetails;
    }

    public static String ADDRESS_FILE = "Address-file.txt";
    public static void writeData(List<contact> contactList){
        StringBuffer empBuffer = new StringBuffer();
        contactList.forEach(employee ->{
            String employeeDataString = employee.toString().concat("\n");
            empBuffer.append(employeeDataString);
        });

        try {
            Files.write(Paths.get(ADDRESS_FILE), empBuffer.toString().getBytes());
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    public static void printData() {
        try{
            Files.lines(new File(ADDRESS_FILE).toPath()).forEach(System.out::println);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static List<contact> readData(){
        List<contact> contactList = new ArrayList<>();
        try{
            Files.lines(new File(ADDRESS_FILE).toPath())
                    .map(line->line.trim())
                    .forEach(line->System.out.println(line));
        }catch (IOException e){
            e.printStackTrace();
        }
        return contactList;
    }

    public static void readCSV() throws IOException {

        Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
        CSVReader csvReader = new CSVReader(reader);

        String[] nextRecord;
        while ((nextRecord = csvReader.readNext()) != null) {
            System.out.println("FirstName: " + nextRecord[0]);
            System.out.println("LastName: " + nextRecord[1]);
            System.out.println("Address: " + nextRecord[2]);
            System.out.println("City: " + nextRecord[3]);
            System.out.println("State: " + nextRecord[4]);
            System.out.println("Zip: " + nextRecord[5]);
            System.out.println("Phone: " + nextRecord[6]);
            System.out.println("Email: " + nextRecord[7]);
            System.out.println("====================");
        }
        List<String[]> records = csvReader.readAll();
        for (String[] record : records) {
            System.out.println("FirstName: " + record[0]);
            System.out.println("LastName: " + record[1]);
            System.out.println("Address: " + record[2]);
            System.out.println("City: " + record[3]);
            System.out.println("State: " + record[4]);
            System.out.println("Zip: " + record[5]);
            System.out.println("Phone: " + record[6]);
            System.out.println("Email: " + record[7]);
            System.out.println("----------------------");
        }
    }

}

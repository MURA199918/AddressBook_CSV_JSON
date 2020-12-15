import com.google.gson.Gson;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class bookdetails {
    public static final String SAMPLE_CSV_FILE_PATH = "C:\\Users\\mural\\IdeaProjects\\AddressBook_CSV_JSON\\src\\main\\resources\\Sample.csv";
    private static final String OBJECT_LIST_SAMPLE = "C:\\Users\\mural\\IdeaProjects\\AddressBook_CSV_JSON\\src\\main\\resources\\Sample.csv";
    private static final String SAMPLE_JSON_FILE_PATH = "C:\\Users\\mural\\IdeaProjects\\AddressBook_CSV_JSON\\src\\main\\resources\\Json.csv";

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
     public static void writeCSV() throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {

        try(
        Writer writer = Files.newBufferedWriter(Paths.get(SAMPLE_CSV_FILE_PATH));
        ) {

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

    public static void readCSV() throws IOException {

        try(
        Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
        CSVReader csvReader = new CSVReader(reader);
        ) {

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

    public static void readandwriteJSON() throws IOException,CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        try{
            Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
            CsvToBeanBuilder<contact> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(contact.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<contact> csvToBean = csvToBeanBuilder.build();
            List<contact> csvUsers = csvToBean.parse();
            Gson gson = new Gson();
            String json = gson.toJson(csvUsers);
            FileWriter writer = new FileWriter(SAMPLE_JSON_FILE_PATH);
            writer.write(json);
            writer.close();
            BufferedReader br = new BufferedReader(new FileReader(SAMPLE_JSON_FILE_PATH));
            contact[] usrobj = gson.fromJson(br, contact[].class);
            List<contact> csvUserList = Arrays.asList(usrobj);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}

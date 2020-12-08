import com.opencsv.bean.CsvBindByName;

public class contact {
    @CsvBindByName
    String firstname;

    @CsvBindByName
    String lastname;

    @CsvBindByName
    String address;

    @CsvBindByName
    String city;

    @CsvBindByName
    String state;

    @CsvBindByName
    int zip;

    @CsvBindByName(column = "phoneno")
    int phoneno;

    @CsvBindByName(column = "email",required = true)
    String email;

    public contact(String firstname, String lastname, String address, String city, String state, int zip, int phone, String email) {
        this.firstname=firstname;
        this.lastname=lastname;
        this.address=address;
        this.city=city;
        this.state=state;
        this.zip=zip;
        this.phoneno=phone;
        this.email=email;
    }

    public contact() {

    }

    public String getFirstname(){
        return firstname;
    }
    public void setFirstname(){
        this.firstname=firstname;
    }
    public String getLastname(){
        return lastname;
    }
    public void setLastname(){
        this.lastname=lastname;
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(){
        this.address=address;
    }
    public String getCity(){
        return city;
    }
    public void setCity(){
        this.city=city;
    }
    public String getState(){
        return state;
    }
    public void setState(){
        this.state=state;
    }
    public int getZip(){
        return zip;
    }
    public void setZip(){
        this.zip=zip;
    }
    public int getPhoneno(){
        return phoneno;
    }
    public void setPhoneno(){
        this.phoneno=phoneno;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(){
        this.email=email;
    }

    @Override
    public String toString() {
        return "contact{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip=" + zip +
                ", phoneno=" + phoneno +
                ", email='" + email + '\'' +
                '}';
    }

}

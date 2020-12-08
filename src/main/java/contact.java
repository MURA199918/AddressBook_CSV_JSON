public class contact {
    String firstname;
    String lastname;
    String address;
    String city;
    String state;
    int zip;
    int phoneno;
    String email;
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
    public String toString(){
        return String.format("FirstName: "+firstname+" "+"LastName: "+lastname+" "+"Address: "+address+" "+"City: "+city+" "+"State: "+state+" "+"Zip: "+zip+" "+"PhoneNumber: "+phoneno+" "+"EmailID: "+email);
    }

}

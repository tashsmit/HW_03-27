package nyc.c4q.tashsmit;

/**
 * Created by tasha.smith on 3/26/2015.
 */
public class Person {
    private String name;
    private String phoneNumber;
    private String city;
    public Person(){
    }
    public Person(String name){
        this.name = name;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getName() {
        return name;
    }
    public static Boolean checkSameCity(Person person1, Person person2) {
        return person1.getCity().equalsIgnoreCase(person2.getCity());
    }
    public void setName(String name) {
        this.name = name;
    }

    public static Person registerChild(String name, Person person1) {
        Person child = new Person(name);
        child.setCity(person1.getCity());
        child.setPhoneNumber(person1.getPhoneNumber());
        return child;
    }

    public static void main(String args[]) {

        Person anna = new Person();
        anna.setCity("Orlando");

        Person tom = new Person();
        tom.setCity("Orlando");
        tom.setPhoneNumber("555-555-5555");

        System.out.println(checkSameCity(anna,tom));

        Person child = registerChild("Pete", tom);
        System.out.println(child.getCity());
        System.out.println(child.getPhoneNumber());
    }
}


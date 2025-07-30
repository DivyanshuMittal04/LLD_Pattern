package User;

public class UserDO {
    int id;
    String firstName;
    String mail;

    public UserDO(int id, String firstName, String mail) {
        this.id = id;
        this.firstName = firstName;
        this.mail = mail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}

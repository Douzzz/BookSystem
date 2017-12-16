package booksystem.model;

public class User {
    private String username;
    private String password;
    private Integer id;

    public User(String username, String password, Integer id){
        this.username = username;
        this.password = password;
        this.id = id;
    }
    public User(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

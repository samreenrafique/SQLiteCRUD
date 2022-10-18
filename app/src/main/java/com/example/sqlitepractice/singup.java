package com.example.sqlitepractice;

public class singup {
    public singup(String id, String username, String useremail) {
        Id = id;
        this.username = username;
        this.useremail = useremail;
    }

    public String Id, username, useremail;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }
}

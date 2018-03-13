package com.example.dipto.ieeemadc;

/**
 * Created by rukshar on 5/22/2016.
 */
public class Chat {

    private int _id;
    private String _user;
    private String _message;

    public Chat(String _user, String _message) {
        this._message = _message;
        this._user = _user;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_message(String _message) {
        this._message = _message;
    }

    public void set_user(String _user) {
        this._user = _user;
    }

    public int get_id() {
        return _id;
    }

    public String get_message() {
        return _message;
    }

    public String get_user() {
        return _user;
    }
}

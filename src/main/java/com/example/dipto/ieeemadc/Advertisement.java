package com.example.dipto.ieeemadc;

/**
 * Created by rukshar on 5/14/2016.
 */
public class Advertisement {

    private int _id;
    private String _topic;
    private String _description;

    public Advertisement(String topic, String description) {
        this._description = description;
        this._topic = topic;
    }

    public String get_description() {
        return _description;
    }

    public int get_id() {
        return _id;
    }

    public String get_topic() {
        return _topic;
    }

    public void set_description(String _description) {
        this._description = _description;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_topic(String _topic) {
        this._topic = _topic;
    }
}

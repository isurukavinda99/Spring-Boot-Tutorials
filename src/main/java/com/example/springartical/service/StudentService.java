package com.example.springartical.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StudentService {

    public void saveStudent(){
        System.out.println("Student saved");
    }

    public void updateStudent(){
        System.out.println("Student updated");
    }

    public Map<String, String> getStudent(){
        Map<String,String> studentMap = new HashMap<>();
        studentMap.put("id", "1");
        studentMap.put("name", "Kusal");
        return studentMap;
    }

}

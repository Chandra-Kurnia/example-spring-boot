package com.latihan.postgres.demo.service;

import com.latihan.postgres.demo.entity.Students;
import com.latihan.postgres.demo.helper.MessageModel;
import com.latihan.postgres.demo.pojo.StudentPojo;
import com.latihan.postgres.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    MessageModel msg = new MessageModel();

    public ResponseEntity getStudents() {
        try {
            /*List<Students> Data = studentRepository.findAll();
            List<Object> arr = new ArrayList<>(Data.size());
            for (int i = 0; i < Data.size(); i++){
                Object dataByIndex = Data.get(i);
                arr.add(dataByIndex);
            }
            msg.setStatus(true);
            msg.setMessage("Berhasil Get Data");
            msg.setData(arr);
            return ResponseEntity.ok().body(msg);*/
            List<StudentPojo> Data = studentRepository.nameEmail();
            if(Data.size() == 0){
                msg.setStatus(true);
                msg.setMessage("Data tidak ditemukan");
                msg.setData(Data);
            }else{
                msg.setStatus(true);
                msg.setMessage("Berhasil Get Data");
                msg.setData(Data);
            }
            return ResponseEntity.ok().body(msg);
        } catch (Exception e) {
            e.printStackTrace();
            msg.setStatus(false);
            msg.setMessage("Internal server error");
            return ResponseEntity.ok().body(msg);
        }

    }

    public ResponseEntity findStudent(Long id) {
        try {
            Object Data = studentRepository.findById(id);
            msg.setStatus(true);
            if(Objects.nonNull(Data)){
                msg.setMessage("Berhasil");
            }else{
                msg.setMessage("Data Tidak Ditemukan");
            }
            msg.setData(Data);

            return ResponseEntity.ok().body(msg);
        } catch (Exception e) {
            e.printStackTrace();
            msg.setStatus(true);
            msg.setMessage("Gagal mendapatkan data");

            return ResponseEntity.ok().body(msg);
        }
    }

    public ResponseEntity<MessageModel> addStudent(Students dataStudent) {
        try {
            Students students = studentRepository.save(dataStudent);
            msg.setStatus(true);
            msg.setMessage("Berhasil Insert Data");
            msg.setData(students);
            return ResponseEntity.ok().body(msg);
        }catch (Exception e){
            e.printStackTrace();
            msg.setStatus(false);
            msg.setMessage("Gagal Insert Data");
            return ResponseEntity.ok().body(msg);
        }
    }

    public ResponseEntity<MessageModel> updateStudent(Students dataStudent, Long studentId) {
        try {
            Students students = studentRepository.findById(studentId).get();

//            Set data
                students.setName(dataStudent.getName());
                students.setEmail(dataStudent.getEmail());
                students.setPlace_of_birth(dataStudent.getPlace_of_birth());
                students.setDate_of_birth(dataStudent.getDate_of_birth());
                students.setMonth_of_birth(dataStudent.getMonth_of_birth());
                students.setYear_of_birth(dataStudent.getYear_of_birth());
                students.setAddress(dataStudent.getAddress());

//            Save data to database
                Students newStudent = studentRepository.save(students);

//            Create Respon
                msg.setStatus(true);
                msg.setMessage("Berhasil Update Data");
                msg.setData(newStudent);
            return ResponseEntity.ok().body(msg);
        } catch (Exception e) {
            e.printStackTrace();
            msg.setStatus(false);
            msg.setMessage("Gagal Update Data, data tidak ditemukan");
            msg.setData(null);
            return ResponseEntity.ok().body(msg);
        }
    }

    public ResponseEntity<MessageModel> deleteStudent(Long studentId) {
        try {
            Students students = studentRepository.findById(studentId).get();
//            if(Objects.nonNull(students)){
                studentRepository.delete(students);
                msg.setStatus(true);
                msg.setMessage("Berhasil hapus data");
//            }else{
//                msg.setStatus(false);
//                msg.setMessage("Data Tidak Ditemukan");
//            }
            return ResponseEntity.ok().body(msg);
        }catch (Exception e){
            e.printStackTrace();
            msg.setStatus(false);
            msg.setMessage("Gagal hapus data, data tidak ditemukan");
            msg.setData(null);
            return ResponseEntity.ok().body(msg);
        }
    }
}

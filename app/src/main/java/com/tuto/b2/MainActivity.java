package com.tuto.b2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editTextSubjectName, editTextCredits, editTextYear, editTextInstructor, editTextScore;
    private TextView textViewResult, textViewSubjects;
    private ArrayList<Subject> subjects = new ArrayList<>();
    private float totalScore = 0;
    private int totalCredits = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextSubjectName = findViewById(R.id.editTextSubjectName);
        editTextCredits = findViewById(R.id.editTextCredits);
        editTextYear = findViewById(R.id.editTextYear);
        editTextInstructor = findViewById(R.id.editTextInstructor);
        editTextScore = findViewById(R.id.editTextScore);
        textViewResult = findViewById(R.id.textViewResult);
        textViewSubjects = findViewById(R.id.textViewSubjects);
        Button buttonAdd = findViewById(R.id.buttonAdd);
        Button buttonCalculate = findViewById(R.id.buttonCalculate);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSubject();
            }
        });

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateAverage();
            }
        });
    }

    private void addSubject() {
        String name = editTextSubjectName.getText().toString();
        int credits = Integer.parseInt(editTextCredits.getText().toString());
        String year = editTextYear.getText().toString();
        String instructor = editTextInstructor.getText().toString();
        float score = Float.parseFloat(editTextScore.getText().toString());

        Subject subject = new Subject(name, credits, year, instructor, score);
        subjects.add(subject);

        totalScore += score * credits;
        totalCredits += credits;

        displaySubjects();
        clearInputs();
    }

    private void calculateAverage() {
        if (totalCredits == 0) {
            Toast.makeText(this, "Chưa có môn học nào được thêm.", Toast.LENGTH_SHORT).show();
            return;
        }

        float average = totalScore / totalCredits;
        String classification;

        if (average >= 5 && average < 7) {
            classification = "Trung bình";
        } else if (average >= 7 && average < 9) {
            classification = "Khá";
        } else {
            classification = "Giỏi";
        }

        textViewResult.setText("Điểm trung bình: " + average + "\nXếp loại: " + classification);
    }

    private void displaySubjects() {
        StringBuilder subjectList = new StringBuilder("Danh sách môn học:\n");
        for (Subject subject : subjects) {
            subjectList.append("Tên môn: ").append(subject.getName())
                    .append(", Tín chỉ: ").append(subject.getCredits())
                    .append(", Năm học: ").append(subject.getYear())
                    .append(", Giảng viên: ").append(subject.getInstructor())
                    .append(", Điểm: ").append(subject.getScore()).append("\n");
        }
        textViewSubjects.setText(subjectList.toString());
    }

    private void clearInputs() {
        editTextSubjectName.setText("");
        editTextCredits.setText("");
        editTextYear.setText("");
        editTextInstructor.setText("");
        editTextScore.setText("");
    }
}

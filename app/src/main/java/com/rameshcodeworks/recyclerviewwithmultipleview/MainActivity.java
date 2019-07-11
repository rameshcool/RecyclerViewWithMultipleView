package com.rameshcodeworks.recyclerviewwithmultipleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private EmployeeAdapter adapter;
    private ArrayList<Employee> employeeArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        employeeArrayList = new ArrayList<>();
        adapter = new EmployeeAdapter(this, employeeArrayList);
        recyclerView.setAdapter(adapter);

        createListData();
    }

    private void createListData() {

        Employee employee = new Employee("123456","abc@gmail.com");
        employeeArrayList.add(employee);

        employee = new Employee("345678", "bac@gmail.com");
        employeeArrayList.add(employee);

        employee = new Employee("67854", "rar@gmail.com");
        employeeArrayList.add(employee);

        employee = new Employee("4563728", "gag@gmail.com");
        employeeArrayList.add(employee);

        employee = new Employee("452678", "tag@gmail.com");
        employeeArrayList.add(employee);

        employee = new Employee("567432", "hat@gmail.com");
        employeeArrayList.add(employee);

        employee = new Employee("567843", "das@gmail.com");
        employeeArrayList.add(employee);
    }
}

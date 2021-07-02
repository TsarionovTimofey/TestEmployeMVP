package com.example.testemploye.screens.employee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.testemploye.R;
import com.example.testemploye.adapters.EmployeeAdapter;
import com.example.testemploye.api.ApiFactory;
import com.example.testemploye.api.ApiService;
import com.example.testemploye.pojo.Employee;
import com.example.testemploye.pojo.EmployeeResponse;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class EmployeeListActivity extends AppCompatActivity implements EmployeesListView {

    private RecyclerView recyclerViewEmployees;
    private EmployeeAdapter adapter;
    private EmployeeListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewEmployees = findViewById(R.id.recyclerView);
        recyclerViewEmployees.setLayoutManager(new LinearLayoutManager(this));
        adapter = new EmployeeAdapter();
        adapter.setEmployees(new ArrayList<Employee>());
        recyclerViewEmployees.setAdapter(adapter);

        presenter = new EmployeeListPresenter(this);
        presenter.loadData();


    }

    @Override
    public void showData(List<Employee> employees) {
        adapter.setEmployees(employees);
    }

    @Override
    public void showError(Throwable throwable) {
        Toast.makeText(this, throwable.getMessage(), Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        presenter.disposeDisposable();
        super.onDestroy();
    }
}
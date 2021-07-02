package com.example.testemploye.api;

import com.example.testemploye.pojo.EmployeeResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    @GET("testTask.json")
   Observable <EmployeeResponse> getEmployees();
}

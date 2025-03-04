"use client";
import React, { useEffect, useState } from "react";
import axios from "axios";

interface Employee {
  id: number;
  employee_name: string;
  employee_salary: number;
  employee_age: number;
  profile_image: string;
}

export default function Home() {
  const [employees, setEmployees] = useState<Employee[]>([]);
  const[employee, setEmployee] = useState<Employee | null>(null);
  let hasContent: boolean = true;

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    await axios
      .get("http://dummy.restapiexample.com/api/v1/employee/1")
      .then((response) => {
        console.log(response.data);
        setEmployee(response.data);
      })
      .catch((error) => {
        console.error("Error getting employee:", error);
      });

     if (employee === null) {
       await axios
         .get("http://dummy.restapiexample.com/api/v1/employees")
         .then((response) => {
           console.log(response.data);
           setEmployees(response.data);
         })
         .catch((error) => {
           console.error("Error getting employees:", error);
         });
     }else{
      hasContent = false;
     } 

  };

  return (
    <main className="container">
      <div className="card">
        <div className="card-body">
          <form
            onSubmit={handleSubmit}
            className="row justify-content-md-center"
          >
            <div className="col-auto">
              <label htmlFor="employeeId" className="col-form-label">
                Employee Id:
              </label>
            </div>
            <div className="col-auto">
              <input type="text" id="employeeId" className="form-control" />
            </div>
            <div className="col-auto">
              <button type="submit" className="btn btn-primary">
                Search
              </button>
            </div>
          </form>
        </div>
      </div>
      <div className="card mt-4" hidden={hasContent}>
        <div className="card-body">
          <table className="table table-striped">
            <thead>
              <tr>
                <th scope="col">#</th>
                <th scope="col">Name</th>
                <th scope="col">Salary</th>
                <th scope="col">Age</th>
                <th scope="col">Profile</th>
              </tr>
            </thead>
            <tbody>
              {employees.map((employee) => (
                <tr key={employee.id}>
                  <th scope="row">{employee.id}</th>
                  <td>{employee.employee_name}</td>
                  <td>{employee.employee_salary}</td>
                  <td>{employee.employee_age}</td>
                  <td>{employee.profile_image}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    </main>
  );
}

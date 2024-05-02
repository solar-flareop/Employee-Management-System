import { useEffect } from "react";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { listEmployees } from "../services/EmployeeService";

export const ListEmployee = () => {
  const [employeesList, setEmployeesList] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    listEmployees()
      .then((response) => {
        setEmployeesList(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }, []);

  const addNewEmployee = () => {
    navigate("/add-employee");
  };

  return (
    <div className="container">
      <h2 className="text-center">List of Employees</h2>
      <button className="btn btn-primary mb-2" onClick={addNewEmployee}>
        Add Employee
      </button>
      <table className="table table-bordered table-striped">
        <thead>
          <tr>
            <th>Employee Id</th>
            <th>Employee firstName</th>
            <th>Employee lastName</th>
            <th>Employee email</th>
          </tr>
        </thead>
        <tbody>
          {employeesList?.map((employee) => (
            <tr key={employee.id}>
              <td> {employee.id}</td>
              <td> {employee.firstname}</td>
              <td> {employee.lastname}</td>
              <td> {employee.email}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

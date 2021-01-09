import { Component, OnInit } from '@angular/core';
import {Employee} from '../employee';
import{EmployeeService} from '../employee.service';
import{Router} from '@angular/router';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

  employees: Employee[];

  constructor(private employeeService: EmployeeService, private router:Router) { }

  ngOnInit(): void {

    this.getEmployees();

    /*
    
    this.employees=[{
      "id":1,
      "firstName":"Aaditya",
      "lastName" : "Raj",
      "email":"aadiraj@gmail.com",
      "mobile":9999999999
    },
    {
      "id":2,
      "firstName":"Sachin",
      "lastName" : "Tendulkar",
      "email":"sachin@yahoo.com",
      "mobile":9999900000
    }];

    */

  }

  private getEmployees(){
    this.employeeService.getEmployeesList().subscribe(data => {
        this.employees = data;
    });
  }

  employeeDetails(id: number){
    this.router.navigate(['employee-details', id]);
  }

  updateEmployee(id: number){
    this.router.navigate(['update-employee', id]);
  }

  deleteEmployee(id: number){
    this.employeeService.deleteEmployee(id).subscribe(data => {
      console.log(data);
      this.getEmployees();
  })
  }
}

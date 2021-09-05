import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Employee } from 'src/app/models/employee';
import { EmployeeService } from 'src/app/services/employee.service';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  employees!: Employee[];
  message!: string;
  msg!: string;

  constructor(private employeeService: EmployeeService) { }

  ngOnInit(): void {
    this.allEmployees();
  }


  public allEmployees(): void{
    this.employeeService.getAllEmployees().subscribe(
      (response: Employee[]) =>{
        this.employees = response;
      },(error: HttpErrorResponse)=>{
        alert(error.message);
      }
    )
  }

  public onAddEmployee(employee: NgForm): void{
    this.employeeService.addEmployee(employee.value).subscribe(
      (data: Employee)=>{
        this.message = "true";
        this.allEmployees();
      },
      (error: HttpErrorResponse)=>{
        this.message = "false";
        alert(error.message);
      }
    )
  }

  public onDeleteEmployee(employeeId: number): void{
    this.employeeService.deleteEmployee(employeeId).subscribe(
      (response: any)=>{
        this.msg = "Has been deleted successfully";
        this.allEmployees();
        setTimeout(() => {
          this.msg = "";
        }, 2000);
      },(error: HttpErrorResponse)=>{
        this.msg = "Try again, Please!";
      }
    )
  }


  searchEmployee(key: string): void{
    const result: Employee[] = [];
    for(const employee of this.employees){
      if(employee.fullName.toLowerCase().indexOf(key.toLowerCase()) !== -1
        || employee.email.toLowerCase().indexOf(key.toLowerCase()) !== -1
        || employee.phone.toLowerCase().indexOf(key.toLowerCase()) !== -1
        || employee.jobTitle.toLowerCase().indexOf(key.toLowerCase()) !== -1
      ){
        result.push(employee);
      }
    }
    this.employees = result;
    if(result.length === 0 || !key){
      this.allEmployees();
    }
  }




}

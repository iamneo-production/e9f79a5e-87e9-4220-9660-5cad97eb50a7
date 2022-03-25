import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit {

  public page1:boolean=true;
  public page2:boolean=false;
  constructor() { }

  setPage1(){
    this.page1=true;
    this.page2=false;
  }
  setPage2(){
    this.page1=false;
    this.page2=true;
  }

  ngOnInit(): void {
  }
 

}

import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  public submitted:boolean;
  roomSearch:FormGroup;
  rooms: Room[];

   ngOnInit(){
    this.roomSearch = new FormGroup({
      checkin: new FormControl(''),
      checkout: new FormControl('')
    });
    this.rooms = ROOMS;
   }

   onSubmit({value,valid}:{value:RoomSearch,valid:boolean})
   {
    console.log(value);
   }

   reserveRoom(value:string){
     console.log(" Room Id : "+value);
   }
}

export interface RoomSearch{
  checkin:string;
  checkout:string;
}

export interface Room{
  id:string;
  roomNumber:string;
  price:string;
  links:string;
}

const ROOMS: Room[] = [
  {
    "id":"1234",
    "roomNumber":"401",
    "price":"20",
    "links":""
  },
  {
    "id":"5678",
    "roomNumber":"402",
    "price":"25",
    "links":""
  },
  {
    "id":"9876",
    "roomNumber":"403",
    "price":"28",
    "links":""
  },
  {
    "id":"5432",
    "roomNumber":"404",
    "price":"30",
    "links":""
  }
];
import { Component, OnInit } from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import { DialogComponent } from './dialog/dialog.component';
import { OrderdialogComponent } from './orderdialog/orderdialog.component';

import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'front end';

  constructor(private dialog: MatDialog, private http: HttpClient){
  }
  ngOnInit(): void {
 
  }

  showInfo(){}
  undo(){}
  // start of dialog for placing order
  openNewDialog(){
    const dialogRef = this.dialog.open(OrderdialogComponent,{
      width:'30%'
    });

    dialogRef.afterClosed().subscribe(result=>{
      console.log('Dialog result: ${result}');
    });
  }
  // start of dialog for Add Product
  openDialog(){
    const dialogRef = this.dialog.open(DialogComponent,{
      width:'30%'
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log(`Dialog result: ${result}`);
    });
  }
}

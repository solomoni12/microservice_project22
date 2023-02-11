import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit,ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
// import {Component, ViewChild} from '@angular/core';
import {MatTable} from '@angular/material/table';
import { Router } from '@angular/router';
import { DialogUpdateOrderComponent } from '../dialog-update-order/dialog-update-order.component';
import { DialogComponent } from '../dialog/dialog.component';
import { OrderdialogComponent } from '../orderdialog/orderdialog.component';
import { ProductService } from '../product.service';
import { RemoveOrderDialogComponent } from '../remove-order-dialog/remove-order-dialog.component';
// import { MatTableModule } from '@angular/material/table';

export interface OrderElement {
  accountId: string;
  orderLineItemsDtoList: OrderItemList[]
}
export interface OrderItemList {
  price: number;
  skuCode: string;
  quantity: number;
}

// const orderList: PeriodicElement[];


@Component({
  selector: 'app-order-list',
  templateUrl: './order-list.component.html',
  styleUrls: ['./order-list.component.css']
})
export class OrderListComponent implements OnInit {
// start to display table
displayedColumns: string[] = ['skuCode', 'quantity', 'price','actions'];
dataSource: OrderElement[] = [];

  @ViewChild(MatTable) table!: MatTable<OrderElement>;

  // function to add data into table
  addData() {
  }
  //function to get row
  getRecord(row: any) {
    console.log(row);
  }

  // function to delete data from table
  removeData() {
    const dialogRef = this.dialog.open(RemoveOrderDialogComponent,{
      width:'30%'
    });
  
    dialogRef.afterClosed().subscribe(result=>{
      console.log('Dialog result: ${result}');
    });
  }
// end to display table


constructor(private dialog: MatDialog, private productService: ProductService, private router: Router) {
 
}

  ngOnInit(): void {
    this.getOrder();
  }
  public getOrder(): void{

    this.productService.getOrder().subscribe(
      (response: OrderElement[]) => {
        this.dataSource = response;
        console.log(response)
      },
      (error:HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
  /*
public getOrder(): void{

  this.productService.getOrder().subscribe(
    (response: PeriodicElement[]) => {
      this.dataSource = response;
      console.log(response)
    },
    (error:HttpErrorResponse) => {
      alert(error.message);
    }
  );
}
  */
// dialog box to place order
  openNewDialog(){
    const dialogRef = this.dialog.open(OrderdialogComponent,{
      width:'30%'
    });

    dialogRef.afterClosed().subscribe(result=>{
      console.log('Dialog result: ${result}');
    });
  }
  // update order
  updateOrder(){
    const dialogRef = this.dialog.open(DialogUpdateOrderComponent,{
      width:'30%'
    });

    dialogRef.afterClosed().subscribe(result=>{
      console.log('Dialog result: ${result}');
    });
  }

}

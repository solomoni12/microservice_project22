import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit,ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from '../product';
import { ProductService } from '../product.service';
import { MatDialog } from '@angular/material/dialog';
import {MatTable} from '@angular/material/table';
import { DialogComponent } from '../dialog/dialog.component';
import { RemoveProductDialogComponent } from '../remove-product-dialog/remove-product-dialog.component';
import { DialogUpdateProductComponent } from '../dialog-update-product/dialog-update-product.component';


export interface ProductCreate {
  name: string;
  skuCode: string;
  description: string;
  price: number;
}

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  
  // start to display table
displayedColumns: string[] = ['name', 'skuCode', 'price','description','actions'];
dataSource: ProductCreate[] = [];

@ViewChild(MatTable) table!: MatTable<ProductCreate>;

// function to add data into table
addData() {
}
// function to get row of product
getRecord(row: any) {
  console.log(row);
}
// function to delete data from table
removeData(skuCode: string) {
  this.productService.deleteProduct(skuCode)
  .subscribe({
    next:()=>{
      alert("product deleted successful")
    },
    error:()=>{
      alert("product not deleted")
    }
  })
  // const dialogRef = this.dialog.open(RemoveProductDialogComponent,{
  //   width:'30%'
  // });

  // dialogRef.afterClosed().subscribe(result=>{
  //   console.log('Dialog result: ${result}');
  // });
}

// end to display table
updateProduct(row: any){
  const dialogRef = this.dialog.open(DialogUpdateProductComponent,{
    width:'30%',
    data: row
  });

  dialogRef.afterClosed().subscribe(result=>{
    console.log('Dialog result: ${result}');
  });
}
constructor(private dialog: MatDialog, private productService: ProductService, private router: Router) {
 
 }

ngOnInit(): void {
  this.getProduct();
}
public getProduct(): void{

  this.productService.getProduct().subscribe(
    (response: ProductCreate[]) => {
      this.dataSource = response;
      console.log(response)
    },
    (error:HttpErrorResponse) => {
      alert(error.message);
    }
  );
}


// dialog box to place order
openNewDialog(){
  const dialogRef = this.dialog.open(DialogComponent,{
    width:'30%'
  });

  dialogRef.afterClosed().subscribe(result=>{
    console.log('Dialog result: ${result}');
  });
}

}

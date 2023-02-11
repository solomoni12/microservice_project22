import { Component, Inject, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { MatDialog, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-dialog-update-product',
  templateUrl: './dialog-update-product.component.html',
  styleUrls: ['./dialog-update-product.component.css']
})
export class DialogUpdateProductComponent implements OnInit {
  productForm!:FormGroup;
  actionBtn: string = "save";
  constructor(private formBuilder: FormBuilder, 
    @Inject(MAT_DIALOG_DATA) public editData: any,
    private dialog: MatDialog, private productService: ProductService) { }

  ngOnInit(): void {
    this.productForm = this.formBuilder.group({
      name: ['',Validators.required],
      skuCode: ['',Validators.required],
      description: ['',Validators.required],
      price: ['',Validators.required]
    });
    if(this.editData){
      this.actionBtn = "update";
      this.productForm.controls['name'].setValue(this.editData.name);
      this.productForm.controls['skuCode'].setValue(this.editData.skuCode);
      this.productForm.controls['description'].setValue(this.editData.description);
      this.productForm.controls['price'].setValue(this.editData.price);
    }
  }
  saveUpdateProduct(){
    console.log(this.productForm.value);
    this.productService.updateProduct(this.productForm.value)
    .subscribe({
      next:(res)=>{
        alert("Product updated successful");
        this.productForm.reset();
        this.dialog.closeAll;
      },
      error:()=>{
        alert("Product not updated Successful");
      }
    })
  }

}

import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-dialog',
  templateUrl: './dialog.component.html',
  styleUrls: ['./dialog.component.css']
})
export class DialogComponent implements OnInit {
productForm!:FormGroup;
  constructor(private formBuilder: FormBuilder, private productService: ProductService) { }

  ngOnInit(): void {
    this.productForm = this.formBuilder.group({
      productName: ['',Validators.required],
      productSkuCode: ['',Validators.required],
      productDescription: ['',Validators.required],
      productPrice: ['',Validators.required]
    })
  }

  addProduct(){
    if(this.productForm.valid){
      const submitData = {
        name: this.productForm.value.productName,
        skuCode: this.productForm.value.productSkuCode,
        description: this.productForm.value.productDescription,
        price: this.productForm.value.productPrice
      }

      this.productService.createProduct(submitData)
      .subscribe({
        next:(res)=>{
          alert("product is added successful")
        },
        error:()=>{
          alert("error while adding product")
        }
      })
    }
    console.log(this.productForm.value);
  }


}

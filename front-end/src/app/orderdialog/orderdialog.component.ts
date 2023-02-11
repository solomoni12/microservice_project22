import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { OrderElement } from '../order-list/order-list.component';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-orderdialog',
  templateUrl: './orderdialog.component.html',
  styleUrls: ['./orderdialog.component.css']
})
export class OrderdialogComponent implements OnInit {
  productForm!:FormGroup;
  constructor(private formBuilder: FormBuilder, private productService: ProductService) { }

  ngOnInit(): void {
    this.productForm = this.formBuilder.group({
      productSkuCode: ['',Validators.required],
      productQuantity: ['',Validators.required],
      productPrice: ['',Validators.required]
    })
  }

  placeOrder(){
    if(this.productForm.valid){
      const submitData = {
        accountId: "1255",
        orderLineItemsDtoList: [
          {
            skuCode: this.productForm.value.productSkuCode,
            quantity: this.productForm.value.productQuantity,
            price: this.productForm.value.productPrice
          }
        ]
      }
      console.log(submitData);

      this.productService.placeOrders(submitData)
      .subscribe({
        next:(res)=>{
          alert("Order is not placed successful");
        },
        error:()=>{
          alert("order is placed successful");
        }
      })
    }
  }
}

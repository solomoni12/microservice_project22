import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-dialog-update-order',
  templateUrl: './dialog-update-order.component.html',
  styleUrls: ['./dialog-update-order.component.css']
})
export class DialogUpdateOrderComponent implements OnInit {
  productForm!:FormGroup;
  constructor(private formBuilder: FormBuilder) { }

  saveUpdateOrder(){
    console.log(this.productForm.value);
  }

  ngOnInit(): void {
    this.productForm = this.formBuilder.group({
      productName: ['',Validators.required],
      productSkuCode: ['',Validators.required],
      productDescription: ['',Validators.required],
      productPrice: ['',Validators.required]
    })
  }

}

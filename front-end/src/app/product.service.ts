import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Product } from './product';
import { ProductCreate } from './product-list/product-list.component';
import { OrderElement } from './order-list/order-list.component';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private apiServerUrl = environment.apiBaseUrl;
  private apiServe = environment.apiBase;

  constructor(private http: HttpClient){}

  // function to get all product
  public getProduct(): Observable<ProductCreate[]>{
    return this.http.get<ProductCreate[]>(`${this.apiServerUrl}/api/product/all`);
  }

  // function to post all producrt
  public createProduct(product: ProductCreate) {
    return this.http.post(`${this.apiServerUrl}/api/product/add`,product);
  }

  // function to update product
  updateProduct(data: any){
    return this.http.put(`${this.apiServerUrl}/api/product/update`, data);
  }

  // function to delete items of product
  deleteProduct(skuCode: string){
    return this.http.delete(`${this.apiServerUrl}/api/product/delete?skuCode=${skuCode}`);
  }

  // function to place order
  public placeOrders(order: OrderElement){
    return this.http.post(`${this.apiServe}/api/order/all`,order);
  }
}

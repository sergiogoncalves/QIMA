import { Component, OnInit } from '@angular/core';
import {Product} from "../../model/product.model";
import {ProductService} from "../../service/product.service";
import {ProductFormComponent} from "../product-form/product-form.component";
import { MatDialog } from '@angular/material/dialog';



@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  products: Product[] = [];
  selectedProduct: Product = new Product();
  order: string = 'name';
  reverse: boolean = false;
  productFilter: any = { name: '' };

  constructor(private productService: ProductService, private dialog: MatDialog) { }

  ngOnInit(): void {
    this.getProducts();
  }

  getProducts(): void {
    this.productService.getProducts().subscribe(products => this.products = products);
  }

  setOrder(value: string) {
    if (this.order === value) {
      this.reverse = !this.reverse;
    }

    this.order = value;
  }

  editProduct(product: Product) {
  // Implement your logic for editing a product here.
  // For example, you might want to assign the product to the selectedProduct property:
  this.selectedProduct = product;
}

deleteProduct(product: Product) {
  this.productService.deleteProduct(product.id).subscribe(() => {
    this.products = this.products.filter(p => p.id !== product.id);
  });
}

openAddProductPopup() {
  this.selectedProduct = new Product(); // Create a new product

  const dialogRef = this.dialog.open(ProductFormComponent, {
    width: '500px',
    data: {product: this.selectedProduct}
  });
}

}
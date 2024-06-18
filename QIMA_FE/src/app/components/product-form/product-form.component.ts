import {Component, Inject, Input, OnInit} from '@angular/core';
import {Product} from "../../model/product.model";
import {Category} from "../../model/category.model";
import {CategoryService} from "../../service/category.service";
import {SnackbarService} from "../../service/snackbar.service";
import {Router} from "@angular/router";
import {ProductService} from "../../service/product.service";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";

@Component({
  selector: 'app-product-form',
  templateUrl: './product-form.component.html',
  styleUrls: ['./product-form.component.scss']
})
export class ProductFormComponent implements OnInit {
  @Input() product: Product = new Product();

  categories: Category[] = [];


  constructor(@Inject(MAT_DIALOG_DATA) public data: any,
              private categoryService: CategoryService,
              private productService: ProductService,
              private router: Router,
              private snackbarService: SnackbarService,
              public dialogRef: MatDialogRef<ProductFormComponent>
              ) {
      if (data && data.product) {
          this.product = data.product;
      }
  }

  ngOnInit(): void {
    this.getCategories();
  }

  getCategories(): void {
    this.categoryService.getCategories().subscribe(categories => this.categories = categories);
  }

  onSubmit() {

      console.log('Product:', this.product)
    this.productService.createProduct(this.product).subscribe(
        data => {
          this.snackbarService.showSnackbar('Success', 'Close', 3000);
          this.router.navigate(['/products']);
          this.dialogRef.close();
        },
        error => {
          console.log('Error:', error);
        }
    );
  }

compareCategories(c1: Category, c2: Category): boolean {
    return c1 && c2 ? c1.id === c2.id : c1 === c2;
}
}

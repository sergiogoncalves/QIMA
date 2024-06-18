import {Component, Input} from '@angular/core';
import {Product} from "../../model/product.model";
import {Category} from "../../model/category.model";
import {CategoryService} from "../../service/category.service";

@Component({
  selector: 'app-product-form',
  templateUrl: './product-form.component.html',
  styleUrls: ['./product-form.component.scss']
})
export class ProductFormComponent {
  @Input() product: Product;

  categories: Category[] = [];


  constructor(private categoryService: CategoryService) { }

  ngOnInit(): void {
    this.getCategories();
  }

  getCategories(): void {
    this.categoryService.getCategories().subscribe(categories => this.categories = categories);
  }
}

import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {Product} from "../../model/product";
import {ProductService} from "../../service/product.service";

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {

  product: Product;
  productForm: FormGroup;
  id: number;

  constructor(private activatedRoute: ActivatedRoute, private productService: ProductService,
              private rout: Router) {
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(paramMap => {
      this.id = parseInt(paramMap.get('id'), 10);
      this.product = this.productService.findById(this.id);
      this.productForm = new FormGroup({
        id: new FormControl(this.product.id),
        name: new FormControl(this.product.name),
        price: new FormControl(this.product.price),
        description: new FormControl(this.product.description),
      });
    });
  }

  submit() {
    this.productService.editProduct(this.id, this.productForm.value);
    this.rout.navigateByUrl('product/list');
  }
}

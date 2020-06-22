import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-bookdetails',
  templateUrl: './bookdetails.component.html',
  styleUrls: ['./bookdetails.component.css']
})
export class BookdetailsComponent implements OnInit {

  @Input()
  libid: Number;
  constructor() { }

  ngOnInit(): void {
    console.log(`inside the details components`);
  }

}

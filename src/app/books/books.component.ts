import { Component, OnInit,Input,AfterContentInit,OnChanges, SimpleChange } from '@angular/core';
import { Router, Routes, RouterModule } from '@angular/router';
import {Book} from '../book';
import {Library} from '../library';
import {BookDto} from '../bookDto';
import { ActivatedRoute } from '@angular/router';
import { FormBuilder } from '@angular/forms';
import { LibraryService } from '../service/libraryservice.service';



@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})
export class BooksComponent implements OnInit{//, OnChanges {

  //@Input() book: Book;
//  @Input() library: Library;

  private _library: Library;

  @Input()
  set library(library: Library) {
    this._library = library;
  }

  get library(): Library { return this._library; }

private _libId: number

@Input()
set libId(libId: number) {
  this._libId = libId;
}

get libId(): number { return this._libId; }



  
 // @Input() libid:number;
  selectedBook: Book;
 // bookDto: BookDto;
  passedLib : Library ;
  
 public enableForm: boolean = false;
 bookForm;

  books: Book[];

  constructor(public router: Router,
    private formBuilder: FormBuilder,
    private libService: LibraryService
  ) {
    this.bookForm = this.formBuilder.group({
      isbn: '',
      bookTitle: '',
      publisher: '',
      author: '',
      published: 0
    });
  }

  ngOnInit(): void {
    // this.books = [  
    //   { isbn: 'west-indies',publisher:'Raj' ,author:'sidney', published: 6},
    //   { isbn: 'Greenland',publisher:'Rocky', author:'James', published:67}
    // ];

    this.libService.getLibraries().forEach( e => console.log(e));
    console.log('initialized table');
    //this.selectedBook = null;
   }

  //  ngOnChanges (changes: SimpleChange){
  //   console.log(`After ngonchanges`);
  //   console.log(`changes.currentValue`);
  //   this.selectedBook = null;
  //  }

onSelected(selectedBook: Book): void{
this.selectedBook = selectedBook;
}


delete(book: Book): void{
console.log('table');
}

showForm(): void{
  console.log('enable form');
  // if(this.enableForm === true)
  // this.enableForm = false;
  // else
  // this.enableForm = true;
  this.enableForm = !this.enableForm;
  }

  onSubmit(customerData) {
   console.log(this._libId) ;
   console.log(Object.values(this._library)[0]);

 let bookDto: BookDto = new BookDto();
 bookDto.book  = customerData;
 bookDto.book.borrowedDate = '26-06-2020';
 bookDto.book.dueDate = '26-07-2020';
 bookDto.libraryid = Object.values(this._library)[0];
 this.libService.addBook(bookDto);

    this.bookForm.reset();

    console.warn('Your order has been submitted', bookDto);
    
  }

}


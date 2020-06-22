import { Component, OnInit } from '@angular/core';
import {Library} from '../library';
import { Observable, of } from 'rxjs';
import { LibraryService } from '../service/libraryservice.service';

@Component({
  selector: 'app-libraries',
  templateUrl: './libraries.component.html',
  styleUrls: ['./libraries.component.css']
})
export class LibrariesComponent implements OnInit {

  selectedLibrary: Library;
   Libraries: Observable<Library[]>;
//     = [ 
//     {libraryid: 1, libraryname: 'Batra',libraryaddress: 'Rock', noofgroups: 4, noofsections: 6},
//     {libraryid: 3, libraryname: 'NYC',libraryaddress: 'Madison', noofgroups: 4, noofsections: 6}
// ];
 
  constructor( private libService: LibraryService) { }

  ngOnInit(): void {
    this.Libraries =this.libService.getLibraries();
  }

  onSelect(library:Library){
    this.selectedLibrary = library;
  }

}


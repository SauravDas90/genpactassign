import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';

import {Library} from '../library';

import { MessageService } from './message.service';
import { Book } from '../book';
import {BookDto} from '../bookDto';

@Injectable({
  providedIn: 'root'
})
export class LibraryService {

  private librariesUrl = '/api/libraries';  // URL to web api
  private bookUrl = 'books';
  private addBookUrl = '/api/addBook';

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json', Accept: 'application/json', 'Access-Control-Allow-Origin': '*' })
  };


  constructor(private http: HttpClient,
    private messageService: MessageService) { }


  getLibraries(): Observable<Library[]> {
    return this.http.get<Library[]>(this.librariesUrl, this.httpOptions);
    /*  .pipe(
        tap(_ => this.log('fetched Libraries')),
        catchError(this.handleError<Library[]>('getLibraries', []))
      ); */
     
  }


  /** POST: add a new book to the server */
  addBook(bookDto: BookDto): Observable<BookDto> {
    return this.http.put<BookDto>(this.addBookUrl, bookDto, this.httpOptions);
  }

  getBook(): Observable<Book[]> {
    return this.http.get<Book[]>(this.bookUrl);
    /*  .pipe(
        tap(_ => this.log('fetched Libraries')),
        catchError(this.handleError<Library[]>('getLibraries', []))
      ); */
     
  }


 /*  .pipe(
    tap((book: Book) => this.log(`added Book w/ id=${book.isbn}`)),
    catchError(this.handleError<Book>('addBook'))
  ); */


  /** Log a HeroService message with the MessageService */
  private log(message: string) {
    this.messageService.add(`HeroService: ${message}`);
  }
}

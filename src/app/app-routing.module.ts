import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LibrariesComponent} from './libraries/libraries.component';

import {BooksComponent} from './books/books.component';
import {BookdetailsComponent} from './bookdetails/bookdetails.component';


const routes: Routes = [
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
  { path: 'dashboard', component: LibrariesComponent },
  { path: 'addbook', component: BookdetailsComponent ,pathMatch: 'prefix'}

];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

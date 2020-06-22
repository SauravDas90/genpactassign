import {Book} from './book';

export interface Library {
  libraryid: number;
  libraryname: string;
  libraryaddress: string;
  // noofgroups: number;
  // noofsections: number;
  books: Book[];
}


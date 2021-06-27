import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, map, tap} from 'rxjs/operators';

export class Book{

  constructor(
public id:number,
public name:string

  ){

  }
}

@Component({
  selector: 'app-list-books',
  templateUrl: './list-books.component.html',
  styleUrls: ['./list-books.component.css']
})
export class ListBooksComponent implements OnInit {

  books

  constructor(private http: HttpClient) { }

  ngOnInit() {
    let url = 'http://localhost:8081/api/books';

    let headers: HttpHeaders = new HttpHeaders({
      'Authorization': 'Basic ' + sessionStorage.getItem('token')
    });

    let options = { headers: headers };
    this.http.get<Observable<Object>>(url, options).
    subscribe(books => {
        this.books = books;
      },
      error => {
        if(error.status == 401)
          alert('Unauthorized');
      }
    );
  }

}

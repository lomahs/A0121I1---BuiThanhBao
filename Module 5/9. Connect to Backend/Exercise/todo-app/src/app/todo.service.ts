import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Todo} from "./todo";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class TodoService {
  private readonly API_URL = 'http://localhost:3000/todo';

  constructor(private http: HttpClient) { }

  getTodos(): Observable<Array<Todo>>{
    return this.http.get<Array<Todo>>(this.API_URL);
  }

  createTodo(todo: Partial<Todo>){
    return this.http.post(this.API_URL, todo);
  }

  deleteTodo(id: number){
    return this.http.delete(this.API_URL + '/' + id);
  }

  updateTodo(todo: Todo){
    return this.http.patch<Todo>(`${this.API_URL}/${todo.id}`, todo);
  }

}

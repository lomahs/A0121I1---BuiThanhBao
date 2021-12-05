import { Component, OnInit } from '@angular/core';
import {Todo} from "../todo";
import {TodoService} from "../todo.service";

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {

  listTodo: Array<Todo> = [];

  constructor(private todoService: TodoService) { }

  ngOnInit(): void {
    this.todoService.getTodos().subscribe(data => this.listTodo = data);
  }

  addTodo(value: any) {
    this.todoService.createTodo( {
      completed: false,
      title: value.value,
    }).subscribe(() => {
      this.ngOnInit();
      value.value = '';
    })


  }

  complete(i: Todo) {
      i.completed = !i.completed;

      this.todoService.updateTodo(i).subscribe(
        () => this.ngOnInit()
      );
  }

  delete(i: Todo) {
    this.todoService.deleteTodo(i.id).subscribe(
      () => this.ngOnInit()
    )
  }
}

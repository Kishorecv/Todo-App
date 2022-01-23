import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TodoDataService } from '../service/data/todo-data.service';

export class Todo{
  constructor(
    public id: number,
    public description: string,
    public done: boolean,
    public targetDate: Date
  ){

  }
}

@Component({
  selector: 'app-list-todos',
  templateUrl: './list-todos.component.html',
  styleUrls: ['./list-todos.component.css']
})
export class ListTodosComponent implements OnInit {

  todos : Todo[] =[];

  message: string = '';

  // todos=[
  //   new Todo(1, 'Learn to dance', false, new Date()),
  //   new Todo(2, 'Become an expert at angular', false, new Date()),
  //   new Todo(3, 'visit Canada', true, new Date()),
  //   // {id: 1, description: 'Learn to dance'},
  //   // {id: 2, description: 'Become an expert at angular'},
  //   // {id: 3, description: 'visit Canada'},

  // ]
  // todo = {
  //   id: 1,
  //   description: 'Learn to dance'
  // }

  constructor(
    private todoService: TodoDataService,
    private router: Router
    ) { }

  ngOnInit(): void {
    this.refreshTodos();
  }

  refreshTodos() {
    this.todoService.retrieveAllTodos('Kishore').subscribe(
      response => {
        console.log(response);
        this.todos = response;
      }
    )
  }

  deleteTodo(id){
    console.log(`Delete Todo ${id}`);
    this.todoService.deleteTodo('Kishore', id).subscribe(
      response => {
        console.log(response);
        this.message = `Deletion of ${id} is successful`;
        this.refreshTodos();
      }
    )
  }

  updateTodo(id){
    console.log(`update ${id}`);
    this.router.navigate(['todos', id]);
  }

  addTodo(){
    this.router.navigate(['todos', -1]);
  }

}

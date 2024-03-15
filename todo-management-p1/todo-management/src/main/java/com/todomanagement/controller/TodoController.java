package com.todomanagement.controller;


import com.todomanagement.dto.TodoDto;
import com.todomanagement.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/todos")
@AllArgsConstructor
public class TodoController {
    private TodoService todoService;

    @PostMapping
    public ResponseEntity<TodoDto> addTodo(@RequestBody TodoDto todoDto){
        TodoDto savedTodo = todoService.addTodo(todoDto);
        return new ResponseEntity<>(savedTodo, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<TodoDto> getTodo(@PathVariable("id") Long todoId){
        TodoDto todoDto = todoService.getTodo(todoId);
        return  new ResponseEntity<>(todoDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TodoDto>> getAllTodo(){
        List<TodoDto> todos = todoService.getAllTodo();

        return ResponseEntity.ok(todos);
    }
    @PutMapping("{id}")
    public ResponseEntity<TodoDto> updateTodo(@RequestBody TodoDto todoDto, @PathVariable("id") Long id){
        TodoDto updateTodo = todoService.updateTodo(todoDto, id);

        return ResponseEntity.ok(updateTodo);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> updateTodo( @PathVariable("id") Long id){
            todoService.deleteTodo( id);

        return ResponseEntity.ok("Todo deleted success fully");
    }

    @PatchMapping("{id}/complete")
    public ResponseEntity<TodoDto> completeTodo(@PathVariable("id") Long id){
        TodoDto updateTodo = todoService.completeTodo(id);

        return ResponseEntity.ok(updateTodo);
    }
    @PatchMapping("{id}/in-complete")
    public ResponseEntity<TodoDto> inCompleteTodo(@PathVariable("id") Long id){
        TodoDto updateTodo = todoService.inCompleteTodo(id);

        return ResponseEntity.ok(updateTodo);
    }
}

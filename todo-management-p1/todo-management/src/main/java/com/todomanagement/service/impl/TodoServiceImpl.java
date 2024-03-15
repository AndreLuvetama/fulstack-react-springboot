package com.todomanagement.service.impl;

import com.todomanagement.dto.TodoDto;
import com.todomanagement.entity.Todo;
import com.todomanagement.exception.ResourceNotFoundException;
import com.todomanagement.repository.TodoRepository;
import com.todomanagement.service.TodoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {
    private TodoRepository todoRepository;
    private ModelMapper modelMapper;
    @Override
    public TodoDto addTodo(TodoDto todoDto) {
        //Convert Todo into jpa entity
//        Todo todo = new Todo();
//        todo.setTitle(todoDto.getTitle());
//        todo.setDescription(todoDto.getDescription());
//        todo.setCompleted(todoDto.isCompleted());

        //Saved todo JPA entity object into todoDta object
        Todo todo = modelMapper.map(todoDto, Todo.class);

        Todo savedTodo = todoRepository.save(todo);

//        TodoDto savedTodoDta = new TodoDto();
//        savedTodoDta.setId(savedTodo.getId());
//        savedTodoDta.setTitle(savedTodo.getTitle());
//        savedTodoDta.setDescription(savedTodo.getDescription());
//        savedTodoDta.setCompleted(savedTodo.isCompleted());
        TodoDto savedTodoDta = modelMapper.map(savedTodo, TodoDto.class);

        return savedTodoDta;
    }

    @Override
    public TodoDto getTodo(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Todo not found with this id" +id));

        return modelMapper.map(todo, TodoDto.class);
    }

    @Override
    public List<TodoDto> getAllTodo() {
        List<Todo> todos = todoRepository.findAll();
           return todos.stream().map((todo)-> modelMapper.map(todo, TodoDto.class)).collect(Collectors.toList());
    }

    @Override
    public TodoDto updateTodo(TodoDto todoDto, Long id) {
       Todo todo =  todoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Todo not found with this id" +id));

         todo.setTitle(todoDto.getTitle());
         todo.setDescription(todoDto.getDescription());
         todo.setCompleted(todoDto.isCompleted());
         Todo updateTodo = todoRepository.save(todo);
        return modelMapper.map(updateTodo, TodoDto.class);
    }

    @Override
    public void deleteTodo(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Todo not found with this id" +id));
            todoRepository.delete(todo);
    }

    @Override
    public TodoDto completeTodo(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Todo not found with this id" +id));
        todo.setCompleted(Boolean.TRUE);
        Todo upadatedTodo = todoRepository.save(todo);

        return modelMapper.map(upadatedTodo, TodoDto.class);
    }

    @Override
    public TodoDto inCompleteTodo(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Todo not found with this id" +id));
        todo.setCompleted(Boolean.FALSE);
        Todo upadatedTodo = todoRepository.save(todo);

        return modelMapper.map(upadatedTodo, TodoDto.class);
    }
}

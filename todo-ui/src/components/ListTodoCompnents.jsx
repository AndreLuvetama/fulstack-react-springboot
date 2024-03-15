import React, {useEffect ,useState} from 'react'
import { completeTodo, deleteTodo, getAllTodos, inCompleteTodo } from '../services/TodoServices'
import { useNavigate, useParams } from 'react-router-dom'
import { isAdminUser } from '../services/AuthService'



export const ListTodoCompnents = () => {
    const [todos, setTodos] = useState([])
    const navigate = useNavigate()

    const isAdmin = isAdminUser();
    const {id} = useParams()

    useEffect(() =>{
        listTodos();
    }, [])

    function listTodos(){
        getAllTodos().then((response) => {
            setTodos(response.data);
            }).catch(error => {
                    console.error(error);
            }
        )
    }
   function addNewTodo(){
        navigate('/add-todo')
    }
    function updateTodo(id){
        console.log(id);
        navigate(`/update-todo/${id}`)
    }
    function removeTodo(id){
        deleteTodo(id).then((response) =>{
            console.log(response.data);
            listTodos()
        }).catch(error=>{
            console.error(error);
        })
    }


    function markCompleteTodo(id){
        completeTodo(id).then((response) =>{
            console.log(response.data);
            listTodos()
        }).catch(error=>{
            console.error(error);
        })
    }


    function markInCompleteTodo (id){
        inCompleteTodo(id).then((response) =>{
            console.log(response.data);
            listTodos()
        }).catch(error=>{
            console.error(error);
        })
    }
  return (
    <div className='container'>
        <h2 className='text-center'>List of Todos</h2>
        {
            isAdmin && <button className='btn btn-primary md-2' onClick={addNewTodo}>Add Todo</button>
        }
        <div>
            <table className='table table-bordered table-striped'>
                <thead>
                    <tr>
                        <th>Todo Title</th>
                        <th>Todo Description</th>
                        <th>Todo Completed</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        todos.map(todo => 
                            <tr key={todo.id}>
                                <td>{todo.title}</td>
                                <td>{todo.description}</td>
                                <td>{todo.completed ? 'YES': 'NO'}</td>
                                <td>
                                {
                                    isAdmin && <button className='btn btn-info' onClick={() => updateTodo(todo.id)}>Update</button>
                                }
                                {
                                    isAdmin &&  <button className='btn btn-danger' style={{marginLeft: '10px'}} onClick={() => removeTodo(todo.id)}>Delete</button>
                                
                                }
                                <button className='btn btn-success' style={{marginLeft: '10px'}} onClick={() => markCompleteTodo(todo.id)}>complete</button>
                                <button className='btn btn-info' style={{marginLeft: '10px'}} onClick={() => markInCompleteTodo(todo.id)}>In complete</button>

                                </td>
                            </tr>
                        )
                    }
                </tbody>

            </table>
        </div>
    </div>
  )
}

import React, {useState} from 'react'



export const ListTodoCompnents_teste = () => {
    const dummyData = [
        {
            "id": 1,
            "title": "Learn core Java",
            "description": "Learn core Java with React",
            "Completed": false
        },
        {
            "id": 2,
            "title": "Learn Spring Core",
            "description": "Learn core Java with Examples",
            "completed": false
        },
        {
            "id": 3,
            "title": "Learn Spring Boot",
            "description": "Learn Spring Boot with Java with React",
            "Completed": false
        }
    ]

    const [todos, setTodos] = useState(dummyData)

  return (
    <div className='container'>ListTodoCompnents
        <h2 className='text-center'>List of Todos</h2>
        <div>
            <table className='table table-bordered table-striped'>
                <thead>
                    <tr>
                        <th>Todo Title</th>
                        <th>Todo Description</th>
                        <th>Todo Completed</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        todos.map(todo=> 
                            <tr key={todo.id}>
                                <td>{todo.title}</td>
                                <td>{todo.description}</td>
                                <td>{todo.completed ? 'YES': 'NO'}</td>
                            </tr>
                        )
                    }
                </tbody>

            </table>
        </div>
    </div>
  )
}

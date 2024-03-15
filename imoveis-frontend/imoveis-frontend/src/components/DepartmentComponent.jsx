import React, {useEffect, useState} from 'react'
import { createDepartment, getDepartmentById, updateDepartment } from '../services/DepartmentsService';
import { useNavigate, useParams } from 'react-router-dom';

const DepartmentComponent = () => {
  const [departmentName, setDepartmentsName] = useState('')
  const [departmentDescription, setDepartmentDescription] = useState('')
  const {id} = useParams();
  const navigator = useNavigate();

  useEffect(()=> {
    getDepartmentById(id).then((response) =>{
      setDepartmentsName(response.data.departmentName);
      setDepartmentDescription(response.data.departmentDescription);

    }).catch(error =>{
      console.log(error);
    })
  }, [id])

 function saveOrUpdateDepartment(e){
    e.preventDefault();
    const department = {departmentName, departmentDescription}
    console.log(department)
    if(id){
      updateDepartment(id, department).then((response) =>{
        console.log(response.data)
        navigator('/departments')
      }).catch(error => {
        console.log(error)
      })
    }else{
      createDepartment(department).then((response)=> {
        console.log(response.data)
        navigator('/departments' );
    }).catch((error)=>{
        console.log(error);
    })
    }
  }  


 function pageTitle(){
  if(id){
    return  <h2 className='text-center'>Update Department</h2>
  }else{
    return <h2 className='text-center'>Add Department</h2>
  }
 }

  return (
    <div className='container'>
        <div className='row'>
        <div className="card col-md-6 offset-md-3 offset-md-3">
            {
              pageTitle()
            }
          <div className="card-body">
            <form>
              <div className="form-group mb-2">
                <label className="form-label">Department Name:</label>
                <input type='text' placeholder='Enter Department Name' name='departmentName' 
                value={departmentName} onChange={(e)=> setDepartmentsName(e.target.value)} className='form-control' />
                </div>
                            
              <div className="form-group mb-2">
                <label className="form-label">Department Description:</label>
                <input type='text' placeholder='Enter Department Description' name='departmentDescription' 
                value={departmentDescription} onChange={(e)=> setDepartmentDescription(e.target.value)} className='form-control' />
              </div>
              
              
              <button className='btn btn-success' onClick={(e)=>saveOrUpdateDepartment(e)}>Submit</button>
            </form>
          </div>
        </div>

      </div>
    </div>
  )
}

export default DepartmentComponent
import React, {useState} from 'react'
import { resgisterAPICall } from '../services/AuthService'

 export const RegisterCompnents = () => {
    const [name, setName] = useState('')
    const [username, setUsername] = useState('')
    const [email, setEmail] = useState('')
    const [password, setPassword] = useState('')



    function handelRegstrationForm(e){
        e.preventDefault();
        const register = {name, email, password, username}
        console.log(register)
        resgisterAPICall(register).then((response) => {
            console.log(response.data);
            }).catch(error => {
                console.error(error)
            })

    }

    return (
            <div className='container'>
                <br/>
                <br/>
                <div className='row'>
                    <div className="col-md-6 offset-md-3">
                        <card className='card'>
                            <div className='card-header'>
                                <h2 className='text-center'>User Registration form</h2>
                            </div>
                            <div className='card-body'>
                                <form >
                                    <div className="row mb-3">
                                        <label className='col-md-3 control-label'>Name</label>
                                        <div className='col-md-9 '>
                                            <input type='text' name='name' placeholder='Enter Name' className='form-control'
                                            value={name} onChange={(e) => setName(e.target.value)}/>
                                        </div>
                                    </div>
                                    <div className="row mb-3">
                                        <label className='col-md-3 control-label'>User name</label>
                                        <div className='col-md-9 '>
                                            <input type='text' name='username' placeholder='Enter username' className='form-control'
                                            value={username} onChange={(e) => setUsername(e.target.value)}/>
                                        </div>
                                    </div>
                                    <div className="row mb-3">
                                        <label className='col-md-3 control-label'>Email</label>
                                        <div className='col-md-9 '>
                                            <input type='text' name='email' placeholder='Enter Email' className='form-control'
                                            value={email} onChange={(e) => setEmail(e.target.value)}/>
                                        </div>
                                    </div>
                                    <div className="row mb-3">
                                        <label className='col-md-3 control-label'>Password</label>
                                        <div className='col-md-9 '>
                                            <input type='text' name='password' placeholder='Enter Passwprd' className='form-control'
                                            value={password} onChange={(e) => setPassword(e.target.value)}/>
                                        </div>
                                    </div>
                                    <div className="form-group mb-3">
                                        <button className='btn btn-primary' onClick={(e) => handelRegstrationForm(e)}>Submit</button>
                                    </div>

                                </form>
                            </div>
                        </card>
                    </div>
                </div>
            </div>
  )
} 


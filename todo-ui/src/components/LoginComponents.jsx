import React, {useState} from 'react'
import { loginAPICall, saveLoggedInUser, storeToken } from '../services/AuthService';
import { useNavigate } from 'react-router-dom';

const LoginComponents = () => {
    const [username, setUsername] = useState('')
    const [password, setPassword] = useState('')
    const navigator = useNavigate()
 

  async function handelLoginForm(e){
        e.preventDefault();

     await loginAPICall(username, password).then((response) => {
            console.log(response.data);
            //const token = 'Basic ' + window.btoa(username + ":" + password);
            const token = 'Bearer ' + response.data.accessToken;
            const role = response.data.role;
           
            storeToken(token);
            saveLoggedInUser(username, role)
            navigator("/todos")
            window.location.reload(false);
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
                    <h2 className='text-center'>Login form</h2>
                </div>
                <div className='card-body'>
                    <form >
                        <div className="row mb-3">
                            <label className='col-md-3 control-label'>Username or email</label>
                            <div className='col-md-9 '>
                                <input type='text' name='username' placeholder='Enter Username' className='form-control'
                                value={username} onChange={(e) => setUsername(e.target.value)}/>
                            </div>
                        </div>
                        <div className="row mb-3">
                            <label className='col-md-3 control-label'>User password</label>
                            <div className='col-md-9 '>
                                <input type='text' name='password' placeholder='Enter username' className='form-control'
                                value={password} onChange={(e) => setPassword(e.target.value)}/>
                            </div>
                        </div>
                                             
                        <div className="form-group mb-3">
                            <button className='btn btn-primary' onClick={(e) => handelLoginForm(e)}>Submit</button>
                        </div>

                    </form>
                </div>
            </card>
        </div>
    </div>
</div>
  )
}

export default LoginComponents
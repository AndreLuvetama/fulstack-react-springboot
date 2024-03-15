
import { BrowserRouter, Routes, Route, Navigate} from 'react-router-dom'
import './App.css'
import { ListTodoCompnents } from './components/ListTodoCompnents'
import HeaderComponents from './components/HeaderComponents'
import FooterCompnents from './components/FooterCompnents'
import { TodoComponent } from './components/TodoComponent'
import { RegisterCompnents } from './components/RegisterCompnents'
import LoginComponents from './components/LoginComponents'
import { isUserLoggedIn } from './services/AuthService'

function App() {

  function AuthenticatedRoute({children}){

    const isAuth = isUserLoggedIn();

    if(isAuth) {
      return children;
    }

    return <Navigate to="/" />

  }



  return (
    <>
      <BrowserRouter>
      <HeaderComponents/>
      <Routes >
        <Route path='/' element={<LoginComponents/>}></Route>
        <Route path='/todos' element = { 
              <AuthenticatedRoute>
                <ListTodoCompnents />
              </AuthenticatedRoute> 
              }>
          </Route>
          <Route path='/add-todo' element = { 
                <AuthenticatedRoute>
                <TodoComponent /> 
                </AuthenticatedRoute>
              }>
              </Route>
              <Route path='/update-todo/:id' element = { 
              <AuthenticatedRoute>
              <TodoComponent /> 
              </AuthenticatedRoute>
              }></Route>
        <Route path='/register' element={<RegisterCompnents/>}></Route>
        <Route path='/login' element={<LoginComponents/>}></Route>


      </Routes>
     
      <FooterCompnents/>
      
      </BrowserRouter>
    </>
  )
}

export default App

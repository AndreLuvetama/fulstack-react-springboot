
import { Route, Routes, BrowserRouter } from 'react-router-dom'
import './App.css'
import FooterComponent from './components/FooterComponent'
import HeaderComponents from './components/HeaderComponents'
import ListEmployeeComponents from './components/ListEmployeeComponents'
import EmployeeComponents from './components/EmployeeComponents'
import ListDepartmentsComponents from './components/ListDepartmentsComponents'
import DepartmentComponent from './components/DepartmentComponent'

function App() {


  return (
    <>
    <BrowserRouter>
      <HeaderComponents/>      
  
      <Routes>
          <Route path='/' element={<ListEmployeeComponents />}></Route>
          <Route path='/employees' element={<ListEmployeeComponents />}></Route>
          <Route path='/add-employee' element={<EmployeeComponents />}></Route>
          <Route path='/edit-employee/:id' element={<EmployeeComponents />}></Route>
          <Route path='/add-department' element={<DepartmentComponent />}></Route>
          <Route path='/departments' element={<ListDepartmentsComponents />}></Route>
          <Route path='/edit-department/:id' element={<DepartmentComponent />}></Route>
      </Routes>
      <FooterComponent/>
      </BrowserRouter>
    </>
  )
}

export default App

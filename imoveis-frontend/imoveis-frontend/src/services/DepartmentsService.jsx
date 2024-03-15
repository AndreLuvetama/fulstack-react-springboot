import axios from "axios";

const DEPARTMENT_REST_API_URL = 'http://localhost:8088/api/department'

export const getAllDepartments = () => axios.get(DEPARTMENT_REST_API_URL)
export const createDepartment = (department) => axios.post(DEPARTMENT_REST_API_URL, department)
export const getDepartmentById = (departmentId) => axios.get(DEPARTMENT_REST_API_URL + '/' + departmentId)
export const updateDepartment = (departmentId, department) => axios.put(DEPARTMENT_REST_API_URL + '/' + departmentId, department)
export const deleteDepartment = (departmentId) => axios.delete(DEPARTMENT_REST_API_URL + '/' + departmentId);






import axios from "axios";

const api = axios.create({
    baseURL: "http://44.205.157.25:8081/api/"
})

export default api;
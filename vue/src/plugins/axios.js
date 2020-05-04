// inspired by vue-element-admin
// https://panjiachen.github.io/vue-element-admin-site/guide/essentials/server.html#front-end-request-flow

import axios from 'axios'
import store from '../store'

// get token from localStorage
const token = localStorage.getItem('token')
// create an axios instance
const service = axios.create({
  baseURL: process.env.VUE_APP_BASE_API, // url = base url + request url
  // withCredentials: true, // send cookies when cross-domain requests
  timeout: 5000, // request timeout
  // default type json
  headers: {
    'Content-type': 'application/json',
    Authorization: token ? `Bearer ${token}` : null
  }
})

// request interceptor
service.interceptors.request.use(
  config => {
    // do something before request is sent

    // if (store.getters.token) {
    // let each request carry token
    // ['X-Token'] is a custom headers key
    // please modify it according to the actual situation
    // config.headers['X-Token'] = getToken()
    // }
    return config
  },
  error => {
    // do something with request error
    console.log(error) // for debug
    return Promise.reject(error)
  }
)

// response interceptor
service.interceptors.response.use(
  /**
   * If you want to get http information such as headers or status
   * Please return  response => response
   */

  /**
   * Determine the request status by custom code
   * Here is just an example
   * You can also judge the status by HTTP Status Code
   */
  response => {
    const res = response.data
    // status is 200, but has error code
    if (res.code && res.error) {
      store.commit('CALL_MESSAGE', { text: res, timeout: 4000 })
      console.log(res) // for debug
      return Promise.reject(new Error(res.error || 'Error'))
    } else {
      return res
    }
  },
  // http status
  error => {
    // if there is a code and error, it is judged as an known error.
    // error: code(Number) error(String)
    const e = error.response.data
    if (e.code && e.error) {
      store.commit('CALL_MESSAGE', { text: e, timeout: 4000 })
      return Promise.reject(e)
    } else {
      // unknown error
      return Promise.reject(error)
    }
  }
)

export default service

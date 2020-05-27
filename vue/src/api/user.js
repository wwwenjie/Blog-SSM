import request from '../plugins/axios'

export function register (user) {
  return request({
    url: '/users',
    method: 'POST',
    data: user
  })
}

export function login (user) {
  return request({
    url: '/tokens',
    method: 'POST',
    data: user
  })
}

export function addAddress (address) {
  return request({
    url: '/address',
    method: 'POST',
    data: address
  })
}

export function uploadImg (data) {
  console.log(data)
  return request({
    headers: {
      'Content-type': 'application/json'
    },
    url: '/images',
    method: 'POST',
    data: data
  })
}

export function getUserInfo (id) {
  return request({
    url: `/users/${id}`,
    method: 'GET'
  })
}

export function getUserList (pageNum = 1, pageSize = 5) {
  return request({
    url: '/users',
    method: 'GET',
    params: {
      pageNum: pageNum,
      pageSize: pageSize
    }
  })
}

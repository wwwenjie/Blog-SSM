import request from '../plugins/axios'

export function getBlogName () {
  return request({
    url: '/options/name',
    method: 'GET'
  })
}

export function updateOption (option) {
  return request({
    url: '/options',
    method: 'PATCH',
    data: option
  })
}

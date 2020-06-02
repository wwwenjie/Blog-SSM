import request from '../plugins/axios'

export function getLogTotal () {
  return request({
    url: '/logs/total',
    method: 'GET'
  })
}

export function getLogList (pageNum = 0, pageSize = 8) {
  return request({
    url: '/logs',
    method: 'GET',
    params: {
      pageNum: pageNum,
      pageSize: pageSize
    }
  })
}

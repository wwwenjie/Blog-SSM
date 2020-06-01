import request from '../plugins/axios'

export function getCommentList (pageNum = 0, pageSize = 8) {
  return request({
    url: '/comments',
    method: 'GET',
    params: {
      pageNum: pageNum,
      pageSize: pageSize
    }
  })
}

export function getCommentByArticleId (articleId) {
  return request({
    url: '/comments',
    method: 'GET',
    params: {
      articleId: articleId
    }
  })
}

export function getCommentByUserId (userId) {
  return request({
    url: '/comments',
    method: 'GET',
    params: {
      userId: userId
    }
  })
}

export function getCommentTotal (userId) {
  return request({
    url: '/comments/total',
    method: 'GET'
  })
}

export function creatComment (comment) {
  return request({
    url: '/comments',
    method: 'POST',
    data: comment
  })
}

export function updateComment (comment) {
  return request({
    url: '/comments',
    method: 'PATCH',
    data: comment
  })
}

export function deleteComment (commentId) {
  return request({
    url: '/comments',
    method: 'DELETE',
    params: {
      commentId: commentId
    }
  })
}

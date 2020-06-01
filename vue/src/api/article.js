import request from '../plugins/axios'

export function getArticleList (pageNum = 0, pageSize = 8) {
  return request({
    url: '/articles',
    method: 'GET',
    params: {
      pageNum: pageNum,
      pageSize: pageSize
    }
  })
}

export function getArticleTotal () {
  return request({
    url: '/articles/total',
    method: 'GET'
  })
}

export function getArticle (id) {
  return request({
    url: `/articles/${id}`,
    method: 'GET'
  })
}

export function getArticleByUserId (userId, pageNum = 0, pageSize = 8) {
  return request({
    url: '/articles',
    method: 'GET',
    params: {
      pageNum: pageNum,
      pageSize: pageSize,
      userId: userId
    }
  })
}

export function getArticleByCategory (articleCategory, pageNum = 0, pageSize = 8) {
  return request({
    url: '/articles',
    method: 'GET',
    params: {
      pageNum: pageNum,
      pageSize: pageSize,
      articleCategory: articleCategory
    }
  })
}

export function creatArticle (article) {
  return request({
    url: '/articles',
    method: 'POST',
    data: article
  })
}

export function updateArticle (article) {
  return request({
    url: '/articles',
    method: 'PATCH',
    data: article
  })
}

export function deleteArticle (articleId) {
  return request({
    url: '/articles',
    method: 'DELETE',
    params: {
      articleId: articleId
    }
  })
}

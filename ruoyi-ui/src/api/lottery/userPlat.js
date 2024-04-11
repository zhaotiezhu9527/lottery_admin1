import request from '@/utils/request'

// 查询三方用户列表
export function listUserPlat(query) {
  return request({
    url: '/lottery/userPlat/list',
    method: 'get',
    params: query
  })
}

// 查询三方用户详细
export function getUserPlat(id) {
  return request({
    url: '/lottery/userPlat/' + id,
    method: 'get'
  })
}

// 新增三方用户
export function addUserPlat(data) {
  return request({
    url: '/lottery/userPlat',
    method: 'post',
    data: data
  })
}

// 修改三方用户
export function updateUserPlat(data) {
  return request({
    url: '/lottery/userPlat',
    method: 'put',
    data: data
  })
}

// 删除三方用户
export function delUserPlat(id) {
  return request({
    url: '/lottery/userPlat/' + id,
    method: 'delete'
  })
}

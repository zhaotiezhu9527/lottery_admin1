import request from '@/utils/request'

// 查询头像管理列表
export function listAvatar(query) {
  return request({
    url: '/lottery/avatar/list',
    method: 'get',
    params: query
  })
}

// 查询头像管理详细
export function getAvatar(id) {
  return request({
    url: '/lottery/avatar/' + id,
    method: 'get'
  })
}

// 新增头像管理
export function addAvatar(data) {
  return request({
    url: '/lottery/avatar',
    method: 'post',
    data: data
  })
}

// 修改头像管理
export function updateAvatar(data) {
  return request({
    url: '/lottery/avatar',
    method: 'put',
    data: data
  })
}

// 删除头像管理
export function delAvatar(id) {
  return request({
    url: '/lottery/avatar/' + id,
    method: 'delete'
  })
}

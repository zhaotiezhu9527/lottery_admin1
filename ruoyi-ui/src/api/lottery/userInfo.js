import request from '@/utils/request'

// 查询会员列表列表
export function listUserInfo(query) {
  return request({
    url: '/lottery/userInfo/list',
    method: 'get',
    params: query
  })
}

// 查询会员列表详细
export function getUserInfo(id) {
  return request({
    url: '/lottery/userInfo/' + id,
    method: 'get'
  })
}

// 新增会员列表
export function addUserInfo(data) {
  return request({
    url: '/lottery/userInfo',
    method: 'post',
    data: data
  })
}

// 修改会员列表
export function updateUserInfo(data) {
  return request({
    url: '/lottery/userInfo',
    method: 'put',
    data: data
  })
}

// 删除会员列表
export function delUserInfo(id) {
  return request({
    url: '/lottery/userInfo/' + id,
    method: 'delete'
  })
}

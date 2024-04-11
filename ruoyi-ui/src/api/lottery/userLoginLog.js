import request from '@/utils/request'

// 查询登录日志列表
export function listUserLoginLog(query) {
  return request({
    url: '/lottery/userLoginLog/list',
    method: 'get',
    params: query
  })
}

// 查询登录日志详细
export function getUserLoginLog(id) {
  return request({
    url: '/lottery/userLoginLog/' + id,
    method: 'get'
  })
}

// 新增登录日志
export function addUserLoginLog(data) {
  return request({
    url: '/lottery/userLoginLog',
    method: 'post',
    data: data
  })
}

// 修改登录日志
export function updateUserLoginLog(data) {
  return request({
    url: '/lottery/userLoginLog',
    method: 'put',
    data: data
  })
}

// 删除登录日志
export function delUserLoginLog(id) {
  return request({
    url: '/lottery/userLoginLog/' + id,
    method: 'delete'
  })
}

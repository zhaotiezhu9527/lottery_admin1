import request from '@/utils/request'

// 查询收款方式列表
export function listUserAccount(query) {
  return request({
    url: '/lottery/userAccount/list',
    method: 'get',
    params: query
  })
}

// 查询收款方式详细
export function getUserAccount(id) {
  return request({
    url: '/lottery/userAccount/' + id,
    method: 'get'
  })
}

// 新增收款方式
export function addUserAccount(data) {
  return request({
    url: '/lottery/userAccount',
    method: 'post',
    data: data
  })
}

// 修改收款方式
export function updateUserAccount(data) {
  return request({
    url: '/lottery/userAccount',
    method: 'put',
    data: data
  })
}

// 删除收款方式
export function delUserAccount(id) {
  return request({
    url: '/lottery/userAccount/' + id,
    method: 'delete'
  })
}

import request from '@/utils/request'

// 查询公司入款账号列表
export function listCompanyAccount(query) {
  return request({
    url: '/lottery/companyAccount/list',
    method: 'get',
    params: query
  })
}

// 查询公司入款账号详细
export function getCompanyAccount(id) {
  return request({
    url: '/lottery/companyAccount/' + id,
    method: 'get'
  })
}

// 新增公司入款账号
export function addCompanyAccount(data) {
  return request({
    url: '/lottery/companyAccount',
    method: 'post',
    data: data
  })
}

// 修改公司入款账号
export function updateCompanyAccount(data) {
  return request({
    url: '/lottery/companyAccount',
    method: 'put',
    data: data
  })
}

// 删除公司入款账号
export function delCompanyAccount(id) {
  return request({
    url: '/lottery/companyAccount/' + id,
    method: 'delete'
  })
}

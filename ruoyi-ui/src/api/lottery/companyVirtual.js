import request from '@/utils/request'

// 查询公司U地址列表
export function listCompanyVirtual(query) {
  return request({
    url: '/lottery/companyVirtual/list',
    method: 'get',
    params: query
  })
}

// 查询公司U地址详细
export function getCompanyVirtual(id) {
  return request({
    url: '/lottery/companyVirtual/' + id,
    method: 'get'
  })
}

// 新增公司U地址
export function addCompanyVirtual(data) {
  return request({
    url: '/lottery/companyVirtual',
    method: 'post',
    data: data
  })
}

// 修改公司U地址
export function updateCompanyVirtual(data) {
  return request({
    url: '/lottery/companyVirtual',
    method: 'put',
    data: data
  })
}

// 删除公司U地址
export function delCompanyVirtual(id) {
  return request({
    url: '/lottery/companyVirtual/' + id,
    method: 'delete'
  })
}

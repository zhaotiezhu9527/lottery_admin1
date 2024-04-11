import request from '@/utils/request'

// 查询AG注单列表
export function listAgRecord(query) {
  return request({
    url: '/lottery/agRecord/list',
    method: 'get',
    params: query
  })
}

// 查询AG注单详细
export function getAgRecord(id) {
  return request({
    url: '/lottery/agRecord/' + id,
    method: 'get'
  })
}

// 新增AG注单
export function addAgRecord(data) {
  return request({
    url: '/lottery/agRecord',
    method: 'post',
    data: data
  })
}

// 修改AG注单
export function updateAgRecord(data) {
  return request({
    url: '/lottery/agRecord',
    method: 'put',
    data: data
  })
}

// 删除AG注单
export function delAgRecord(id) {
  return request({
    url: '/lottery/agRecord/' + id,
    method: 'delete'
  })
}

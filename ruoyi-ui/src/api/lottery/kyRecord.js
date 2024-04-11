import request from '@/utils/request'

// 查询开元注单列表
export function listKyRecord(query) {
  return request({
    url: '/lottery/kyRecord/list',
    method: 'get',
    params: query
  })
}

// 查询开元注单详细
export function getKyRecord(id) {
  return request({
    url: '/lottery/kyRecord/' + id,
    method: 'get'
  })
}

// 新增开元注单
export function addKyRecord(data) {
  return request({
    url: '/lottery/kyRecord',
    method: 'post',
    data: data
  })
}

// 修改开元注单
export function updateKyRecord(data) {
  return request({
    url: '/lottery/kyRecord',
    method: 'put',
    data: data
  })
}

// 删除开元注单
export function delKyRecord(id) {
  return request({
    url: '/lottery/kyRecord/' + id,
    method: 'delete'
  })
}

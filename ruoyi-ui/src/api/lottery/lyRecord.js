import request from '@/utils/request'

// 查询乐游注单列表
export function listLyRecord(query) {
  return request({
    url: '/lottery/lyRecord/list',
    method: 'get',
    params: query
  })
}

// 查询乐游注单详细
export function getLyRecord(id) {
  return request({
    url: '/lottery/lyRecord/' + id,
    method: 'get'
  })
}

// 新增乐游注单
export function addLyRecord(data) {
  return request({
    url: '/lottery/lyRecord',
    method: 'post',
    data: data
  })
}

// 修改乐游注单
export function updateLyRecord(data) {
  return request({
    url: '/lottery/lyRecord',
    method: 'put',
    data: data
  })
}

// 删除乐游注单
export function delLyRecord(id) {
  return request({
    url: '/lottery/lyRecord/' + id,
    method: 'delete'
  })
}

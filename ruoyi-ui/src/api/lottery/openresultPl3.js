import request from '@/utils/request'

// 查询排列3列表
export function listOpenresultPl3(query) {
  return request({
    url: '/lottery/openresultPl3/list',
    method: 'get',
    params: query
  })
}

// 查询排列3详细
export function getOpenresultPl3(id) {
  return request({
    url: '/lottery/openresultPl3/' + id,
    method: 'get'
  })
}

// 新增排列3
export function addOpenresultPl3(data) {
  return request({
    url: '/lottery/openresultPl3',
    method: 'post',
    data: data
  })
}

// 修改排列3
export function updateOpenresultPl3(data) {
  return request({
    url: '/lottery/openresultPl3',
    method: 'put',
    data: data
  })
}

// 删除排列3
export function delOpenresultPl3(id) {
  return request({
    url: '/lottery/openresultPl3/' + id,
    method: 'delete'
  })
}

import request from '@/utils/request'

// 查询平台管理列表
export function listPlatform(query) {
  return request({
    url: '/lottery/platform/list',
    method: 'get',
    params: query
  })
}

// 查询平台管理详细
export function getPlatform(id) {
  return request({
    url: '/lottery/platform/' + id,
    method: 'get'
  })
}

// 新增平台管理
export function addPlatform(data) {
  return request({
    url: '/lottery/platform',
    method: 'post',
    data: data
  })
}

// 修改平台管理
export function updatePlatform(data) {
  return request({
    url: '/lottery/platform',
    method: 'put',
    data: data
  })
}

// 删除平台管理
export function delPlatform(id) {
  return request({
    url: '/lottery/platform/' + id,
    method: 'delete'
  })
}

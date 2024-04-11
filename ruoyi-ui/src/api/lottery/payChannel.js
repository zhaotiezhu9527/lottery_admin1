import request from '@/utils/request'

// 查询渠道管理列表
export function listPayChannel(query) {
  return request({
    url: '/lottery/payChannel/list',
    method: 'get',
    params: query
  })
}

// 查询渠道管理详细
export function getPayChannel(id) {
  return request({
    url: '/lottery/payChannel/' + id,
    method: 'get'
  })
}

// 新增渠道管理
export function addPayChannel(data) {
  return request({
    url: '/lottery/payChannel',
    method: 'post',
    data: data
  })
}

// 修改渠道管理
export function updatePayChannel(data) {
  return request({
    url: '/lottery/payChannel',
    method: 'put',
    data: data
  })
}

// 删除渠道管理
export function delPayChannel(id) {
  return request({
    url: '/lottery/payChannel/' + id,
    method: 'delete'
  })
}

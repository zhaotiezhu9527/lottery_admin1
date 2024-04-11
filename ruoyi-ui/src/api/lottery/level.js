import request from '@/utils/request'

// 查询等级管理列表
export function listLevel(query) {
  return request({
    url: '/lottery/level/list',
    method: 'get',
    params: query
  })
}

// 查询等级管理详细
export function getLevel(id) {
  return request({
    url: '/lottery/level/' + id,
    method: 'get'
  })
}

// 新增等级管理
export function addLevel(data) {
  return request({
    url: '/lottery/level',
    method: 'post',
    data: data
  })
}

// 修改等级管理
export function updateLevel(data) {
  return request({
    url: '/lottery/level',
    method: 'put',
    data: data
  })
}

// 删除等级管理
export function delLevel(id) {
  return request({
    url: '/lottery/level/' + id,
    method: 'delete'
  })
}

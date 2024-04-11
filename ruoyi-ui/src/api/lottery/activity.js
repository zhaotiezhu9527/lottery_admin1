import request from '@/utils/request'

// 查询活动配置列表
export function listActivity(query) {
  return request({
    url: '/lottery/activity/list',
    method: 'get',
    params: query
  })
}

// 查询活动配置详细
export function getActivity(id) {
  return request({
    url: '/lottery/activity/' + id,
    method: 'get'
  })
}

// 新增活动配置
export function addActivity(data) {
  return request({
    url: '/lottery/activity',
    method: 'post',
    data: data
  })
}

// 修改活动配置
export function updateActivity(data) {
  return request({
    url: '/lottery/activity',
    method: 'put',
    data: data
  })
}

// 删除活动配置
export function delActivity(id) {
  return request({
    url: '/lottery/activity/' + id,
    method: 'delete'
  })
}

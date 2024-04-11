import request from '@/utils/request'

// 查询开奖结果(江苏快3)列表
export function listOpenresultJsk3(query) {
  return request({
    url: '/lottery/openresultJsk3/list',
    method: 'get',
    params: query
  })
}

// 查询开奖结果(江苏快3)详细
export function getOpenresultJsk3(id) {
  return request({
    url: '/lottery/openresultJsk3/' + id,
    method: 'get'
  })
}

// 新增开奖结果(江苏快3)
export function addOpenresultJsk3(data) {
  return request({
    url: '/lottery/openresultJsk3',
    method: 'post',
    data: data
  })
}

// 修改开奖结果(江苏快3)
export function updateOpenresultJsk3(data) {
  return request({
    url: '/lottery/openresultJsk3',
    method: 'put',
    data: data
  })
}

// 删除开奖结果(江苏快3)
export function delOpenresultJsk3(id) {
  return request({
    url: '/lottery/openresultJsk3/' + id,
    method: 'delete'
  })
}

import request from '@/utils/request'

// 查询开奖结果(北京快乐8)列表
export function listOpenresultBjkl8(query) {
  return request({
    url: '/lottery/openresultBjkl8/list',
    method: 'get',
    params: query
  })
}

// 查询开奖结果(北京快乐8)详细
export function getOpenresultBjkl8(id) {
  return request({
    url: '/lottery/openresultBjkl8/' + id,
    method: 'get'
  })
}

// 新增开奖结果(北京快乐8)
export function addOpenresultBjkl8(data) {
  return request({
    url: '/lottery/openresultBjkl8',
    method: 'post',
    data: data
  })
}

// 修改开奖结果(北京快乐8)
export function updateOpenresultBjkl8(data) {
  return request({
    url: '/lottery/openresultBjkl8',
    method: 'put',
    data: data
  })
}

// 删除开奖结果(北京快乐8)
export function delOpenresultBjkl8(id) {
  return request({
    url: '/lottery/openresultBjkl8/' + id,
    method: 'delete'
  })
}

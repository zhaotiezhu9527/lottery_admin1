import request from '@/utils/request'

// 查询香港六合彩列表
export function listOpenresultHklhc(query) {
  return request({
    url: '/lottery/openresultHklhc/list',
    method: 'get',
    params: query
  })
}

// 查询香港六合彩详细
export function getOpenresultHklhc(id) {
  return request({
    url: '/lottery/openresultHklhc/' + id,
    method: 'get'
  })
}

// 新增香港六合彩
export function addOpenresultHklhc(data) {
  return request({
    url: '/lottery/openresultHklhc',
    method: 'post',
    data: data
  })
}

// 修改香港六合彩
export function updateOpenresultHklhc(data) {
  return request({
    url: '/lottery/openresultHklhc',
    method: 'put',
    data: data
  })
}

// 删除香港六合彩
export function delOpenresultHklhc(id) {
  return request({
    url: '/lottery/openresultHklhc/' + id,
    method: 'delete'
  })
}

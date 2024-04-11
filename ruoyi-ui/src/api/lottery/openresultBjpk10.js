import request from '@/utils/request'

// 查询开奖结果(北京PK10)列表
export function listOpenresultBjpk10(query) {
  return request({
    url: '/lottery/openresultBjpk10/list',
    method: 'get',
    params: query
  })
}

// 查询开奖结果(北京PK10)详细
export function getOpenresultBjpk10(id) {
  return request({
    url: '/lottery/openresultBjpk10/' + id,
    method: 'get'
  })
}

// 新增开奖结果(北京PK10)
export function addOpenresultBjpk10(data) {
  return request({
    url: '/lottery/openresultBjpk10',
    method: 'post',
    data: data
  })
}

// 修改开奖结果(北京PK10)
export function updateOpenresultBjpk10(data) {
  return request({
    url: '/lottery/openresultBjpk10',
    method: 'put',
    data: data
  })
}

// 删除开奖结果(北京PK10)
export function delOpenresultBjpk10(id) {
  return request({
    url: '/lottery/openresultBjpk10/' + id,
    method: 'delete'
  })
}

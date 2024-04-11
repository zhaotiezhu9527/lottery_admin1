import request from '@/utils/request'

// 查询开奖结果(广东11选5)列表
export function listOpenresultGd11x5(query) {
  return request({
    url: '/lottery/openresultGd11x5/list',
    method: 'get',
    params: query
  })
}

// 查询开奖结果(广东11选5)详细
export function getOpenresultGd11x5(id) {
  return request({
    url: '/lottery/openresultGd11x5/' + id,
    method: 'get'
  })
}

// 新增开奖结果(广东11选5)
export function addOpenresultGd11x5(data) {
  return request({
    url: '/lottery/openresultGd11x5',
    method: 'post',
    data: data
  })
}

// 修改开奖结果(广东11选5)
export function updateOpenresultGd11x5(data) {
  return request({
    url: '/lottery/openresultGd11x5',
    method: 'put',
    data: data
  })
}

// 删除开奖结果(广东11选5)
export function delOpenresultGd11x5(id) {
  return request({
    url: '/lottery/openresultGd11x5/' + id,
    method: 'delete'
  })
}

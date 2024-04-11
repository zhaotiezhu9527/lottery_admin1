import request from '@/utils/request'

// 查询开奖结果(重庆时时彩)列表
export function listOpenresultCqssc(query) {
  return request({
    url: '/lottery/openresultCqssc/list',
    method: 'get',
    params: query
  })
}

// 查询开奖结果(重庆时时彩)详细
export function getOpenresultCqssc(id) {
  return request({
    url: '/lottery/openresultCqssc/' + id,
    method: 'get'
  })
}

// 新增开奖结果(重庆时时彩)
export function addOpenresultCqssc(data) {
  return request({
    url: '/lottery/openresultCqssc',
    method: 'post',
    data: data
  })
}

// 修改开奖结果(重庆时时彩)
export function updateOpenresultCqssc(data) {
  return request({
    url: '/lottery/openresultCqssc',
    method: 'put',
    data: data
  })
}

// 删除开奖结果(重庆时时彩)
export function delOpenresultCqssc(id) {
  return request({
    url: '/lottery/openresultCqssc/' + id,
    method: 'delete'
  })
}

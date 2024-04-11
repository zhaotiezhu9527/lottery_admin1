import request from '@/utils/request'

// 查询开奖结果(澳门六合彩)列表
export function listOpenresultMo6hc(query) {
  return request({
    url: '/lottery/openresultMo6hc/list',
    method: 'get',
    params: query
  })
}

// 查询开奖结果(澳门六合彩)详细
export function getOpenresultMo6hc(id) {
  return request({
    url: '/lottery/openresultMo6hc/' + id,
    method: 'get'
  })
}

// 新增开奖结果(澳门六合彩)
export function addOpenresultMo6hc(data) {
  return request({
    url: '/lottery/openresultMo6hc',
    method: 'post',
    data: data
  })
}

// 修改开奖结果(澳门六合彩)
export function updateOpenresultMo6hc(data) {
  return request({
    url: '/lottery/openresultMo6hc',
    method: 'put',
    data: data
  })
}

// 删除开奖结果(澳门六合彩)
export function delOpenresultMo6hc(id) {
  return request({
    url: '/lottery/openresultMo6hc/' + id,
    method: 'delete'
  })
}

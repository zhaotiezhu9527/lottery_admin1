import request from '@/utils/request'

// 查询开奖结果(PC蛋蛋)列表
export function listOpenresultPcdd(query) {
  return request({
    url: '/lottery/openresultPcdd/list',
    method: 'get',
    params: query
  })
}

// 查询开奖结果(PC蛋蛋)详细
export function getOpenresultPcdd(id) {
  return request({
    url: '/lottery/openresultPcdd/' + id,
    method: 'get'
  })
}

// 新增开奖结果(PC蛋蛋)
export function addOpenresultPcdd(data) {
  return request({
    url: '/lottery/openresultPcdd',
    method: 'post',
    data: data
  })
}

// 修改开奖结果(PC蛋蛋)
export function updateOpenresultPcdd(data) {
  return request({
    url: '/lottery/openresultPcdd',
    method: 'put',
    data: data
  })
}

// 删除开奖结果(PC蛋蛋)
export function delOpenresultPcdd(id) {
  return request({
    url: '/lottery/openresultPcdd/' + id,
    method: 'delete'
  })
}

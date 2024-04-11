import request from '@/utils/request'

// 查询开奖结果(gs1mssc)列表
export function listOpenresultGs1mssc(query) {
  return request({
    url: '/lottery/openresultGs1mssc/list',
    method: 'get',
    params: query
  })
}

// 查询开奖结果(gs1mssc)详细
export function getOpenresultGs1mssc(id) {
  return request({
    url: '/lottery/openresultGs1mssc/' + id,
    method: 'get'
  })
}

// 新增开奖结果(gs1mssc)
export function addOpenresultGs1mssc(data) {
  return request({
    url: '/lottery/openresultGs1mssc',
    method: 'post',
    data: data
  })
}

// 修改开奖结果(gs1mssc)
export function updateOpenresultGs1mssc(data) {
  return request({
    url: '/lottery/openresultGs1mssc',
    method: 'put',
    data: data
  })
}

// 删除开奖结果(gs1mssc)
export function delOpenresultGs1mssc(id) {
  return request({
    url: '/lottery/openresultGs1mssc/' + id,
    method: 'delete'
  })
}

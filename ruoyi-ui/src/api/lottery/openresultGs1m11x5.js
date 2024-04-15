import request from '@/utils/request'

// 查询1分11选5列表
export function listOpenresultGs1m11x5(query) {
  return request({
    url: '/lottery/openresultGs1m11x5/list',
    method: 'get',
    params: query
  })
}

// 查询1分11选5详细
export function getOpenresultGs1m11x5(id) {
  return request({
    url: '/lottery/openresultGs1m11x5/' + id,
    method: 'get'
  })
}

// 新增1分11选5
export function addOpenresultGs1m11x5(data) {
  return request({
    url: '/lottery/openresultGs1m11x5',
    method: 'post',
    data: data
  })
}

// 修改1分11选5
export function updateOpenresultGs1m11x5(data) {
  return request({
    url: '/lottery/openresultGs1m11x5',
    method: 'put',
    data: data
  })
}

// 删除1分11选5
export function delOpenresultGs1m11x5(id) {
  return request({
    url: '/lottery/openresultGs1m11x5/' + id,
    method: 'delete'
  })
}

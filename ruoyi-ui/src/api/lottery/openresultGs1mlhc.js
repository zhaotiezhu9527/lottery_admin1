import request from '@/utils/request'

// 查询1分六合彩开奖列表
export function listOpenresultGs1mlhc(query) {
  return request({
    url: '/lottery/openresultGs1mlhc/list',
    method: 'get',
    params: query
  })
}

// 查询1分六合彩开奖详细
export function getOpenresultGs1mlhc(id) {
  return request({
    url: '/lottery/openresultGs1mlhc/' + id,
    method: 'get'
  })
}

// 新增1分六合彩开奖
export function addOpenresultGs1mlhc(data) {
  return request({
    url: '/lottery/openresultGs1mlhc',
    method: 'post',
    data: data
  })
}

// 修改1分六合彩开奖
export function updateOpenresultGs1mlhc(data) {
  return request({
    url: '/lottery/openresultGs1mlhc',
    method: 'put',
    data: data
  })
}

// 删除1分六合彩开奖
export function delOpenresultGs1mlhc(id) {
  return request({
    url: '/lottery/openresultGs1mlhc/' + id,
    method: 'delete'
  })
}

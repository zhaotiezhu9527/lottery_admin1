import request from '@/utils/request'

// 查询1分PC蛋蛋列表
export function listOpenresultGs1mpcdd(query) {
  return request({
    url: '/lottery/openresultGs1mpcdd/list',
    method: 'get',
    params: query
  })
}

// 查询1分PC蛋蛋详细
export function getOpenresultGs1mpcdd(id) {
  return request({
    url: '/lottery/openresultGs1mpcdd/' + id,
    method: 'get'
  })
}

// 新增1分PC蛋蛋
export function addOpenresultGs1mpcdd(data) {
  return request({
    url: '/lottery/openresultGs1mpcdd',
    method: 'post',
    data: data
  })
}

// 修改1分PC蛋蛋
export function updateOpenresultGs1mpcdd(data) {
  return request({
    url: '/lottery/openresultGs1mpcdd',
    method: 'put',
    data: data
  })
}

// 删除1分PC蛋蛋
export function delOpenresultGs1mpcdd(id) {
  return request({
    url: '/lottery/openresultGs1mpcdd/' + id,
    method: 'delete'
  })
}

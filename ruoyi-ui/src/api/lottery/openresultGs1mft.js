import request from '@/utils/request'

// 查询1分飞艇开奖列表
export function listOpenresultGs1mft(query) {
  return request({
    url: '/lottery/openresultGs1mft/list',
    method: 'get',
    params: query
  })
}

// 查询1分飞艇开奖详细
export function getOpenresultGs1mft(id) {
  return request({
    url: '/lottery/openresultGs1mft/' + id,
    method: 'get'
  })
}

// 新增1分飞艇开奖
export function addOpenresultGs1mft(data) {
  return request({
    url: '/lottery/openresultGs1mft',
    method: 'post',
    data: data
  })
}

// 修改1分飞艇开奖
export function updateOpenresultGs1mft(data) {
  return request({
    url: '/lottery/openresultGs1mft',
    method: 'put',
    data: data
  })
}

// 删除1分飞艇开奖
export function delOpenresultGs1mft(id) {
  return request({
    url: '/lottery/openresultGs1mft/' + id,
    method: 'delete'
  })
}

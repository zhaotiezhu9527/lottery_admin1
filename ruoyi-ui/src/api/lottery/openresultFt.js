import request from '@/utils/request'

// 查询开奖结果(飞艇)列表
export function listOpenresultFt(query) {
  return request({
    url: '/lottery/openresultFt/list',
    method: 'get',
    params: query
  })
}

// 查询开奖结果(飞艇)详细
export function getOpenresultFt(id) {
  return request({
    url: '/lottery/openresultFt/' + id,
    method: 'get'
  })
}

// 新增开奖结果(飞艇)
export function addOpenresultFt(data) {
  return request({
    url: '/lottery/openresultFt',
    method: 'post',
    data: data
  })
}

// 修改开奖结果(飞艇)
export function updateOpenresultFt(data) {
  return request({
    url: '/lottery/openresultFt',
    method: 'put',
    data: data
  })
}

// 删除开奖结果(飞艇)
export function delOpenresultFt(id) {
  return request({
    url: '/lottery/openresultFt/' + id,
    method: 'delete'
  })
}

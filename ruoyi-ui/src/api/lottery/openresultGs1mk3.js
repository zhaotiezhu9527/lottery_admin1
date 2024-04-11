import request from '@/utils/request'

// 查询开奖结果(GS1分快3)列表
export function listOpenresultGs1mk3(query) {
  return request({
    url: '/lottery/openresultGs1mk3/list',
    method: 'get',
    params: query
  })
}

// 查询开奖结果(GS1分快3)详细
export function getOpenresultGs1mk3(id) {
  return request({
    url: '/lottery/openresultGs1mk3/' + id,
    method: 'get'
  })
}

// 新增开奖结果(GS1分快3)
export function addOpenresultGs1mk3(data) {
  return request({
    url: '/lottery/openresultGs1mk3',
    method: 'post',
    data: data
  })
}

// 修改开奖结果(GS1分快3)
export function updateOpenresultGs1mk3(data) {
  return request({
    url: '/lottery/openresultGs1mk3',
    method: 'put',
    data: data
  })
}

// 删除开奖结果(GS1分快3)
export function delOpenresultGs1mk3(id) {
  return request({
    url: '/lottery/openresultGs1mk3/' + id,
    method: 'delete'
  })
}

import request from '@/utils/request'

// 查询开奖结果(GS1分PK10)列表
export function listOpenresultGs1mpk10(query) {
  return request({
    url: '/lottery/openresultGs1mpk10/list',
    method: 'get',
    params: query
  })
}

// 查询开奖结果(GS1分PK10)详细
export function getOpenresultGs1mpk10(id) {
  return request({
    url: '/lottery/openresultGs1mpk10/' + id,
    method: 'get'
  })
}

// 新增开奖结果(GS1分PK10)
export function addOpenresultGs1mpk10(data) {
  return request({
    url: '/lottery/openresultGs1mpk10',
    method: 'post',
    data: data
  })
}

// 修改开奖结果(GS1分PK10)
export function updateOpenresultGs1mpk10(data) {
  return request({
    url: '/lottery/openresultGs1mpk10',
    method: 'put',
    data: data
  })
}

// 删除开奖结果(GS1分PK10)
export function delOpenresultGs1mpk10(id) {
  return request({
    url: '/lottery/openresultGs1mpk10/' + id,
    method: 'delete'
  })
}

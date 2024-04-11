import request from '@/utils/request'

// 查询开奖结果(福彩3D)列表
export function listOpenresultFc3d(query) {
  return request({
    url: '/lottery/openresultFc3d/list',
    method: 'get',
    params: query
  })
}

// 查询开奖结果(福彩3D)详细
export function getOpenresultFc3d(id) {
  return request({
    url: '/lottery/openresultFc3d/' + id,
    method: 'get'
  })
}

// 新增开奖结果(福彩3D)
export function addOpenresultFc3d(data) {
  return request({
    url: '/lottery/openresultFc3d',
    method: 'post',
    data: data
  })
}

// 修改开奖结果(福彩3D)
export function updateOpenresultFc3d(data) {
  return request({
    url: '/lottery/openresultFc3d',
    method: 'put',
    data: data
  })
}

// 删除开奖结果(福彩3D)
export function delOpenresultFc3d(id) {
  return request({
    url: '/lottery/openresultFc3d/' + id,
    method: 'delete'
  })
}

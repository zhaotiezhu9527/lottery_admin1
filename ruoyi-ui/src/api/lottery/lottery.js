import request from '@/utils/request'

// 查询彩种管理列表
export function listLottery(query) {
  return request({
    url: '/lottery/lottery/list',
    method: 'get',
    params: query
  })
}

// 查询彩种管理详细
export function getLottery(id) {
  return request({
    url: '/lottery/lottery/' + id,
    method: 'get'
  })
}

// 新增彩种管理
export function addLottery(data) {
  return request({
    url: '/lottery/lottery',
    method: 'post',
    data: data
  })
}

// 修改彩种管理
export function updateLottery(data) {
  return request({
    url: '/lottery/lottery',
    method: 'put',
    data: data
  })
}

// 删除彩种管理
export function delLottery(id) {
  return request({
    url: '/lottery/lottery/' + id,
    method: 'delete'
  })
}

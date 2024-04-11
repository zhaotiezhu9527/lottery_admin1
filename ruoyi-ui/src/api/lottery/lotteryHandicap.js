import request from '@/utils/request'

// 查询盘口管理列表
export function listLotteryHandicap(query) {
  return request({
    url: '/lottery/lotteryHandicap/list',
    method: 'get',
    params: query
  })
}

// 查询盘口管理详细
export function getLotteryHandicap(id) {
  return request({
    url: '/lottery/lotteryHandicap/' + id,
    method: 'get'
  })
}

// 新增盘口管理
export function addLotteryHandicap(data) {
  return request({
    url: '/lottery/lotteryHandicap',
    method: 'post',
    data: data
  })
}

// 修改盘口管理
export function updateLotteryHandicap(data) {
  return request({
    url: '/lottery/lotteryHandicap',
    method: 'put',
    data: data
  })
}

// 删除盘口管理
export function delLotteryHandicap(id) {
  return request({
    url: '/lottery/lotteryHandicap/' + id,
    method: 'delete'
  })
}

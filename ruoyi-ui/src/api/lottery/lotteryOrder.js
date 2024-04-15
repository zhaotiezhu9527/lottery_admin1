import request from '@/utils/request'

// 查询投注记录列表
export function listLotteryOrder(query) {
  return request({
    url: '/lottery/lotteryOrder/list',
    method: 'get',
    params: query
  })
}

// 查询投注记录详细
export function getLotteryOrder(id) {
  return request({
    url: '/lottery/lotteryOrder/' + id,
    method: 'get'
  })
}

// 新增投注记录
export function addLotteryOrder(data) {
  return request({
    url: '/lottery/lotteryOrder',
    method: 'post',
    data: data
  })
}

// 修改投注记录
export function updateLotteryOrder(data) {
  return request({
    url: '/lottery/lotteryOrder',
    method: 'put',
    data: data
  })
}

// 删除投注记录
export function delLotteryOrder(id) {
  return request({
    url: '/lottery/lotteryOrder/' + id,
    method: 'delete'
  })
}

// 取消注单
export function lotteryOrderOrder(query) {
  return request({
    url: '/lottery/lotteryOrder/cancel/' + query,
    method: 'get',
  })
}

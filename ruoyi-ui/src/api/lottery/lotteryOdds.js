import request from '@/utils/request'

// 查询赔率设置列表
export function listLotteryOdds(query) {
  return request({
    url: '/lottery/lotteryOdds/list',
    method: 'get',
    params: query
  })
}

// 查询赔率设置详细
export function getLotteryOdds(id) {
  return request({
    url: '/lottery/lotteryOdds/' + id,
    method: 'get'
  })
}

// 新增赔率设置
export function addLotteryOdds(data) {
  return request({
    url: '/lottery/lotteryOdds',
    method: 'post',
    data: data
  })
}

// 修改赔率设置
export function updateLotteryOdds(data) {
  return request({
    url: '/lottery/lotteryOdds',
    method: 'put',
    data: data
  })
}

// 删除赔率设置
export function delLotteryOdds(id) {
  return request({
    url: '/lottery/lotteryOdds/' + id,
    method: 'delete'
  })
}
